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

package com.liferay.jira.metrics.service.messaging;

import com.liferay.jira.metrics.service.ClpSerializer;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraComponentServiceUtil;
import com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraDataRetrieveServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricServiceUtil;
import com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraPriorityServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Manuel de la Peña
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			JiraComponentLocalServiceUtil.clearService();

			JiraComponentServiceUtil.clearService();
			JiraDataRetrieveLocalServiceUtil.clearService();

			JiraDataRetrieveServiceUtil.clearService();
			JiraMetricLocalServiceUtil.clearService();

			JiraMetricServiceUtil.clearService();
			JiraPriorityLocalServiceUtil.clearService();

			JiraPriorityServiceUtil.clearService();
			JiraProjectLocalServiceUtil.clearService();

			JiraProjectServiceUtil.clearService();
			JiraStatusLocalServiceUtil.clearService();

			JiraStatusServiceUtil.clearService();
		}
	}
}