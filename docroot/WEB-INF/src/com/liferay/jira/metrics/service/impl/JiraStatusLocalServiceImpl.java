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

import java.util.Date;
import java.util.List;

import com.liferay.jira.metrics.NoSuchJiraStatusException;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.base.JiraStatusLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

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
			User user, long jiraStatusCode, long jiraProjectId, String name)
		throws PortalException, SystemException {

		long id = counterLocalService.increment();

		JiraStatus jiraStatus = jiraStatusPersistence.create(id);

		Date now = new Date();

		jiraStatus.setUserId(user.getUserId());
		jiraStatus.setUserName(user.getFullName());
		jiraStatus.setCreateDate(now);
		jiraStatus.setModifiedDate(now);

		jiraStatus.setJiraStatusCode(jiraStatusCode);
		jiraStatus.setJiraProjectId(jiraProjectId);
		jiraStatus.setName(name);

		jiraStatusPersistence.update(jiraStatus);

		return jiraStatusPersistence.findByPrimaryKey(
			jiraStatus.getPrimaryKey());
	}

	public JiraStatus getJiraStatusByJiraStatusCode(long jiraStatusCode)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findByJiraStatusCode(jiraStatusCode);
	}

	public JiraStatus getJiraStatusByName(String name)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findByStatus(name);
	}

	public List<JiraStatus> getJiraStatusesByJiraProjectId(long jiraProjectId)
		throws SystemException {

		return jiraStatusPersistence.findByJiraProjectId(jiraProjectId);
	}

}