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
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class JiraUtil {

	public static List<Project> getAllJiraProjects()
		throws JiraConnectionException {

		ProjectRestClient projectClient = _getClient().getProjectClient();

		Iterable<BasicProject> basicProjects =
			projectClient.getAllProjects().claim();

		List<Project> projects = new ArrayList();

		for (BasicProject basicProject : basicProjects) {
			projects.add(projectClient.getProject(basicProject.getKey()).claim());
		}

		return projects;
	}

	public static List<Status> getAllJiraStatuses()
		throws JiraConnectionException {

		String auth = new String(
			Base64.encode(
				PortletPropsValues.JIRA_USERNAME+":" +
					PortletPropsValues.JIRA_PASSWORD));

		Client client = Client.create();

		String restStatusURL = PortletPropsValues.JIRA_SERVER_URI;

		if (!restStatusURL.endsWith(StringPool.SLASH)) {
			restStatusURL += StringPool.SLASH;
		}

		restStatusURL += "rest/api/2/status";

		WebResource webResource = client.resource(restStatusURL);

		ClientResponse response = webResource.header(
			"Authorization", "Basic " + auth).
				type("application/json").
					accept("application/json"). get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new JiraConnectionException(
					"Failed to connect to JIRA Rest API " + restStatusURL +
						" " + response.getStatus());
		}

		String output = response.getEntity(String.class);

		List<Status> statuses = new ArrayList<Status>();

		try {
			JSONArray arrayResponse = new JSONArray(output);

			for (int i = 0; i < arrayResponse.length() - 1; i++) {
				JSONObject statusRestObject = arrayResponse.getJSONObject(i);

				URI self = new URI(statusRestObject.getString("self"));
				String name = statusRestObject.getString("name");
				String description = statusRestObject.getString("description");
				URI iconUrl = new URI(statusRestObject.getString("iconUrl"));

				Status status = new Status(self, name, description, iconUrl);

				statuses.add(status);
			}

		} catch (JSONException e) {
			throw new RuntimeException("JSONException " + e.getMessage(), e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(
				"URISyntaxException " + e.getMessage(), e);
		}

		return statuses;
	}

	public static Component getComponent(URI componentURI)
		throws JiraConnectionException {

		ComponentRestClient componentClient = _getClient().getComponentClient();

		Promise<Component> promise = componentClient.getComponent(componentURI);

		return promise.claim();
	}

	public static List<TotalIssues> getIssuesCountByProjectStatus(
			Project project, List<Status> statuses)
		throws JiraConnectionException {

		MetadataRestClient metaClient = _getClient().getMetadataClient();

		Iterable<Priority> priorities = metaClient.getPriorities().claim();

		if (statuses == null || statuses.isEmpty()) {
			throw new RuntimeException("The statuses can't be empty");
		}

		List<TotalIssues> results = new ArrayList<TotalIssues>();

		for (Status status : statuses) {

			for (BasicComponent basicComponent : project.getComponents()) {
				Component component = getComponent(basicComponent.getSelf());

				for (Priority priority : priorities) {

					int total = getIssuesCountByProjectStatusComponentPriority(
						project, status, component, priority);

					results.add(new TotalIssues(
						project, component, status, priority, total));
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

	protected static int getIssuesCountByProjectStatusComponentPriority(
			Project project, Status status, Component component,
			Priority priority)
		throws JiraConnectionException {

		SearchRestClient searchClient = _getClient().getSearchClient();

		String jql =
			PortletPropsValues.JIRA_BASE_QUERY +
				" AND project = "+project.getKey() +
					" AND status = \""+status.getName() +"\"" +
						" AND component = \""+component.getName() +"\"" +
							" AND \"Fix Priority\" = \""+priority.getId() +"\"";

		SearchResult result = searchClient.searchJql(jql).claim();

		return result.getTotal();
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

	private static Log _log = LogFactoryUtil.getLog(JiraUtil.class);

	private static JiraRestClient _client;

}