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
package com.liferay.jira.metrics.client;

import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.util.IssuesMetric;

import java.net.URI;
import java.util.List;

/**
 * @author Cristina González
 */
public interface JiraClient {


	public  List<BasicProject> getAllJiraProjects()
		throws JiraConnectionException;

	public List<Status> getAllJiraStatuses()
		throws JiraConnectionException;

	public Component getComponent(URI componentURI)
		throws JiraConnectionException;

	public List<IssuesMetric> getIssuesMetricsByProjectStatus(
			String projectKey, List<String> statusNames)
		throws JiraConnectionException;

	public Project getProject(String projectKey)
		throws JiraConnectionException;

	public Status getStatus(URI uri) throws JiraConnectionException;
}
