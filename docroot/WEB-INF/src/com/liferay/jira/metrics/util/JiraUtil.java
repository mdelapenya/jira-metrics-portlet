/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.jira.metrics.util;

import com.atlassian.jira.rest.client.ComponentRestClient;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;
import com.atlassian.jira.rest.client.MetadataRestClient;
import com.atlassian.jira.rest.client.ProjectRestClient;
import com.atlassian.jira.rest.client.SearchRestClient;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.SearchResult;
import com.atlassian.jira.rest.client.domain.Status;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

import com.google.common.collect.Lists;

import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class JiraUtil {

	public static List<BasicProject> getAllJiraProjects()
		throws JiraConnectionException {

		ProjectRestClient projectClient = _getClient().getProjectClient();

		Promise<Iterable<BasicProject>> promise =
			projectClient.getAllProjects();

		Iterable<BasicProject> basicProjects = promise.claim();

		return Lists.newArrayList(basicProjects);
	}

	public static List<Status> getAllJiraStatuses()
		throws JiraConnectionException {

		String output = getJiraRestResponse(getJiraURL() + _STATUS_API);

		List<Status> statuses = new ArrayList<Status>();

		try {
			JSONArray arrayResponse = new JSONArray(output);

			for (int i = 0; i < arrayResponse.length() - 1; i++) {
				statuses.add(toStatus(arrayResponse.getJSONObject(i)));
			}
		} catch (Exception e) {
			_log.error("Error: " + e.getMessage(), e);

			throw new RuntimeException("Exception " + e.getMessage(), e);
		}

		return statuses;
	}

	public static Component getComponent(URI componentURI)
		throws JiraConnectionException {

		ComponentRestClient componentClient = _getClient().getComponentClient();

		Promise<Component> promise = componentClient.getComponent(componentURI);

		return promise.claim();
	}

	public static List<IssuesMetric> getIssuesMetricsByProjectStatus(
			String projectKey, List<String> statusNames)
		throws JiraConnectionException {

		MetadataRestClient metaClient = _getClient().getMetadataClient();

		Iterable<Priority> priorities = metaClient.getPriorities().claim();

		if (statusNames == null || statusNames.isEmpty()) {
			throw new RuntimeException("The statuses can't be empty");
		}

		List<IssuesMetric> results = new ArrayList<IssuesMetric>();

		Project project = getProject(projectKey);

		List<BasicComponent> components = Lists.newArrayList(
			project.getComponents());

		for (String statusName : statusNames) {
			for (BasicComponent component : components) {

				int total =
					getIssuesMetricsByProjectStatusComponentPriority(
						project, statusName, component, null);

				if(_log.isDebugEnabled()) {
					_log.debug(
						"[" + project.getKey() + "]" + "[" +
							component.getName() + "]" + "[" + statusName +
							"]" + "[EMPTY] = " + total);
				}

				results.add(
					new IssuesMetric(
						project, component, statusName, null, total));

				for (Priority priority : priorities) {

					total =
						getIssuesMetricsByProjectStatusComponentPriority(
							project, statusName, component, priority);

					if(_log.isDebugEnabled()) {
						_log.debug(
							"[" + project.getKey() + "]" + "[" +
								component.getName() + "]" + "[" + statusName +
								"]" + "["+priority.getId() + "] = " + total);
					}

					results.add(
						new IssuesMetric(
							project, component, statusName, priority, total));
				}
			}
		}

		return results;
	}

	public static Project getProject(String projectKey)
		throws JiraConnectionException {

		ProjectRestClient projectClient = _getClient().getProjectClient();

		Promise<Project> promise = projectClient.getProject(projectKey);

		return promise.claim();
	}

	public static Status getStatus(URI uri) throws JiraConnectionException {
		MetadataRestClient metadataClient = _getClient().getMetadataClient();

		Promise<Status> promise = metadataClient.getStatus(uri);

		return promise.claim();
	}

	protected static String getBase64Auth() {
		StringBundler sb = new StringBundler(3);

		sb.append(PortletPropsValues.JIRA_USERNAME);
		sb.append(StringPool.COLON);
		sb.append(PortletPropsValues.JIRA_PASSWORD);

		return new String(Base64.encode(sb.toString()));
	}

	protected static int getIssuesMetricsByProjectStatusComponentPriority(
			Project project, String statusName, BasicComponent component,
			Priority priority)
		throws JiraConnectionException {

		StringBundler sb = new StringBundler(19);

		sb.append(PortletPropsValues.JIRA_BASE_QUERY);
		sb.append(" AND project = ");
		sb.append(project.getKey());
		sb.append(" AND status = ");
		sb.append(StringPool.QUOTE);
		sb.append(statusName);
		sb.append(StringPool.QUOTE);
		sb.append(" AND component = ");
		sb.append(StringPool.QUOTE);
		sb.append(component.getName());
		sb.append(StringPool.QUOTE);
		sb.append(" AND ");
		sb.append(StringPool.QUOTE);
		sb.append("Fix Priority");
		sb.append(StringPool.QUOTE);

		if(priority == null) {
			sb.append(" IS EMPTY");
		}
		else {
			sb.append(" = ");
			sb.append(StringPool.QUOTE);
			sb.append(priority.getId());
			sb.append(StringPool.QUOTE);
		}

		SearchRestClient searchClient = _getClient().getSearchClient();

		Promise<SearchResult> promise = searchClient.searchJql(sb.toString());

		SearchResult result = promise.claim();

		return result.getTotal();
	}

	protected static String getJiraRestResponse(String restURL)
		throws JiraConnectionException {

		Client client = Client.create();

		WebResource webResource = client.resource(restURL);

		WebResource.Builder headerBuilder = webResource.header(
			_AUTHORIZATION, _AUTHORIZATION_TYPE + getBase64Auth());

		WebResource.Builder typeBuilder = headerBuilder.type(
			MediaType.APPLICATION_JSON);

		WebResource.Builder responseBuilder = typeBuilder.accept(
			MediaType.APPLICATION_JSON);

		ClientResponse response = responseBuilder.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new JiraConnectionException(
				"Failed to connect to JIRA Rest API " + restURL +
					" " + response.getStatus());
		}

		return response.getEntity(String.class);
	}

	protected static String getJiraURL() {
		String jiraURL = PortletPropsValues.JIRA_SERVER_URI;

		if (!jiraURL.endsWith(StringPool.SLASH)) {
			jiraURL += StringPool.SLASH;
		}

		return jiraURL;
	}

	protected static Status toStatus(JSONObject jsonObject)
		throws JSONException, URISyntaxException {

		URI self = new URI(jsonObject.getString("self"));

		String name = jsonObject.getString("name");

		String description = jsonObject.getString("description");

		URI iconUrl = new URI(jsonObject.getString("iconUrl"));

		return new Status(self, name, description, iconUrl);
	}

	private static JiraRestClient _getClient() throws JiraConnectionException {
		if (_client == null) {
			JiraRestClientFactory factory =
				new AsynchronousJiraRestClientFactory();

			try {
				_client = factory.createWithBasicHttpAuthentication(
					new URI(PortletPropsValues.JIRA_SERVER_URI),
					PortletPropsValues.JIRA_USERNAME,
					PortletPropsValues.JIRA_PASSWORD);
			}
			catch (URISyntaxException e) {
				throw new JiraConnectionException(
					"Could not understand the JIRA Base URL: " + e.getMessage(),
					e);
			}
		}

		return _client;
	}

	private static final String _AUTHORIZATION = "Authorization";

	private static final String _AUTHORIZATION_TYPE = "Basic ";

	private static final String _STATUS_API = "rest/api/2/status";

	private static Log _log = LogFactoryUtil.getLog(JiraUtil.class);

	private static JiraRestClient _client;

}