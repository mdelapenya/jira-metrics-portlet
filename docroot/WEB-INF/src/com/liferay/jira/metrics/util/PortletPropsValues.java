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

/**
 * @author Manuel de la Peña
 * @author Cristina González
 */
public class PortletPropsValues {

	public static final String JIRA_BASE_QUERY = PortletPropsUtil.get(
		PortletPropsKeys.JIRA_BASE_QUERY);

	public static final String JIRA_PASSWORD = PortletPropsUtil.get(
		PortletPropsKeys.JIRA_PASSWORD);

	public static final String JIRA_REST_API_SUFFIX = PortletPropsUtil.get(
		PortletPropsKeys.JIRA_REST_API_SUFFIX);

	public static final String JIRA_SERVER_URI = PortletPropsUtil.get(
		PortletPropsKeys.JIRA_SERVER_URI);

	public static final String JIRA_USERNAME = PortletPropsUtil.get(
		PortletPropsKeys.JIRA_USERNAME);

	public static final String MERGE_STRATEGY = PortletPropsUtil.get(
		PortletPropsKeys.MERGE_STRATEGY);

}