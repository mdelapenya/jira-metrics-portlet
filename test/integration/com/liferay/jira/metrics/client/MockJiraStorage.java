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

	public MockJiraStorage() {
	}

	public List<BasicComponent> getMockComponents() {
		return getMockComponents(2);
	}

	public List<BasicComponent> getMockComponents(int count) {
		if (_components != null) {
			return _components;
		}

		_components = new ArrayList<BasicComponent>();

		for (int i = 0; i < count; i++) {
			_components.add(_newComponent(i + 1));
		}

		return _components;
	}

	public List<Priority> getMockPriorities() {
		return getMockPriorities(2);
	}

	public List<Priority> getMockPriorities(int count) {
		if (_priorities != null) {
			return _priorities;
		}

		_priorities = new ArrayList<Priority>();

		for (int i = 0; i < count; i++) {
			_priorities.add(_newPriority(i + 1));
		}

		return _priorities;
	}

	public Project getMockProject() {
		if (_project != null) {
			return _project;
		}

		_project = _newProject(1, 2);

		return _project;
	}

	public List<Status> getMockStatuses() {
		return getMockStatuses(2);
	}

	public List<Status> getMockStatuses(int count) {
		if (_statuses != null) {
			return _statuses;
		}

		_statuses = new ArrayList<Status>();

		for (int i = 0; i < count; i++) {
			_statuses.add(_newStatus(i + 1));
		}

		return _statuses;
	}

	protected static String JIRA_TEST_URI = "http://www.liferay.com/test/";

	private Component _newComponent(int id) {
		String componentKeyword = "component";
		String name = componentKeyword + id;

		try {
			URI componentURI = new URI(
				JIRA_TEST_URI + componentKeyword + "/" + id);

			return new Component(
				componentURI, Long.valueOf(id), name, name, null);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Priority _newPriority(int id) {
		String priorityKeyword = "priority";
		String idString = String.valueOf(id);

		try {
			URI priorityURI = new URI(
				JIRA_TEST_URI + priorityKeyword + "/" + id);

			return new Priority(
				priorityURI, Long.valueOf(id), idString, null, null, null);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Project _newProject(int id, int componentsCount) {
		String projectKeyword = "project";
		String name = projectKeyword + id;

		try {
			URI projectURI = new URI(JIRA_TEST_URI + projectKeyword + "/" + id);

			List<BasicComponent> components = getMockComponents(
				componentsCount);

			return new Project(
				projectURI, name, name, "Description " + name, null, projectURI,
				null, components, null, null);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Status _newStatus(int id) {
		String statusKeyword = "status";
		String name = statusKeyword + id;

		try {
			URI statusURI = new URI(JIRA_TEST_URI + statusKeyword + "/" + id);

			return new Status(statusURI, name, name, null);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	private List<BasicComponent> _components;
	private List<Priority> _priorities;
	private Project _project;
	private List<Status> _statuses;

}