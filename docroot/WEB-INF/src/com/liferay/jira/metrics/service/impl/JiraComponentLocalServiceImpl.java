/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

import com.liferay.jira.metrics.DuplicateJiraComponentException;
import com.liferay.jira.metrics.NoSuchJiraComponentException;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.service.base.JiraComponentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the jira component local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraComponentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraComponentLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil
 */
public class JiraComponentLocalServiceImpl
	extends JiraComponentLocalServiceBaseImpl {

	public JiraComponent addJiraComponent(
			String uri, long jiraProjectId, String name, Boolean disabled)
		throws PortalException, SystemException {

		JiraComponent jiraComponent = jiraComponentPersistence.fetchByUri(uri);

		if (jiraComponent != null) {
			throw new DuplicateJiraComponentException();
		}

		long id = counterLocalService.increment();

		jiraComponent = jiraComponentPersistence.create(id);

		Date now = new Date();

		jiraComponent.setCreateDate(now);
		jiraComponent.setModifiedDate(now);

		jiraComponent.setUri(uri);
		jiraComponent.setJiraProjectId(jiraProjectId);
		jiraComponent.setName(name);
		jiraComponent.setDisabled(disabled);

		jiraComponentPersistence.update(jiraComponent);

		return jiraComponentPersistence.findByPrimaryKey(
			jiraComponent.getPrimaryKey());
	}

	public JiraComponent getJiraComponentByNameAndJiraProjectId(
			String name, long jiraProjectId)
		throws NoSuchJiraComponentException, SystemException {

		return jiraComponentPersistence.findByJiraComponent(
			name, jiraProjectId);
	}

	public JiraComponent getJiraComponentByUri(String uri)
		throws NoSuchJiraComponentException, SystemException {

		return jiraComponentPersistence.findByUri(uri);
	}

	public List<JiraComponent> getJiraComponentsByJiraProjectId(
			long jiraProjectId)
		throws SystemException {

		return jiraComponentPersistence.findByJiraProjectId(jiraProjectId);
	}

}