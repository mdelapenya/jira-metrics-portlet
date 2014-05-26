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

import com.atlassian.jira.rest.client.RestClientException;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import java.net.URI;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Cristina González
 */
public abstract class BaseJiraClientTestCase {

	@Test
	public void getAllJiraProjects() throws Exception {
		List<BasicProject> projects = getJiraClient().getAllJiraProjects();

		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}

	@Test
	public void getAllJiraStatuses() throws Exception {
		List<Status> jiraStatuses = getJiraClient().getAllJiraStatuses();

		Assert.assertNotNull(jiraStatuses);
		Assert.assertTrue(jiraStatuses.size() > 0);
	}

	@Test
	public void getJiraComponent() throws Exception {
		Project project = getJiraClient().getProject(getProjectKey());

		Iterable<BasicComponent> components = project.getComponents();
		Iterator<BasicComponent> componentsIterator = components.iterator();

		BasicComponent basicComponent = componentsIterator.next();

		Component component = getJiraClient().getComponent(
			basicComponent.getSelf());

		Assert.assertNotNull(component);
		Assert.assertNotNull(component.getSelf());
		Assert.assertEquals(basicComponent.getSelf(), component.getSelf());
		Assert.assertEquals(basicComponent.getName(), component.getName());
		Assert.assertEquals(
			basicComponent.getDescription(), component.getDescription());
	}

	@Test
	public void getJiraComponentNotFound() throws Exception {
		try {
			getJiraClient().getComponent(new URI(getUriComponent() + "-9"));
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"The component with id -9 does not exist.", rce.getMessage());
		}
	}

	@Test
	public void getJiraProject() throws Exception {
		Project project = getJiraClient().getProject(getProjectKey());

		Assert.assertNotNull(project);
		Assert.assertEquals(getProjectKey(), project.getKey());
	}

	@Test
	public void getJiraProjectNotFound() throws Exception {
		try {
			getJiraClient().getProject("asdfghj");
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"No project could be found with key 'asdfghj'.",
				rce.getMessage());
		}
	}

	@Test
	public void getJiraStatus() throws Exception {
		List<Status> statuses = getJiraClient().getAllJiraStatuses();

		Status status = statuses.get(0);

		Status currentStatus = getJiraClient().getStatus(status.getSelf());

		Assert.assertNotNull(currentStatus);
		Assert.assertEquals(status.getName(), currentStatus.getName());
		Assert.assertEquals(
			status.getDescription(), currentStatus.getDescription());
	}

	@Test
	public void getJiraStatusNotFound() throws Exception {
		String statusId = getStatusName() + "NotFound";

		try {
			getJiraClient().getStatus(new URI(getUriStatus() + statusId));
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"The status with id '" + statusId + "' does not exist",
				rce.getMessage());
		}
	}

	protected abstract JiraClient getJiraClient();

	protected abstract String getProjectKey();

	protected abstract String getStatusName();

	protected abstract String getUriComponent();

	protected abstract String getUriStatus();

}