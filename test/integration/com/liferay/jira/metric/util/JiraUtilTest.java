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
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;
import com.liferay.jira.metrics.util.JiraUtil;
import com.liferay.jira.metrics.util.PortletPropsKeys;
import com.liferay.jira.metrics.util.PortletPropsUtil;

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

	protected void mockPortletKey(String key) {
		PowerMockito.when(
			PortletPropsUtil.get(key)
		).thenReturn(
			TestPropsUtil.getValue(key)
		);
	}

	private static final String _PROJECT_KEY = "LPS";

}