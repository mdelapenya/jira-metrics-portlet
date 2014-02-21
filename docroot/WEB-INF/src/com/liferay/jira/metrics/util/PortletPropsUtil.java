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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Cristina González
 */
public class PortletPropsUtil {

	public static String getJiraBaseQuery() {
		return GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.JIRA_BASE_QUERY));
	}

	public static String getJiraPassword() {
		return GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.JIRA_PASSWORD));
	}

	public static String getJiraServerUri() {
		return GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.JIRA_PASSWORD));
	}

	public static String getJiraUsername() {
		return GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.JIRA_USERNAME));
	}

	public static String getMergeStrategy() {
		return GetterUtil.getString(
			PortletProps.get(PortletPropsKeys.MERGE_STRATEGY));
	}

}