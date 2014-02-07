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

import java.net.URI;
import java.net.URISyntaxException;

import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;
import com.atlassian.jira.rest.client.SearchRestClient;
import com.atlassian.jira.rest.client.UserRestClient;
import com.atlassian.jira.rest.client.domain.BasicIssue;
import com.atlassian.jira.rest.client.domain.SearchResult;
import com.atlassian.jira.rest.client.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class JiraUtil {

	public static void getDefaultSearch() throws JiraConnectionException {
		SearchRestClient searchClient = _getClient().getSearchClient();

		String sampleJql = "project = LPS AND status in (Open, Reopened, \"" +
			"In Progress\", \"Contributed Solution\", \"Community Resolved\"," +
			" Verified) AND \"Business Value\" is not EMPTY AND assignee in " +
			"(\"manuel.delapenya\", \"support-lep@liferay.com\") ORDER BY \"" +
			"Business Value\" DESC";

		Promise<SearchResult> promise = searchClient.searchJql(sampleJql);

		SearchResult searchResult = promise.claim();

		_log.info("Searching using JQL query has returned " +
			searchResult.getTotal() + " entries");

		for (BasicIssue issue : searchResult.getIssues()) {
			_log.info("Retrieving " + issue.getKey());
		}
	}

	public static User getJiraUserData() throws JiraConnectionException {
		UserRestClient userClient = _getClient().getUserClient();

		Promise<User> promise = userClient.getUser(
			PortletPropsValues.JIRA_USERNAME);

		User user = promise.claim();

		StringBundler sb = new StringBundler(8);

		sb.append("The name of ");
		sb.append(PortletPropsValues.JIRA_USERNAME);
		sb.append(" is ");
		sb.append(user.getName());
		sb.append("; his display name is ");
		sb.append(user.getDisplayName());
		sb.append("; and his small avatar uri is ");
		sb.append(user.getSmallAvatarUri());

		_log.info(sb.toString());

		return user;
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

	private static JiraRestClient _client;
	private static Log _log = LogFactoryUtil.getLog(JiraUtil.class);

}
