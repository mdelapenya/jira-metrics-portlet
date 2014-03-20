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

import com.atlassian.jira.rest.client.RestClientException;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import com.liferay.jira.metrics.client.JiraClient;
import com.liferay.jira.metrics.client.JiraClientImpl;

import java.net.URI;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PortletPropsUtil.class})
@PowerMockIgnore({"javax.net.ssl.*", "javax.security.auth.*"})
public class JiraClientTest  extends PowerMockito {

	@Test
	public void getAllJiraProjects() throws Exception {
		List<BasicProject> projects = _jiraClient.getAllJiraProjects();

		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}

	@Test
	public void getAllJiraStatuses() throws Exception {
		List<Status> jiraStatuses = _jiraClient.getAllJiraStatuses();

		Assert.assertNotNull(jiraStatuses);
		Assert.assertTrue(jiraStatuses.size() > 0);
	}

	@Test
	public void getJiraComponent() throws Exception {
		Project project = _jiraClient.getProject(_PROJECT_KEY);

		Iterable<BasicComponent> components = project.getComponents();
		Iterator<BasicComponent> componentsIterator = components.iterator();

		BasicComponent basicComponent = componentsIterator.next();

		Component component = _jiraClient.getComponent(
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
			_jiraClient.getComponent(
				new URI(
					"https://issues.liferay.com/rest/api/latest/component/-9"));
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"The component with id -9 does not exist.", rce.getMessage());
		}
	}

	@Test
	public void getJiraProject() throws Exception {
		Project project = _jiraClient.getProject(_PROJECT_KEY);

		Assert.assertNotNull(project);
		Assert.assertEquals(_PROJECT_KEY, project.getKey());
	}

	@Test
	public void getJiraProjectNotFound() throws Exception {
		try {
			_jiraClient.getProject("asdfghj");
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"No project could be found with key 'asdfghj'.",
				rce.getMessage());
		}
	}

	@Test
	public void getJiraStatus() throws Exception {
		List<Status> statuses = _jiraClient.getAllJiraStatuses();

		Status status = statuses.get(0);

		Status currentStatus = _jiraClient.getStatus(status.getSelf());

		Assert.assertNotNull(currentStatus);
		Assert.assertEquals(status.getName(), currentStatus.getName());
		Assert.assertEquals(
			status.getDescription(), currentStatus.getDescription());
	}

	@Test
	public void getJiraStatusNotFound() throws Exception {
		String statusId = _STATUS_NAME + "NotFound";

		try {
			_jiraClient.getStatus(new URI(_STATUS_URI + statusId));
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"The status with id '" + statusId + "' does not exist",
				rce.getMessage());
		}
	}

	@Before
	public void setUp() {
		if (_jiraClient == null) {
			_jiraClient = new JiraClientImpl();
		}

		mockStatic(PortletPropsUtil.class);

		mockPortletKey(PortletPropsKeys.JIRA_USERNAME);
		mockPortletKey(PortletPropsKeys.JIRA_PASSWORD);
		mockPortletKey(PortletPropsKeys.JIRA_BASE_QUERY);
		mockPortletKey(PortletPropsKeys.JIRA_SERVER_URI);
	}

	@After
	public void tearDown() {
		verifyStatic();
	}

	protected void mockPortletKey(String key) {
		PowerMockito.when(
			PortletPropsUtil.get(key)
		).thenReturn(
			TestPropsUtil.getValue(key)
		);
	}

	private static final String _PROJECT_KEY = "LPS";

	private static final String _STATUS_NAME = "3";

	private static final String _STATUS_URI =
		TestPropsUtil.getValue(PortletPropsKeys.JIRA_SERVER_URI) +
			TestPropsUtil.getValue(PortletPropsKeys.JIRA_REST_API_SUFFIX);

	private static JiraClient _jiraClient;

}