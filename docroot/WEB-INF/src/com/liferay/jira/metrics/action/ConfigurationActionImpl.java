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

package com.liferay.jira.metrics.action;

import com.liferay.jira.metrics.util.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

/**
 * @author Cristina González
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info("Processing Action");
		}

		String teamName = actionRequest.getParameter(
			PortletKeys.PARAM_JIRA_TEAM_NAME);

		if (_log.isDebugEnabled()) {
			_log.debug("Param teamName: " + teamName);
		}

		String jiraProjectKey = actionRequest.getParameter(
			PortletKeys.PARAM_JIRA_PROJECT);

		if (_log.isDebugEnabled()) {
			_log.debug("Param jiraProjectKey: " + jiraProjectKey);
		}

		String[] jiraComponentNames = actionRequest.getParameterValues(
			PortletKeys.PARAM_JIRA_COMPONENTS);

		if (_log.isDebugEnabled()) {
			for (String jiraComponentName : jiraComponentNames) {
				_log.debug("Param JiraComponentName: " + jiraComponentName);
			}
		}

		String[] jiraStatusNames = actionRequest.getParameterValues(
			PortletKeys.PARAM_JIRA_STATUSES);

		if (_log.isDebugEnabled()) {
			for (String jiraStatusName : jiraStatusNames) {
				_log.debug("Param JiraStatusName: " + jiraStatusName);
			}
		}

		String[] jiraPriorityValues = actionRequest.getParameterValues(
			PortletKeys.PARAM_JIRA_PRIORITIES);

		if (_log.isDebugEnabled()) {
			for (String jiraPriorityValue : jiraPriorityValues) {
				_log.debug("Param JiraPriorityValue: " + jiraPriorityValue);
			}
		}

		PortletPreferences preferences = actionRequest.getPreferences();

		preferences.setValue(PortletKeys.PREFERENCE_TEAM_NAME, teamName);
		preferences.setValue(
			PortletKeys.PREFERENCE_JIRA_PROJECT_KEY, jiraProjectKey);
		preferences.setValues(
			PortletKeys.PREFERENCE_JIRA_COMPONENTS, jiraComponentNames);
		preferences.setValues(
			PortletKeys.PREFERENCE_JIRA_STATUSES, jiraStatusNames);
		preferences.setValues(
			PortletKeys.PREFERENCE_JIRA_PRIORITIES, jiraPriorityValues);

		preferences.store();

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConfigurationActionImpl.class);
}