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

package com.liferay.jira.metrics.service.persistence;

import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Manuel de la Pe√±a
 * @generated
 */
public abstract class JiraMetricActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public JiraMetricActionableDynamicQuery() throws SystemException {
		setBaseLocalService(JiraMetricLocalServiceUtil.getService());
		setClass(JiraMetric.class);

		setClassLoader(com.liferay.jira.metrics.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("jiraMetricId");
	}
}