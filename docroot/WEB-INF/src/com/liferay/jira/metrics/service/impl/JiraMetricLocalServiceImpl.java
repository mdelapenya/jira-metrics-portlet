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

package com.liferay.jira.metrics.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.jira.metrics.NoSuchJiraMetricException;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.service.base.JiraMetricLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the jira metric local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraMetricLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraMetricLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil
 */
public class JiraMetricLocalServiceImpl extends JiraMetricLocalServiceBaseImpl {

	public JiraMetric getJiraMetric(
			long jiraProjectId, long jiraComponentId, long jiraStatusId,
			int priority, Date date)
		throws NoSuchJiraMetricException, SystemException {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		return jiraMetricPersistence.findByP_C_S_P_D_M_Y(
			jiraProjectId, jiraComponentId, jiraStatusId, priority, day, month,
			year);
	}

	public JiraMetric getJiraMetric(
			long jiraProjectId, long jiraComponentId, long jiraStatusId,
			int priority, int day, int month, int year)
		throws NoSuchJiraMetricException, SystemException {

		return jiraMetricPersistence.findByP_C_S_P_D_M_Y(
			jiraProjectId, jiraComponentId, jiraStatusId, priority, day, month,
			year);
	}

	public List<JiraMetric> getJiraMetrics(
			long jiraProjectId, long jiraComponentId, long jiraStatusId,
			Date date)
		throws SystemException {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		return getJiraMetrics(
			jiraProjectId, jiraComponentId, jiraStatusId, day, month, year);
	}

	public List<JiraMetric> getJiraMetrics(
			long jiraProjectId, long jiraComponentId, long jiraStatusId,
			int day, int month, int year)
		throws SystemException {

		return jiraMetricPersistence.findByP_C_S_D_M_Y(
			jiraProjectId, jiraComponentId, jiraStatusId, day, month, year);
	}

}