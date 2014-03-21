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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

/**
 * @author Cristina González
 */
public class PortletPreferencesTestUtil {

	public static void addPortletPreferences(
			String portletId, String portletPreferences)
		throws SystemException {

			PortletPreferencesLocalServiceUtil.addPortletPreferences(
				0, 0, 3, 0, portletId, null, portletPreferences);
	}

	public static void deletePortletPreferences(String portletId)
		throws PortalException, SystemException {

			PortletPreferencesLocalServiceUtil.deletePortletPreferences(
					0, 3, 0, portletId);
	}

	public static String getPortletPreferencesXML(
		String teamName, String projectKeys, String[] statusNames,
		String[] componentNames, String[] priorities) {

			StringBundler sb = new StringBundler(7);

			sb.append("<portlet-preferences>");

			if (teamName != null) {
				sb.append(
					_addProperty(PortletKeys.PREFERENCE_TEAM_NAME, teamName));
			}

			if (projectKeys != null) {
				sb.append(
						_addProperty(PortletKeys.PREFERENCE_JIRA_PROJECT_KEY, projectKeys));
			}

			if (statusNames != null) {
				sb.append(
						_addProperty(
								PortletKeys.PREFERENCE_JIRA_STATUSES, statusNames));
			}

			if (componentNames != null) {
				sb.append(
						_addProperty(
								PortletKeys.PREFERENCE_JIRA_COMPONENTS, componentNames));
			}

			if (priorities != null) {
				sb.append(
						_addProperty(
								PortletKeys.PREFERENCE_JIRA_PRIORITIES, priorities));
			}

			sb.append("</portlet-preferences>");

			return sb.toString();
	}

	private static String _addProperty(String name, String ... values) {
		StringBundler sb = new StringBundler(5 + (values.length * 3));
		sb.append("<preference>");
		sb.append("<name>");
		sb.append(name);
		sb.append("</name>");

			for (String value : values) {
				sb.append("<value>");
				sb.append(value);
				sb.append("</value>");
			}

			sb.append("</preference>");

			return sb.toString();
	}

}
