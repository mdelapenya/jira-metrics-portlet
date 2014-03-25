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
 * Provides a wrapper for {@link JiraPriorityService}.
 *
 * @author Manuel de la Pe√±a
 * @see JiraPriorityService
 * @generated
 */
public class JiraPriorityServiceWrapper implements JiraPriorityService,
	ServiceWrapper<JiraPriorityService> {
	public JiraPriorityServiceWrapper(JiraPriorityService jiraPriorityService) {
		_jiraPriorityService = jiraPriorityService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraPriorityService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraPriorityService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraPriorityService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraPriorityService getWrappedJiraPriorityService() {
		return _jiraPriorityService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraPriorityService(
		JiraPriorityService jiraPriorityService) {
		_jiraPriorityService = jiraPriorityService;
	}

	@Override
	public JiraPriorityService getWrappedService() {
		return _jiraPriorityService;
	}

	@Override
	public void setWrappedService(JiraPriorityService jiraPriorityService) {
		_jiraPriorityService = jiraPriorityService;
	}

	private JiraPriorityService _jiraPriorityService;
}