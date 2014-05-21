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

package com.liferay.jira.metrics.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JiraDataRetrieveService}.
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieveService
 * @generated
 */
public class JiraDataRetrieveServiceWrapper implements JiraDataRetrieveService,
	ServiceWrapper<JiraDataRetrieveService> {
	public JiraDataRetrieveServiceWrapper(
		JiraDataRetrieveService jiraDataRetrieveService) {
		_jiraDataRetrieveService = jiraDataRetrieveService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraDataRetrieveService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraDataRetrieveService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraDataRetrieveService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraDataRetrieveService getWrappedJiraDataRetrieveService() {
		return _jiraDataRetrieveService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraDataRetrieveService(
		JiraDataRetrieveService jiraDataRetrieveService) {
		_jiraDataRetrieveService = jiraDataRetrieveService;
	}

	@Override
	public JiraDataRetrieveService getWrappedService() {
		return _jiraDataRetrieveService;
	}

	@Override
	public void setWrappedService(
		JiraDataRetrieveService jiraDataRetrieveService) {
		_jiraDataRetrieveService = jiraDataRetrieveService;
	}

	private JiraDataRetrieveService _jiraDataRetrieveService;
}