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
import com.atlassian.jira.rest.client.domain.Component;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;
import com.liferay.jira.metrics.util.JiraUtil;
import com.liferay.jira.metrics.util.PortletPropsKeys;
import com.liferay.jira.metrics.util.PortletPropsUtil;

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

	@Test
	public void getAllJiraStatuses() throws Exception {
		List<Status> jiraStatuses = JiraUtil.getAllJiraStatuses();

		Assert.assertNotNull(jiraStatuses);
		Assert.assertTrue(jiraStatuses.size() > 0);
	}

	@Test
	public void getJiraComponent() throws Exception {
		Project project = JiraUtil.getProject(_PROJECT_KEY);

		Iterable<BasicComponent> components = project.getComponents();
		Iterator<BasicComponent> componentsIterator = components.iterator();

		BasicComponent basicComponent = componentsIterator.next();

		Component component = JiraUtil.getComponent(basicComponent.getSelf());

		Assert.assertNotNull(
			"No component could be found with URI '" +
				basicComponent.getSelf() , component);

		Assert.assertNotNull(
			"The URI of the component '" + basicComponent.getSelf() +
				"' is empty", component.getSelf());

		Assert.assertEquals(
			"The URI of the component '" + basicComponent.getSelf() +
				"' is different of the URI of the component returned",
			basicComponent.getSelf(),
			component.getSelf());

		Assert.assertEquals(
			"The name of the component '" + basicComponent.getSelf() +
				"' is different of the name of the component returned",
			basicComponent.getName(), component.getName());

		Assert.assertEquals(
			"The description of the component '" + basicComponent.getSelf() +
				"' is different of the description of the component returned",
			basicComponent.getDescription(), component.getDescription());
	}

	@Test
	public void getJiraProject() throws Exception {
		Project project = JiraUtil.getProject(_PROJECT_KEY);

		Assert.assertNotNull(project);
		Assert.assertEquals(_PROJECT_KEY, project.getKey());
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

	@Test
	public void getJiraStatus() throws Exception {
		List<Status> statuses = JiraUtil.getAllJiraStatuses();

		Status status = statuses.get(0);

		Status currentStatus = JiraUtil.getStatus(status.getSelf());

		Assert.assertNotNull(
			"No status could be found with URI '" +
				status.getSelf() , currentStatus);

		Assert.assertEquals(
			"The name of the status '" + status.getSelf() +
				"' is different of the name of the status returned",
			status.getName(), currentStatus.getName());

		Assert.assertEquals(
			"The description of the status '" + status.getSelf() +
				"' is different of the description of the status returned",
			status.getDescription(), currentStatus.getDescription());
	}

	protected void mockPortletKey(String key) {
		PowerMockito.when(
			PortletPropsUtil.get(key)
		).thenReturn(
			TestPropsUtil.getValue(key)
		);
	}

	private static final String _PROJECT_KEY = "LPS";

}