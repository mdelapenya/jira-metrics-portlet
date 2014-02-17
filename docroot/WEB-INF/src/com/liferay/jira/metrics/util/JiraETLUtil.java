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
import com.liferay.jira.metrics.DuplicateJiraProjectException;
import com.liferay.jira.metrics.DuplicateJiraStatusException;
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

import java.net.URI;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;

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

	private static void _loadComponent(JiraProject jiraProject, BasicComponent component)
		throws JiraConnectionException, PortalException, SystemException {

		JiraComponent jiraComponent = null;

		try {
			jiraComponent =
				JiraComponentLocalServiceUtil.addJiraComponent(
					component.getSelf().toString(),
					jiraProject.getJiraProjectId(), component.getName(), false);

			_log.info(jiraProject.getKey() + " imported sucessfully");
		}
		catch (DuplicateJiraComponentException djce) {
			_log.warn(
				"Jira Comonent with uri '" + component.getSelf() +
					"' already exists. Let's update it.");

			jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					component.getSelf().toString());

			jiraComponent.setDisabled(false);
			jiraComponent.setName(component.getName());
			jiraComponent.setModifiedDate(new Date());

			JiraComponentLocalServiceUtil.updateJiraComponent(jiraComponent);

			_log.info(jiraComponent.getUri() + " updated sucessfully");
		}
	}

	private static void _loadComponents(Project project, JiraProject jiraProject)
		throws JiraConnectionException, PortalException, SystemException {

		Iterable<BasicComponent> components = project.getComponents();

		for (BasicComponent component : components) {
			_loadComponent(jiraProject, component);
		}
	}

	private static void _loadIssuesMetric(
			Project project, List<Status> statuses)
		throws JiraConnectionException, PortalException, SystemException {

		Date date = new Date();

		List<IssuesMetric> issuesMetricList =
			JiraUtil.getIssuesCountByProjectStatus(project, statuses);

		for (IssuesMetric issueMetric : issuesMetricList) {
			BasicComponent issuesMetricComponent = issueMetric.getComponent();

			URI componentUri = issuesMetricComponent.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					componentUri.toString());

			Status issuesMetricStatus = issueMetric.getStatus();
			URI statusUri = issuesMetricStatus.getSelf();

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					statusUri.toString());

			Priority priority = issueMetric.getPriority();

			JiraMetric jiraMetric = null;

			try {
				jiraMetric = JiraMetricLocalServiceUtil.addJiraMetric(
					jiraComponent.getJiraProjectId(),
					jiraComponent.getJiraComponentId(),
					jiraStatus.getJiraStatusId(), priority.getId().intValue(),
					date, issueMetric.getTotal());

				_log.info("[" + jiraMetric.getJiraProjectId() + "][" + jiraMetric.getJiraComponentId() + "][" + jiraMetric.getJiraStatusId()+ "]"  + " imported sucessfully");
			}
			catch (DuplicateJiraMetricException djme) {
				_log.warn(
					"Jira Metric with project '" + jiraComponent.getJiraProjectId() +
						"', component '" + jiraComponent.getJiraComponentId() + "', status '" + jiraStatus.getJiraStatusId() + "', priority '" +priority.getId().intValue() + "' and date '" + date +
						"' already exists. Let's update it.");

				jiraMetric =
					JiraMetricLocalServiceUtil.getJiraMetric(jiraComponent.getJiraProjectId(), jiraComponent.getJiraComponentId(), jiraStatus.getJiraStatusId(), priority.getId().intValue(), date);

				jiraMetric.setTotal(issueMetric.getTotal());
				jiraMetric.setModifiedDate(new Date());

				JiraMetricLocalServiceUtil.updateJiraMetric(jiraMetric);

				_log.info("[" + jiraMetric.getJiraProjectId() + "][" + jiraMetric.getJiraComponentId() + "][" + jiraMetric.getJiraStatusId()+ "]"  + " updated sucessfully");
			}
		}
	}

	private static void _loadProject(BasicProject basicProject)
		throws JiraConnectionException, PortalException, SystemException {

		JiraProject jiraProject = null;

		try {
			jiraProject =
				JiraProjectLocalServiceUtil.addJiraProject(
					basicProject.getKey(), basicProject.getName());

			_log.info(jiraProject.getKey() + " imported sucessfully");
		}
		catch (DuplicateJiraProjectException djpe) {
			_log.warn(
				"Jira Project with key '" + basicProject.getKey() +
				"' already exists. Let's update it.");

			jiraProject =
				JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
					basicProject.getKey());

			jiraProject.setName(basicProject.getName());
			jiraProject.setModifiedDate(new Date());

			JiraProjectLocalServiceUtil.updateJiraProject(jiraProject);

			_log.info(jiraProject.getKey() + " updated sucessfully");
		}

		Project project = JiraUtil.getProject(basicProject.getKey());

		_loadComponents(project, jiraProject);
	}

	private static void _loadProjects()
		throws JiraConnectionException, PortalException, SystemException {

		List<BasicProject> projects = JiraUtil.getAllJiraProjects();

		for (BasicProject project : projects) {
			_loadProject(project);
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

	private static void _loadStatuses()
		throws JiraConnectionException, PortalException, SystemException {

		List<Status> statuses = JiraUtil.getAllJiraStatuses();

		for (Status status : statuses) {
			_loadStatus(status);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JiraETLUtil.class);

}