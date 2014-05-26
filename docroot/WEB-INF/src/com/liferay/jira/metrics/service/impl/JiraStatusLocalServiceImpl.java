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

import com.liferay.jira.metrics.DuplicateJiraStatusException;
import com.liferay.jira.metrics.NoSuchJiraStatusException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.jira.metrics.service.base.JiraStatusLocalServiceBaseImpl;
import com.liferay.jira.metrics.util.PortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.persistence.PortletPreferencesFinderUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public JiraStatus addJiraStatus(String uri, String name)
		throws PortalException, SystemException {

		JiraStatus jiraStatus = jiraStatusPersistence.fetchByUri(uri);

		if (jiraStatus != null) {
			throw new DuplicateJiraStatusException();
		}

		long id = counterLocalService.increment();

		jiraStatus = jiraStatusPersistence.create(id);

		Date now = new Date();

		jiraStatus.setCreateDate(now);
		jiraStatus.setModifiedDate(now);

		jiraStatus.setUri(uri);
		jiraStatus.setName(name);

		jiraStatusPersistence.update(jiraStatus);

		return jiraStatusPersistence.findByPrimaryKey(
			jiraStatus.getPrimaryKey());
	}

	public List<JiraStatus> getAllJiraStatuses(
			OrderByComparator orderByComparator)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
	}

	public List<JiraStatus> getInstalledJiraStatuses(JiraProject jiraProject)
		throws PortalException, SystemException {

		List<PortletPreferences> preferences =
			PortletPreferencesFinderUtil.findByPortletId(
				PortletKeys.JIRA_METRICS_PORTLET_ID + StringPool.PERCENT);

		if ((preferences == null) || preferences.isEmpty()) {
			return new ArrayList<JiraStatus>();
		}

		String projectKey = jiraProject.getKey();

		List<JiraStatus> jiraStatuses = new ArrayList<JiraStatus>();

		for (PortletPreferences preference : preferences) {
			String xmlPreference = preference.getPreferences();

			javax.portlet.PortletPreferences jxPortletPreferences =
				PortletPreferencesFactoryUtil.fromDefaultXML(xmlPreference);

			String jiraProjectKeyPreference = jxPortletPreferences.getValue(
				PortletKeys.PREFERENCE_JIRA_PROJECT_KEY, null);

			if (projectKey.equals(jiraProjectKeyPreference)) {
				String[] jiraStatusNames = jxPortletPreferences.getValues(
					PortletKeys.PREFERENCE_JIRA_STATUSES, null);

				for (String jiraStatusName : jiraStatusNames) {
					JiraStatus jiraStatus =
						JiraStatusLocalServiceUtil.getJiraStatusByName(
							jiraStatusName);

					jiraStatuses.add(jiraStatus);
				}
			}
		}

		return jiraStatuses;
	}

	public JiraStatus getJiraStatusByName(String name)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findByStatus(name);
	}

	public JiraStatus getJiraStatusByUri(String uri)
		throws NoSuchJiraStatusException, SystemException {

		return jiraStatusPersistence.findByUri(uri);
	}

}