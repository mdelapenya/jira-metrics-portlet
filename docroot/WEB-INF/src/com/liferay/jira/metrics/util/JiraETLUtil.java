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

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;
import com.liferay.jira.metrics.DuplicateJiraComponentException;
import com.liferay.jira.metrics.DuplicateJiraMetricException;
import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.DuplicateJiraStatusException;
import com.liferay.jira.metrics.client.JiraClient;
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.apache.commons.lang.time.StopWatch;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Manuel de la Peña
 * @author Cristina González
 */
public class JiraETLUtil {

	public static void load() {
		try {
			StopWatch stopWatch = new StopWatch();

			stopWatch.start();

			_loadProjectsFromJira();
			_loadStatusesFromJira();

			List<JiraProject> installedJiraProjects =
				JiraProjectLocalServiceUtil.getInstalledJiraProjects();

			for (JiraProject installedJiraProject : installedJiraProjects) {
				List<JiraStatus> installedJiraStatuses =
					JiraStatusLocalServiceUtil.getInstalledJiraStatuses(
						installedJiraProject);

				_loadIssuesMetricFromJira(
					installedJiraProject, installedJiraStatuses);
			}

			stopWatch.stop();

			if (_log.isInfoEnabled()) {
				_log.info(
					"Data from Jira has been loaded sucessfully in " +
						stopWatch.getTime() + " milliseconds.");
			}
		}
		catch (Exception e) {
			_log.error("Exception " + e.getMessage(), e);
		}
	}

	public void setJiraClient(JiraClient jiraClient) {
		if(_log.isDebugEnabled()) {
			_log.debug("Setting jiraClient: " + jiraClient);
		}

		this.jiraClient = jiraClient;
	}
	
	private static void _loadComponentFromJira(
			JiraProject jiraProject, BasicComponent component)
		throws JiraConnectionException, PortalException, SystemException {

		try {
			JiraComponentLocalServiceUtil.addJiraComponent(
				component.getSelf().toString(), jiraProject.getJiraProjectId(),
				component.getName(), false);

			if (_log.isInfoEnabled()) {
				_log.info(component.getName() + ": " + component.getSelf() + " imported sucessfully");
			}
		}
		catch (DuplicateJiraComponentException djce) {
			if (!PortletPropsValues.MERGE_STRATEGY.equals("update")) {
				return;
			}

			if (_log.isWarnEnabled()) {
				_log.warn(
					"Jira Comonent with name '" + component.getName() +
						"' and URI '"+component.getSelf()+"'already exists. Let's update it.");
			}

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					component.getSelf().toString());

			jiraComponent.setDisabled(false);
			jiraComponent.setName(component.getName());
			jiraComponent.setModifiedDate(new Date());

			JiraComponentLocalServiceUtil.updateJiraComponent(jiraComponent);

			_log.info(jiraComponent.getUri() + " updated sucessfully");
		}
	}

	private static void _loadComponentsFromJira(
			Project project, JiraProject jiraProject)
		throws JiraConnectionException, PortalException, SystemException {

		Iterable<BasicComponent> components = project.getComponents();

		for (BasicComponent component : components) {
			_loadComponentFromJira(jiraProject, component);
		}
	}

	private static void _loadIssuesMetricFromJira(
			JiraProject jiraProject, List<JiraStatus> jiraStatuses)
		throws JiraConnectionException, PortalException, SystemException {

		Date date = new Date();

		List<String> statusNames = new ArrayList<String>();

		for(JiraStatus jiraStatus : jiraStatuses) {
			statusNames.add(jiraStatus.getName());
		}

		List<IssuesMetric> issuesMetricList =
			jiraClient.getIssuesMetricsByProjectStatus(jiraProject.getKey(), statusNames);

		for (IssuesMetric issueMetric : issuesMetricList) {
			BasicComponent issuesMetricComponent = issueMetric.getComponent();

			URI componentUri = issuesMetricComponent.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					componentUri.toString());

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByName(
					issueMetric.getStatusName());

			Priority priority = issueMetric.getPriority();


			JiraMetric jiraMetric = null;

			int priorityValue = IssuesMetric.EMPTY_PRIORITY;

			if (priority != null) {
				priorityValue = priority.getId().intValue();
			}

			try {

				jiraMetric = JiraMetricLocalServiceUtil.addJiraMetric(
					jiraComponent.getJiraProjectId(),
					jiraComponent.getJiraComponentId(),
					jiraStatus.getJiraStatusId(), priorityValue,
					date, issueMetric.getTotal());

				if (_log.isInfoEnabled()) {
					_log.info(
						"[" + jiraMetric.getJiraProjectId() + "][" +
							jiraMetric.getJiraComponentId() + "][" +
							jiraMetric.getJiraStatusId()+ "]"  +
							" imported sucessfully");
				}
			}
			catch (DuplicateJiraMetricException djme) {
				if (!PortletPropsValues.MERGE_STRATEGY.equals("update")) {
					return;
				}

				if (_log.isWarnEnabled()) {
					_log.warn(
						"Jira Metric [" + jiraComponent.getJiraProjectId() +
							"][" + jiraComponent.getJiraComponentId() + "][" +
							jiraStatus.getJiraStatusId() + "][" +
							priorityValue + "][" + date +
							"] already exists. Let's update it.");
				}

				jiraMetric =
					JiraMetricLocalServiceUtil.getJiraMetric(
						jiraComponent.getJiraProjectId(),
						jiraComponent.getJiraComponentId(),
						jiraStatus.getJiraStatusId(),
						priorityValue, date);

				jiraMetric.setTotal(issueMetric.getTotal());
				jiraMetric.setModifiedDate(new Date());

				JiraMetricLocalServiceUtil.updateJiraMetric(jiraMetric);

				if (_log.isInfoEnabled()) {
					_log.info(
						"[" + jiraMetric.getJiraProjectId() + "][" +
							jiraMetric.getJiraComponentId() + "][" +
							jiraMetric.getJiraStatusId()+ "]"  +
							" updated sucessfully");
				}
			}
		}
	}

	private static void _loadProjectsFromJira()
		throws JiraConnectionException, SystemException, PortalException {

		List<BasicProject> projects = jiraClient.getAllJiraProjects();

		for (BasicProject project : projects) {
			_loadProjectFromJira(project);
		}
	}

	private static void _loadProjectFromJira(BasicProject basicProject)
		throws JiraConnectionException, PortalException, SystemException {

		JiraProject jiraProject = null;

		try {
			jiraProject =
				JiraProjectLocalServiceUtil.addJiraProject(
					basicProject.getKey(), basicProject.getName());

			if (_log.isInfoEnabled()) {
				_log.info(jiraProject.getKey() + " imported sucessfully");
			}
		}
		catch (DuplicateJiraProjectException djpe) {

			jiraProject =
				JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
					basicProject.getKey());

			if (PortletPropsValues.MERGE_STRATEGY.equals("update")) {

				if (_log.isWarnEnabled()) {
					_log.warn(
						"Jira Project with key '" + basicProject.getKey() +
							"' already exists. Let's update it.");
				}

				jiraProject.setName(basicProject.getName());
				jiraProject.setModifiedDate(new Date());

				JiraProjectLocalServiceUtil.updateJiraProject(jiraProject);

				if (_log.isInfoEnabled()) {
					_log.info(jiraProject.getKey() + " updated sucessfully");
				}
			}
		}

		Project project = jiraClient.getProject(basicProject.getKey());

		_loadComponentsFromJira(project, jiraProject);
	}

	private static void _loadStatusFromJira(Status status)
		throws JiraConnectionException, PortalException, SystemException {

		JiraStatus jiraStatus = null;

		try {
			jiraStatus =
				JiraStatusLocalServiceUtil.addJiraStatus(
					status.getSelf().toString(), status.getName());

			if (_log.isInfoEnabled()) {
				_log.info(jiraStatus.getUri() + " imported sucessfully");
			}
		}
		catch (DuplicateJiraStatusException djse) {
			if (!PortletPropsValues.MERGE_STRATEGY.equals("update")) {
				return;
			}

			if (_log.isWarnEnabled()) {
				_log.warn(
					"Jira Status with URI '" + status.getSelf() +
						"' already exists. Let's update it.");
			}

			jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					status.getSelf().toString());

			jiraStatus.setName(status.getName());
			jiraStatus.setModifiedDate(new Date());

			JiraStatusLocalServiceUtil.updateJiraStatus(jiraStatus);

			if (_log.isInfoEnabled()) {
				_log.info(jiraStatus.getUri()+ " updated sucessfully");
			}
		}
	}

	private static void _loadStatusesFromJira()
		throws JiraConnectionException, PortalException, SystemException {

		List<Status> statuses = jiraClient.getAllJiraStatuses();

		for (Status status : statuses) {
			_loadStatusFromJira(status);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JiraETLUtil.class);

	private static JiraClient jiraClient;

}