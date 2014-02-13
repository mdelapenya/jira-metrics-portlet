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

import com.liferay.jira.metrics.NoSuchJiraStatusException;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.base.JiraStatusLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the jira status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraStatusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraStatusLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil
 */
public class JiraStatusLocalServiceImpl extends JiraStatusLocalServiceBaseImpl {

	public JiraStatus addJiraStatus(
			String uri, String name)
		throws PortalException, SystemException {

		long id = counterLocalService.increment();

		JiraStatus jiraStatus = jiraStatusPersistence.create(id);

		Date now = new Date();

		jiraStatus.setCreateDate(now);
		jiraStatus.setModifiedDate(now);

		jiraStatus.setUri(uri);
		jiraStatus.setName(name);

		jiraStatusPersistence.update(jiraStatus);

		return jiraStatusPersistence.findByPrimaryKey(
			jiraStatus.getPrimaryKey());
	}

	public JiraStatus getJiraStatusByUri(String uri)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findByUri(uri);
	}

}