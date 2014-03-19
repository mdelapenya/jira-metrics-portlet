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
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristina González
 */
public class JiraClientMock implements JiraClient {

	public static List<Priority> getMockPriorities() {
		List<Priority> priorities = new ArrayList<Priority>();
		priorities.add(_priority1);
		priorities.add(_priority2);
		priorities.add(null);
		return priorities;
	}

	public static Project getMockProject() {
		return _project;
	}

	public static List<Status> getMockStatuses() {
		List<Status> statuses = new ArrayList<Status>();
		statuses.add(_status1);
		statuses.add(_status2);
		return statuses;
	}

	@Override
	public List<BasicProject> getAllJiraProjects()
		throws JiraConnectionException {

		List<BasicProject> projects = new ArrayList<BasicProject>();

		projects.add(_basicProject);

		return projects;
	}

	@Override
	public List<Status> getAllJiraStatuses() throws JiraConnectionException {
		List<Status> statuses = new ArrayList<Status>();

		statuses.add(_status1);
		statuses.add(_status2);

		return statuses;
	}

	@Override
	public Component getComponent(URI componentURI)
		throws JiraConnectionException {

		if (
				(componentURI != null) &&
			componentURI.equals(_component1.getSelf())) {
			return _component1;
		} else if (
			(componentURI != null) &&
				componentURI.equals(_component2.getSelf())) {
			return _component2;
		}

		return null;
	}

	@Override
	public List<IssuesMetric> getIssuesMetricsByProjectStatus(
			String projectKey, List<String> statuses)
		throws JiraConnectionException {

		if (_project.getKey().equals(projectKey)) {
			return new ArrayList<IssuesMetric>();
		}

		List<IssuesMetric> issuesMetrics = new ArrayList<IssuesMetric>();

		int count = 1;

		for (BasicComponent component : _project.getComponents()) {
			for (Status status : getMockStatuses()) {
				for (Priority priority : getMockPriorities()) {
					issuesMetrics.add(
						new IssuesMetric(
							_project, component, status.getName(), priority,
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

		if ((projectKey != null) && projectKey.equals(_project.getKey())) {
			return _project;
		}

		return null;
	}

	@Override
	public Status getStatus(URI uri) throws JiraConnectionException {
		if ((uri != null) && uri.equals(_status1.getSelf())) {
			return _status1;
		} else if ((uri != null) && uri.equals(_status2.getSelf())) {
			return _status2;
		}

		return null;
	}

	protected static String JIRA_TEST_URI = "http://www.liferay.com/test/";

	private static BasicProject _basicProject;
	private static Component _component1;
	private static Component _component2;
	private static Priority _priority1;
	private static Priority _priority2;
	private static Project _project;
	private static Status _status1;
	private static Status _status2;


	static {

		try {
			URI projectURI = new URI(JIRA_TEST_URI + "Project/1");

			_basicProject = new BasicProject(projectURI, "Project1", "Project 1");

			URI componenteURI1 = new URI(JIRA_TEST_URI + "Component/1");
			URI componenteURI2 = new URI(JIRA_TEST_URI + "Component/2");

			_component1 = new Component(
				componenteURI1, 1L, "Component1", "Component 1", null);
			_component2 = new Component(
				componenteURI2, 2L, "Component2", "Component 2", null);

			List<BasicComponent> components = new ArrayList<BasicComponent>();
			components.add(_component1);
			components.add(_component2);

			_project = new Project(
				_basicProject.getSelf(), _basicProject.getKey(),
				_basicProject.getName(),
				"Description " + _basicProject.getName(), null, projectURI,
				null, components, null, null);

			URI statusURI1 = new URI(JIRA_TEST_URI + "Status/1");
			URI statusURI2 = new URI(JIRA_TEST_URI + "Status/2");

			_status1 = new Status(statusURI1, "Status1", "Status 1", null);
			_status2 = new Status(statusURI2, "Status2", "Status 2", null);

			URI priorityURI1 = new URI(JIRA_TEST_URI + "Priority/1");
			URI priorityURI2 = new URI(JIRA_TEST_URI + "Priority/2");

			_priority1 = new Priority(priorityURI1, 1L, "1", null, null, null);
			_priority2 = new Priority(priorityURI2, 2L, "2", null, null, null);

		}
		catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}