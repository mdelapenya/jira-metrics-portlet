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

import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Status;
import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.DuplicateJiraStatusException;
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.lang.time.StopWatch;

import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class JiraETLUtil {

	public static void load() {
		try {
			StopWatch stopWatch = new StopWatch();

			stopWatch.start();

			_loadStatuses();
			_loadProjects();

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

	private static void _loadProjects()
		throws JiraConnectionException, SystemException, PortalException {

		List<BasicProject> projects = JiraUtil.getAllJiraProjects();

		for (BasicProject project : projects) {
			_loadProject(project);
		}
	}

	private static void _loadProject(BasicProject project)
		throws JiraConnectionException, PortalException, SystemException {

		JiraProject jiraProject = null;

		try {
			jiraProject =
				JiraProjectLocalServiceUtil.addJiraProject(
					project.getKey(), project.getName());

			_log.info(jiraProject.getKey() + " imported sucessfully");
		}
		catch (DuplicateJiraProjectException djpe) {
			_log.warn(
				"Jira Project with key '" + project.getKey() +
				"' already exists. Let's update it.");

			jiraProject =
				JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
					project.getKey());

			jiraProject.setName(project.getName());
			jiraProject.setModifiedDate(new Date());

			JiraProjectLocalServiceUtil.updateJiraProject(jiraProject);

			_log.info(jiraProject.getKey() + " updated sucessfully");
		}
	}

	private static void _loadStatuses()
		throws JiraConnectionException, SystemException, PortalException {

		List<Status> statuses = JiraUtil.getAllJiraStatuses();

		for (Status status : statuses) {
			_loadStatus(status);
		}
	}


	private static void _loadStatus(Status status)
		throws JiraConnectionException, PortalException, SystemException {

		JiraStatus jiraStatus = null;

		try {
			jiraStatus =
				JiraStatusLocalServiceUtil.addJiraStatus(
					status.getSelf().toString(), status.getName());

			_log.info(jiraStatus.getUri() + " imported sucessfully");
		}
		catch (DuplicateJiraStatusException djse) {
			_log.warn(
				"Jira Status with URI '" + status.getSelf() +
					"' already exists. Let's update it.");

			jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					status.getSelf().toString());

			jiraStatus.setName(status.getName());
			jiraStatus.setModifiedDate(new Date());

			JiraStatusLocalServiceUtil.updateJiraStatus(jiraStatus);

			_log.info(jiraStatus.getUri()+ " updated sucessfully");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JiraETLUtil.class);

}