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

package com.liferay.jira.metrics.util;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import com.liferay.jira.metrics.DuplicateJiraComponentException;
import com.liferay.jira.metrics.DuplicateJiraMetricException;
import com.liferay.jira.metrics.DuplicateJiraPriorityException;
import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.DuplicateJiraStatusException;
import com.liferay.jira.metrics.client.JiraClient;
import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraDataRetrieve;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Manuel de la Peña
 * @author Cristina González
 */
public class JiraETLUtil {

	public static final String STATUS_FAILED = "FAILED";

	public static final String STATUS_OK = "OK";

	public static final String STATUS_RUNNING = "RUNNING";

	public static void load() {

		Date now = new Date();

		try {
			JiraDataRetrieve jiraDataRetrieve =
				JiraDataRetrieveLocalServiceUtil.fetchByDate(now);

			if ((jiraDataRetrieve != null) &&
				(STATUS_OK.equals(jiraDataRetrieve.getStatus()) ||
				 STATUS_RUNNING.equals(jiraDataRetrieve.getStatus()))) {

				if (_log.isInfoEnabled() &&
					STATUS_RUNNING.equals(jiraDataRetrieve.getStatus())) {

					_log.info("The process is running now");
				}
				else if (_log.isInfoEnabled()) {
					_log.info(
						"Data from Jira has been loaded sucessfully in " +
							jiraDataRetrieve.getModifiedDate());
				}

				return;
			}

			JiraDataRetrieveLocalServiceUtil.addJiraDataRetrieve(
				STATUS_RUNNING, null, now);

			StopWatch stopWatch = new StopWatch();

			stopWatch.start();

			_loadProjectsFromJira();
			_loadStatusesFromJira();
			_loadPrioritiesFromJira();
			_loadIssueMetricsFromJira();

			stopWatch.stop();

			JiraDataRetrieveLocalServiceUtil.addJiraDataRetrieve(
				STATUS_OK, null, now);

			if (_log.isInfoEnabled()) {
				_log.info(
					"Data from Jira has been loaded sucessfully in " +
						stopWatch.getTime() + " milliseconds.");
			}
		}
		catch (Exception e) {
			try {
				JiraDataRetrieveLocalServiceUtil.addJiraDataRetrieve(
					STATUS_FAILED, e.getMessage(), now);
			}
			catch (Exception e1) {
				_log.error(
					"Exception when trying to persist an error" +
						e.getMessage(), e);
			}

			_log.error("Exception " + e.getMessage(), e);
		}
	}

	private static void _loadComponentFromJira(
			JiraProject jiraProject, BasicComponent component)
		throws JiraConnectionException, PortalException, SystemException {

		try {
			JiraComponentLocalServiceUtil.addJiraComponent(
				component.getSelf().toString(), jiraProject.getJiraProjectId(),
				component.getName(), false);

			if (_log.isInfoEnabled()) {
				_log.info(
					component.getName() + ": " + component.getSelf() +
						" imported sucessfully");
			}
		}
		catch (DuplicateJiraComponentException djce) {
			if (!PortletPropsValues.MERGE_STRATEGY.equals("update")) {
				return;
			}

			if (_log.isWarnEnabled()) {
				_log.warn(
					"Jira Comonent with name '" + component.getName() +
						"' and URI '" + component.getSelf() +
							"'already exists. Let's update it.");
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

	private static void _loadIssueMetricsFromJira()
		throws JiraConnectionException, PortalException, SystemException {

		List<JiraProject> installedJiraProjects =
			JiraProjectLocalServiceUtil.getInstalledJiraProjects();

		for (JiraProject installedJiraProject : installedJiraProjects) {
			List<JiraStatus> installedJiraStatuses =
				JiraStatusLocalServiceUtil.getInstalledJiraStatuses(
					installedJiraProject);

			_loadIssueMetricsFromJiraByProjectAndStatuses(
				installedJiraProject, installedJiraStatuses);
		}
	}

	private static void _loadIssueMetricsFromJiraByProjectAndStatuses(
			JiraProject jiraProject, List<JiraStatus> jiraStatuses)
		throws JiraConnectionException, PortalException, SystemException {

		Date date = new Date();

		List<String> statusNames = new ArrayList<String>();

		for (JiraStatus jiraStatus : jiraStatuses) {
			statusNames.add(jiraStatus.getName());
		}

		List<IssuesMetric> issuesMetricList =
			_jiraClient.getIssuesMetricsByProjectStatus(
				jiraProject.getKey(), statusNames);

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

			long jiraPriorityId = IssuesMetric.EMPTY_PRIORITY;

			if (priority != null) {
				JiraPriority jiraPriority =
					JiraPriorityLocalServiceUtil.getJiraPriorityByValue(
						priority.getId().toString());

				jiraPriorityId = jiraPriority.getJiraPriorityId();
			}

			try {
				jiraMetric = JiraMetricLocalServiceUtil.addJiraMetric(
					jiraComponent.getJiraProjectId(),
					jiraComponent.getJiraComponentId(),
					jiraStatus.getJiraStatusId(), jiraPriorityId, date,
					issueMetric.getTotal());

				if (_log.isInfoEnabled()) {
					_log.info(
						"[" + jiraMetric.getJiraProjectId() + "][" +
							jiraMetric.getJiraComponentId() + "][" +
							jiraMetric.getJiraStatusId()+ "]["  +
							jiraPriorityId + "] imported sucessfully");
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
							jiraPriorityId + "][" + date +
							"] already exists. Let's update it.");
				}

				jiraMetric =
					JiraMetricLocalServiceUtil.getJiraMetric(
						jiraComponent.getJiraProjectId(),
						jiraComponent.getJiraComponentId(),
						jiraStatus.getJiraStatusId(), jiraPriorityId, date);

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

	private static void _loadPrioritiesFromJira()
		throws JiraConnectionException, PortalException, SystemException {

		List<Priority> priorities = _jiraClient.getAllJiraPriorities();

		for (Priority priority : priorities) {
			_loadPriorityFromJira(priority);
		}
	}

	private static void _loadPriorityFromJira(Priority priority)
		throws JiraConnectionException, PortalException, SystemException {

		JiraPriority jiraPriority = null;

		try {
			jiraPriority =
				JiraPriorityLocalServiceUtil.addJiraProject(
					priority.getId().toString(), priority.getName());

			if (_log.isInfoEnabled()) {
				_log.info(jiraPriority.getValue() + " imported sucessfully");
			}
		}
		catch (DuplicateJiraPriorityException djse) {
			if (!PortletPropsValues.MERGE_STRATEGY.equals("update")) {
				return;
			}

			if (_log.isWarnEnabled()) {
				_log.warn(
					"Jira Priority with Name '" + priority.getName() +
						"' already exists. Let's update it.");
			}

			jiraPriority =
				JiraPriorityLocalServiceUtil.getJiraPriorityByValue(
					priority.getId().toString());

			jiraPriority.setName(priority.getName());
			jiraPriority.setModifiedDate(new Date());

			JiraPriorityLocalServiceUtil.updateJiraPriority(jiraPriority);

			if (_log.isInfoEnabled()) {
				_log.info(jiraPriority.getValue() + " updated sucessfully");
			}
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

		Project project = _jiraClient.getProject(basicProject.getKey());

		_loadComponentsFromJira(project, jiraProject);
	}

	private static void _loadProjectsFromJira()
		throws JiraConnectionException, PortalException, SystemException {

		List<BasicProject> projects = _jiraClient.getAllJiraProjects();

		for (BasicProject project : projects) {
			_loadProjectFromJira(project);
		}
	}

	private static void _loadStatusesFromJira()
		throws JiraConnectionException, PortalException, SystemException {

		List<Status> statuses = _jiraClient.getAllJiraStatuses();

		for (Status status : statuses) {
			_loadStatusFromJira(status);
		}
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

	private static Log _log = LogFactoryUtil.getLog(JiraETLUtil.class);

	@BeanReference(type = JiraClient.class)
	private static JiraClient _jiraClient;

}