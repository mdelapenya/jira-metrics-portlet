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

import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

/**
 * @author Cristina González
 */
public class IssuesMetric {

	public IssuesMetric(
		Project project, Component component, Status status, Priority priority,
		int total) {

		_project = project;

		_priority = priority;

		_component = component;

		_total = total;

		_status = status;
	}

	public Component getComponent() {
		return _component;
	}

	public Priority getPriority() {
		return _priority;
	}

	public Project getProject() {
		return _project;
	}

	public Status getStatus() {
		return _status;
	}

	public int getTotal() {
		return _total;
	}

	private Component _component;
	private Priority _priority;
	private Project _project;
	private Status _status;
	private int _total;

}