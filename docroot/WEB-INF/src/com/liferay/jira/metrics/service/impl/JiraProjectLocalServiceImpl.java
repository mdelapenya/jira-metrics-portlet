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

import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.NoSuchJiraProjectException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.base.JiraProjectLocalServiceBaseImpl;
import com.liferay.jira.metrics.util.PortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.persistence.PortletPreferencesFinderUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the jira project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.jira.metrics.service.JiraProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.base.JiraProjectLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil
 */
public class JiraProjectLocalServiceImpl extends JiraProjectLocalServiceBaseImpl {

	public JiraProject addJiraProject(String key, String name)
		throws PortalException, SystemException {

		JiraProject jiraProject = jiraProjectPersistence.fetchByLabel(key);

		if (jiraProject != null) {
			throw new DuplicateJiraProjectException();
		}

		long id = counterLocalService.increment();

		jiraProject = jiraProjectPersistence.create(id);

		Date now = new Date();

		jiraProject.setCreateDate(now);
		jiraProject.setModifiedDate(now);

		jiraProject.setKey(key);
		jiraProject.setName(name);

		jiraProjectPersistence.update(jiraProject);

		return jiraProjectPersistence.findByPrimaryKey(
			jiraProject.getPrimaryKey());
	}

	/**
	 * Retrieves all Jira projects
	 *
	 * @return a list with all Jira projects
	 * @throws SystemException
	 */
	public List<JiraProject> getAllJiraProjects()
		throws SystemException {

		return jiraProjectPersistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, new JiraProjectComparator());
	}


	public List<JiraProject> getInstalledJiraProjects()
		throws PortalException, SystemException {

		List<PortletPreferences> preferences =
			PortletPreferencesFinderUtil.findByPortletId(
				PortletKeys.JIRA_METRICS_PORTLET_ID+"%");

		if (preferences == null || preferences.isEmpty()) {
			return new ArrayList<JiraProject>();
		}

		List<JiraProject> jiraProjects = new ArrayList<JiraProject>();

		for (PortletPreferences preference : preferences) {
			String xmlPreference = preference.getPreferences();

			javax.portlet.PortletPreferences jxPortletPreferences =
				PortletPreferencesFactoryUtil.fromDefaultXML(xmlPreference);

			String jiraProjectName = jxPortletPreferences.getValue(
				"jiraProject", null);

			JiraProject jiraProject = getJiraProjectByProjectLabel(
				jiraProjectName);

			jiraProjects.add(jiraProject);
		}

		return jiraProjects;
	}

	/**
	 * Gets a Jira Project by name
	 *
	 * @param name
	 * @return
	 * @throws NoSuchJiraProjectException
	 * @throws SystemException
	 */
	public JiraProject getJiraProjectByName(String name)
		throws NoSuchJiraProjectException, SystemException {

		return jiraProjectPersistence.findByName(name);
	}

	/**
	 * Gets a Jira Project by label
	 *
	 * @param label
	 * @return the Jira project
	 * @throws NoSuchJiraProjectException
	 * @throws SystemException
	 */
	public JiraProject getJiraProjectByProjectLabel(String label)
		throws NoSuchJiraProjectException, SystemException {

		return jiraProjectPersistence.findByLabel(label);
	}

	private class JiraProjectComparator extends OrderByComparator {

		@Override
		public int compare(Object o1, Object o2) {
			JiraProject jiraProject1 = (JiraProject) o1;
			JiraProject jiraProject2 = (JiraProject) o2;

			return jiraProject1.getKey().compareTo(jiraProject2.getKey());
		}
	}

}