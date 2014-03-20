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

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.util.IssuesMetric;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class MockJiraClientImpl implements JiraClient {

	@Override
	public List<BasicProject> getAllJiraProjects()
		throws JiraConnectionException {

		List<BasicProject> projects = new ArrayList<BasicProject>();

		projects.add(_mockProject);

		return projects;
	}

	@Override
	public List<Status> getAllJiraStatuses() throws JiraConnectionException {
		return _mockJiraStorage.getMockStatuses();
	}

	@Override
	public Component getComponent(URI componentURI)
		throws JiraConnectionException {

		if (componentURI == null) {
			throw new JiraConnectionException("Component URI cannot be null.");
		}

		for (BasicComponent mockComponent : _mockProject.getComponents()) {
			URI mockComponentSelf = mockComponent.getSelf();

			if (mockComponentSelf.equals(componentURI)) {
				return (Component)mockComponent;
			}
		}

		throw new JiraConnectionException("Component URI has not been found.");
	}

	@Override
	public List<IssuesMetric> getIssuesMetricsByProjectStatus(
			String projectKey, List<String> statuses)
		throws JiraConnectionException {

		String mockProjectKey = _mockProject.getKey();

		if (mockProjectKey.equals(projectKey)) {
			return new ArrayList<IssuesMetric>();
		}

		List<IssuesMetric> issuesMetrics = new ArrayList<IssuesMetric>();

		int count = 1;

		for (BasicComponent component : _mockProject.getComponents()) {
			for (Status status : _mockJiraStorage.getMockStatuses()) {
				for (Priority priority : _mockJiraStorage.getMockPriorities()) {
					issuesMetrics.add(
						new IssuesMetric(
							_mockProject, component, status.getName(), priority,
							count));

					count++;
				}
			}
		}

		return issuesMetrics;
	}

	@Override
	public Project getProject(String projectKey)
		throws JiraConnectionException {

		if (projectKey == null) {
			throw new JiraConnectionException("Project key cannot be null.");
		}

		if (projectKey.equals(_mockProject.getKey())) {
			return _mockProject;
		}

		throw new JiraConnectionException(
			"Project with key " + projectKey + " has not been found.");
	}

	@Override
	public Status getStatus(URI statusUri) throws JiraConnectionException {
		if (statusUri == null) {
			throw new JiraConnectionException("Status URI cannot be null.");
		}

		for (Status mockStatus : _mockJiraStorage.getMockStatuses()) {
			URI mockStatusSelf = mockStatus.getSelf();

			if (mockStatusSelf.equals(statusUri)) {
				return mockStatus;
			}
		}

		throw new JiraConnectionException("Status URI has not been found.");
	}

	private static MockJiraStorage _mockJiraStorage = new MockJiraStorage();

	private static Project _mockProject = _mockJiraStorage.getMockProject();

}