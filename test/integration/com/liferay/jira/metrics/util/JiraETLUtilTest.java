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
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import com.google.common.collect.Lists;
import com.liferay.jira.metrics.client.MockJiraStorage;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.plugins.test.BaseArquillianTestCase;
import com.liferay.portal.kernel.util.StringPool;

import java.net.URI;

import java.util.Date;
import java.util.List;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class JiraETLUtilTest extends BaseArquillianTestCase {

	@Before
	public void setUp() throws Exception {

		Class JiraETLUtilTestClass = JiraETLUtilTest.class;

		String JiraETLUtilTestName = JiraETLUtilTestClass.getName();

		Project project = _mockJiraStorage.getMockProject();

		String projectKey = project.getKey();

		List<Status> statuses = _mockJiraStorage.getMockStatuses();

		String[] statusNames = new String[statuses.size()];

		int i = 0;

		for (Status status : statuses) {
			statusNames[i] = status.getName();
			i++;
		}

		List<BasicComponent> components = Lists.newArrayList(
			project.getComponents());

		String[] componentNames = new String[components.size()];

		i = 0;

		for (BasicComponent component : components) {
			componentNames[i] = component.getName();
			i++;
		}

		List<Priority> priorities = _mockJiraStorage.getMockPriorities();

		String[] priorityNames = new String[priorities.size()];

		i = 0;

		for (Priority priority : priorities) {
			if(priority == null) {
				priorityNames[i] = "";
			}
			else {
				priorityNames[i] = priority.getId().toString();
			}
			i++;
		}

		String portletPreferencesXML =
			PortletPreferencesTestUtil.getPortletPreferencesXML(
				JiraETLUtilTestName, projectKey, statusNames, componentNames,
				priorityNames);

		PortletPreferencesTestUtil.addPortletPreferences(
			_PORTLET_ID, portletPreferencesXML);
	}

	@After
	public void tearDown() throws Exception {

		Project project = _mockJiraStorage.getMockProject();

		for (BasicComponent component : project.getComponents()) {
			URI uriComponent = component.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					uriComponent.toString());

			JiraComponentLocalServiceUtil.deleteJiraComponent(jiraComponent);
		}

		JiraProject jiraProject =
			JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
				project.getKey());

		JiraProjectLocalServiceUtil.deleteJiraProject(jiraProject);

		List<Status> statuses = _mockJiraStorage.getMockStatuses();

		for (Status status : statuses) {
			URI uriStatus = status.getSelf();

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					uriStatus.toString());

			JiraStatusLocalServiceUtil.deleteJiraStatus(jiraStatus);
		}

		PortletPreferencesTestUtil.deletePortletPreferences(_PORTLET_ID);
	}

	@Test
	public void testLoad() throws Exception {
		JiraETLUtil.load();

		Project project = _mockJiraStorage.getMockProject();

		JiraProject jiraProject =
			JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
				project.getKey());

		Assert.assertNotNull(jiraProject);

		Assert.assertEquals(jiraProject.getName(), project.getName() );
		Assert.assertEquals(jiraProject.getKey(), project.getKey() );

		for (BasicComponent component : project.getComponents()) {
			URI uriComponent = component.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					uriComponent.toString());

			Assert.assertNotNull(jiraComponent);
			Assert.assertEquals(jiraComponent.getName(), component.getName() );
			Assert.assertEquals(
				jiraComponent.getUri(), uriComponent.toString());
		}

		List<Status> statuses = _mockJiraStorage.getMockStatuses();

		for (Status status : statuses) {
			URI uriStatus = status.getSelf();

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					uriStatus.toString());

			Assert.assertNotNull(jiraStatus);
			Assert.assertEquals(jiraStatus.getName(), status.getName());
			Assert.assertEquals(jiraStatus.getUri(), uriStatus.toString());
			Assert.assertEquals(jiraStatus.getName(), status.getName());
			Assert.assertEquals(jiraStatus.getUri(), uriStatus.toString());
		}

		List<Priority> priorities = _mockJiraStorage.getMockPriorities();

		int count = 0;

		for (BasicComponent component : project.getComponents()) {
			URI uriComponent = component.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					uriComponent.toString());

			for (Status status : statuses) {
				URI uriStatus = status.getSelf();

				JiraStatus jiraStatus =
					JiraStatusLocalServiceUtil.getJiraStatusByUri(
						uriStatus.toString());

				for (Priority priority : priorities) {
					count++;

					int priorityValue = IssuesMetric.EMPTY_PRIORITY;

					if (priority != null) {
						priorityValue = priority.getId().intValue();
					}

					JiraMetric jiraMetric =
						JiraMetricLocalServiceUtil.getJiraMetric(
							jiraProject.getJiraProjectId(),
							jiraComponent.getJiraComponentId(),
							jiraStatus.getJiraStatusId(), priorityValue,
							new Date());

					Assert.assertNotNull(jiraMetric);
					Assert.assertEquals(jiraMetric.getTotal(), count);
				}
			}
		}
	}

	private static MockJiraStorage _mockJiraStorage = new MockJiraStorage();
	private static final String _PORTLET_ID =
		PortletKeys.JIRA_METRICS_PORTLET_ID + StringPool.UNDERLINE +
			JiraETLUtilTest.class.getCanonicalName();

}