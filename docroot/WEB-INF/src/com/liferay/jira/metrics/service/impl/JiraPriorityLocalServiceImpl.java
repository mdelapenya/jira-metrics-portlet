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

import com.liferay.jira.metrics.DuplicateJiraPriorityException;
import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.NoSuchJiraPriorityException;
import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.base.JiraPriorityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the jira priority local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraPriorityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Pe√±a
 * @see com.liferay.jira.metrics.service.base.JiraPriorityLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil
 */
public class JiraPriorityLocalServiceImpl
	extends JiraPriorityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil} to access the jira priority local service.
	 */

	public JiraPriority addJiraProject(String value, String name)
		throws PortalException, SystemException {

		JiraPriority jiraPriority = jiraPriorityPersistence.fetchByValue(value);

		if (jiraPriority != null) {
			throw new DuplicateJiraPriorityException();
		}

		long id = counterLocalService.increment();

		jiraPriority = jiraPriorityPersistence.create(id);

		Date now = new Date();

		jiraPriority.setCreateDate(now);
		jiraPriority.setModifiedDate(now);

		jiraPriority.setValue(value);
		jiraPriority.setName(name);

		jiraPriorityPersistence.update(jiraPriority);

		return jiraPriorityPersistence.findByPrimaryKey(
			jiraPriority.getPrimaryKey());
	}


	public JiraPriority getJiraPriorityByName(String name)
		throws NoSuchJiraPriorityException, SystemException {

		return jiraPriorityPersistence.findByName(name);
	}

	public JiraPriority getJiraPriorityByValue(String value)
		throws NoSuchJiraPriorityException, SystemException {

		return jiraPriorityPersistence.findByValue(value);
	}

}