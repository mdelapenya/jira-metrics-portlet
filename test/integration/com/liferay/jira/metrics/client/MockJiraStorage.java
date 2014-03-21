/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class MockJiraStorage {

	protected static String JIRA_TEST_URI = "http://www.liferay.com/test/";

	public MockJiraStorage() {
		try {
			URI projectURI = new URI(JIRA_TEST_URI + "Project/1");

			URI componentURI1 = new URI(JIRA_TEST_URI + "Component/1");
			URI componentURI2 = new URI(JIRA_TEST_URI + "Component/2");

			_component1 = new Component(
				componentURI1, 1L, "Component1", "Component 1", null);
			_component2 = new Component(
				componentURI2, 2L, "Component2", "Component 2", null);

			List<BasicComponent> components = new ArrayList<BasicComponent>();
			components.add(_component1);
			components.add(_component2);

			_project = new Project(
				projectURI, "Project1", "Project 1", "Description Project1",
				null, projectURI, null, components, null, null);

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

	public List<Priority> getMockPriorities() {
		List<Priority> priorities = new ArrayList<Priority>();

		priorities.add(_priority1);
		priorities.add(_priority2);
		priorities.add(null);

		return priorities;
	}

	public Project getMockProject() {
		return _project;
	}

	public List<Status> getMockStatuses() {
		List<Status> statuses = new ArrayList<Status>();

		statuses.add(_status1);
		statuses.add(_status2);

		return statuses;
	}

	private Component _component1;
	private Component _component2;
	private Priority _priority1;
	private Priority _priority2;
	private Project _project;
	private Status _status1;
	private Status _status2;

}