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

package com.liferay.jira.metric.util;

import com.atlassian.jira.rest.client.RestClientException;
import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import com.google.common.collect.Lists;

import com.liferay.jira.metrics.util.IssuesMetric;
import com.liferay.jira.metrics.util.JiraUtil;
import com.liferay.jira.metrics.util.PortletPropsKeys;
import com.liferay.jira.metrics.util.PortletPropsUtil;

import java.util.List;


import java.net.URI;

import java.util.ArrayList;
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
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PortletPropsUtil.class})
@PowerMockIgnore({"javax.net.ssl.*", "javax.security.auth.*"})
public class JiraUtilTest  extends PowerMockito {

	@Before
	public void setUp() {
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

	@Test
	public void getAllJiraProjects() throws Exception {
		List<BasicProject> projects = JiraUtil.getAllJiraProjects();

		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}

	public void getAllJiraStatuses() throws Exception {
		List<Status> statuses = JiraUtil.getAllJiraStatuses();

		Assert.assertNotNull(statuses);

		Assert.assertTrue(statuses.size() > 0);
	}

	@Test
	public void getComponent() throws Exception {
		Project project = JiraUtil.getProject(_PROJECT_KEY);

		Iterable<BasicComponent> components = project.getComponents();
		Iterator<BasicComponent> componentsIterator = components.iterator();

		BasicComponent basicComponent = componentsIterator.next();

		Component component = JiraUtil.getComponent(basicComponent.getSelf());

		Assert.assertNotNull(component);

		Assert.assertNotNull(component.getSelf());

		Assert.assertEquals(basicComponent.getSelf(), component.getSelf());

		Assert.assertEquals(basicComponent.getName(), component.getName());

		Assert.assertEquals(
			basicComponent.getDescription(), component.getDescription());
	}

	@Test
	public void getIssuesMetricsByProjectStatus() throws Exception {
		Project project = JiraUtil.getProject(_PROJECT_KEY);

		Iterable<BasicComponent> basicComponentsIterable =
			project.getComponents();

		List<BasicComponent> basicComponentsList = Lists.newArrayList(
			basicComponentsIterable);

		Status status = JiraUtil.getStatus(new URI(_STATUS_URI));

		List<Status> statuses = new ArrayList<Status>();

		statuses.add(status);

		List<IssuesMetric> jiraMetrics =
			JiraUtil.getIssuesMetricsByProjectStatus(project, statuses);

		Assert.assertEquals(
			basicComponentsList.size() * _PRIORITY_SIZE, jiraMetrics.size());
	}

	@Test
	public void getProject() throws Exception {
		Project project = JiraUtil.getProject(_PROJECT_KEY);

		Assert.assertNotNull(project);

		Assert.assertNotNull(project.getKey());

		Assert.assertEquals(_PROJECT_KEY, project.getKey());
	}

	@Test
	public void getStatus() throws Exception {
		List<Status> statuses = JiraUtil.getAllJiraStatuses();

		Status status = statuses.get(0);

		Status currentStatus = JiraUtil.getStatus(status.getSelf());

		Assert.assertNotNull(currentStatus);

		Assert.assertEquals(status.getName(), currentStatus.getName());

		Assert.assertEquals(
			status.getDescription(), currentStatus.getDescription());
	}

	@Before
	public void setUp() {
		mockStatic(PortletPropsUtil.class);

		Assert.assertNotNull(jiraStatuses);
		Assert.assertTrue(jiraStatuses.size() > 0);
	}

	@Test
	public void getJiraProject() throws Exception {
		Project project = JiraUtil.getProject("LPS");

		Assert.assertNotNull(project);
		Assert.assertEquals("LPS", project.getKey());
	}

	@Test
	public void getJiraProjectNotFound() throws Exception {
		try {
			JiraUtil.getProject("asdfghj");
		}
		catch (RestClientException rce) {
			Assert.assertEquals(
				"No project could be found with key 'asdfghj'.",
				rce.getMessage());
		}
	}

	protected void mockPortletKey(String key) {
		PowerMockito.when(
			PortletPropsUtil.get(key)
		).thenReturn(
			TestPropsUtil.getValue(key)
		);
	}

	private static final int _PRIORITY_SIZE = 5;

	private static final String _PROJECT_KEY = "LPS";

	private static final String _STATUS_URI =
		"https://issues.liferay.com/rest/api/2/status/3";

}