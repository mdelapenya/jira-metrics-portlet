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

import com.atlassian.jira.rest.client.domain.BasicProject;
import com.liferay.jira.metrics.util.JiraUtil;
import com.liferay.jira.metrics.util.PortletPropsKeys;
import com.liferay.jira.metrics.util.PortletPropsUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

/**
 * @author Cristina González
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PortletPropsUtil.class})
@PowerMockIgnore({"javax.net.ssl.*", "javax.security.auth.*"})
public class JiraUtilTest  extends PowerMockito {

	@Test
	public void getAllJiraPriorities() throws Exception {

		List<BasicProject> projects = JiraUtil.getAllJiraProjects();

		Assert.assertNotNull(projects);
		Assert.assertTrue(projects.size() > 0);
	}

	@Before
	public void setUp() {
		mockStatic(PortletPropsUtil.class);

		PowerMockito.when(
			PortletPropsUtil.get(PortletPropsKeys.JIRA_USERNAME)).thenReturn(
			TestPropsUtil.getValue(PortletPropsKeys.JIRA_USERNAME));
		PowerMockito.when(
			PortletPropsUtil.get(PortletPropsKeys.JIRA_PASSWORD)).thenReturn(
			TestPropsUtil.getValue(PortletPropsKeys.JIRA_PASSWORD));
		PowerMockito.when
			(PortletPropsUtil.get(PortletPropsKeys.JIRA_BASE_QUERY)).thenReturn(
			TestPropsUtil.getValue(PortletPropsKeys.JIRA_BASE_QUERY));
		PowerMockito.when
			(PortletPropsUtil.get(PortletPropsKeys.JIRA_SERVER_URI)).thenReturn(
			TestPropsUtil.getValue(PortletPropsKeys.JIRA_SERVER_URI));
	}

	@After
	public void tearDown() {
		verifyStatic();
	}

}