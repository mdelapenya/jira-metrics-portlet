/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Manuel de la Peña
 */
public class PortletPropsValues {

	public static final String JIRA_BASE_QUERY = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.JIRA_BASE_QUERY));

	public static final String JIRA_PASSWORD = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.JIRA_PASSWORD));

	public static final String JIRA_SERVER_URI = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.JIRA_SERVER_URI));

	public static final String JIRA_USERNAME = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.JIRA_USERNAME));

	public static final String MERGE_STRATEGY = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.MERGE_STRATEGY));

}