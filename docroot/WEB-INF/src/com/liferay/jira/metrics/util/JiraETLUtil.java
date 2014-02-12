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

package com.liferay.jira.metrics.util;

import com.atlassian.jira.rest.client.domain.Project;

import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Manuel de la Peña
 */
public class JiraETLUtil {

	public static void load() {
		try {
			StopWatch stopWatch = new StopWatch();

			stopWatch.start();

			loadLPSProject();

			stopWatch.stop();

			_log.info(
				"Data from Jira has been loaded sucessfully in " +
					stopWatch.getTime() + " milliseconds.");
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (JiraConnectionException e) {
			e.printStackTrace();
		}
	}

	public static void loadLPSProject()
		throws JiraConnectionException, PortalException, SystemException {

		Project project = JiraUtil.getProject("LPS");

		JiraProject jiraProject = null;

		try {
			jiraProject =
				JiraProjectLocalServiceUtil.addJiraProject(
					project.getKey(), project.getDescription());

			_log.info(jiraProject.getKey() + " imported sucessfully");
		}
		catch (DuplicateJiraProjectException djpe) {
			_log.warn(
				"Jira Project with key '" + project.getKey() +
				"' already exists. Let's update it.");

			jiraProject =
				JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
					project.getKey());

			jiraProject.setName(project.getDescription());
			jiraProject.setModifiedDate(new Date());

			JiraProjectLocalServiceUtil.updateJiraProject(jiraProject);

			_log.info(jiraProject.getKey() + " updated sucessfully");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JiraETLUtil.class);

}