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

import com.liferay.jira.metrics.model.JiraDataRetrieve;
import com.liferay.jira.metrics.service.base.JiraDataRetrieveLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Calendar;
import java.util.Date;

/**
 * The implementation of the jira data retrieve local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraDataRetrieveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraDataRetrieveLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil
 */
public class JiraDataRetrieveLocalServiceImpl
	extends JiraDataRetrieveLocalServiceBaseImpl {


	public JiraDataRetrieve addJiraDataRetrieve(
			String status, String statusDescription, Date date)
		throws PortalException, SystemException {

		int[] dateElements = parseDate(date);

		Date now = new Date();

		JiraDataRetrieve jiraDataRetrieve =
			jiraDataRetrievePersistence.fetchByD_M_Y(
				dateElements[0], dateElements[1], dateElements[2]);

		if (jiraDataRetrieve == null) {
			long id = counterLocalService.increment();

			jiraDataRetrieve = jiraDataRetrievePersistence.create(id);

			jiraDataRetrieve.setCreateDate(now);
			jiraDataRetrieve.setDay(dateElements[0]);
			jiraDataRetrieve.setMonth(dateElements[1]);
			jiraDataRetrieve.setYear(dateElements[2]);
		}

		jiraDataRetrieve.setModifiedDate(now);
		jiraDataRetrieve.setStatus(status);
		jiraDataRetrieve.setStatusDescription(statusDescription);

		return jiraDataRetrievePersistence.update(jiraDataRetrieve);
	}

	protected int[] parseDate(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		int[] dateElements = new int[3];

		dateElements[0] = calendar.get(Calendar.DAY_OF_MONTH);
		dateElements[1] = calendar.get(Calendar.MONTH);
		dateElements[2] = calendar.get(Calendar.YEAR);

		return dateElements;
	}
}