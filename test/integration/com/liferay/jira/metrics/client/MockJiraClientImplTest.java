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

/**
 * @author Cristina González
 * @author Manuel de la Peña
 */
public class MockJiraClientImplTest extends BaseJiraClientTestCase {

	@Override
	protected JiraClient getJiraClient() {
		return _mockJiraClient;
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

	private static JiraClient _mockJiraClient = new MockJiraClientImpl();
	private static MockJiraStorage _mockJiraStorage = new MockJiraStorage();

	private static final String _COMPONENT_URI =
		MockJiraStorage.JIRA_TEST_URI + "/component/" ;

	private static final String _PROJECT_KEY =
		_mockJiraStorage.getMockProject().getKey();

	private static final String _STATUS_NAME =
		_mockJiraStorage.getMockStatuses().get(0).getName();

	private static final String _STATUS_URI =
		MockJiraStorage.JIRA_TEST_URI + "/status/";


}