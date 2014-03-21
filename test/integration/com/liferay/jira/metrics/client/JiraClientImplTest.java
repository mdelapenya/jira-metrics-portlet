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

import com.liferay.jira.metrics.util.PortletPropsKeys;
import com.liferay.jira.metrics.util.PortletPropsUtil;
import com.liferay.jira.metrics.util.TestPropsUtil;

import org.junit.After;
import org.junit.Before;
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
public class JiraClientImplTest  extends BaseJiraClientTestCase {

	@Before
	public void setUp() {
		PowerMockito.mockStatic(PortletPropsUtil.class);

		mockPortletKey(PortletPropsKeys.JIRA_USERNAME);
		mockPortletKey(PortletPropsKeys.JIRA_PASSWORD);
		mockPortletKey(PortletPropsKeys.JIRA_BASE_QUERY);
		mockPortletKey(PortletPropsKeys.JIRA_SERVER_URI);
	}

	@After
	public void tearDown() {
		PowerMockito.verifyStatic();
	}

	@Override
	protected JiraClient getJiraClient() {
		return _jiraClient;
	}

	@Override
	protected String getProjectKey() {
		return _PROJECT_KEY;
	}

	@Override
	protected String getStatusName() {
		return _STATUS_NAME;
	}

	@Override
	protected String getUriComponent() {
		return _COMPONENT_URI;
	}

	@Override
	protected String getUriStatus() {
		return _STATUS_URI;
	}

	protected void mockPortletKey(String key) {
		PowerMockito.when(
			PortletPropsUtil.get(key)
		).thenReturn(
			TestPropsUtil.getValue(key)
		);
	}

	private static JiraClient _jiraClient = new JiraClientImpl();;

	private static final String _COMPONENT_URI =
		"https://issues.liferay.com/rest/api/latest/component/" ;

	private static final String _PROJECT_KEY = "LPS";

	private static final String _STATUS_NAME = "3";

	private static final String _STATUS_URI =
		"https://issues.liferay.com/rest/api/latest/status/" ;

}