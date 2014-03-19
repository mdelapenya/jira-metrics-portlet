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
import com.liferay.jira.metrics.client.JiraClientMock;
import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;
import com.liferay.plugins.test.BaseArquillianTestCase;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public class JiraETLUtilTest extends BaseArquillianTestCase{

	@Before
	public void setUp() throws Exception {

		String prefs =
			"\t\t<portlet-preferences>\n" +
			"\t\t\t<preference>\n" +
			"\t\t\t\t<name>jiraComponents</name>\n" +
			"\t\t\t\t<value>Component 1</value>\n" +
			"\t\t\t\t<value>Component 2</value>\n" +
			"\t\t\t</preference>\n" +
			"\t\t\t<preference>\n" +
			"\t\t\t\t<name>jiraPriorities</name>\n" +
			"\t\t\t\t<value>1</value>\n" +
			"\t\t\t\t<value>2</value>\n" +
			"\t\t\t</preference>\n" +
			"\t\t\t<preference>\n" +
			"\t\t\t\t<name>jiraProject</name>\n" +
			"\t\t\t\t<value>Project1</value>\n" +
			"\t\t\t</preference>\n" +
			"\t\t\t<preference>\n" +
			"\t\t\t\t<name>jiraStatuses</name>\n" +
			"\t\t\t\t<value>Status 1</value>\n" +
			"\t\t\t\t<value>Status 2</value>\n" +
			"\t\t\t</preference>\n" +
			"\t\t\t<preference>\n" +
			"\t\t\t\t<name>name</name>\n" +
			"\t\t\t\t<value>Test</value>\n" +
			"\t\t\t</preference>\n" +
			"\t\t</portlet-preferences>";

		PortletPreferencesLocalServiceUtil.addPortletPreferences(
			0, 0, 3, 0,
			"jirametricsportlet_WAR_jirametricsportlet_INSTANCE_abcde", null,
			prefs);
	}

	@After
	public void tearDown() throws Exception {

		Project project = JiraClientMock.getMockProject();

		for(BasicComponent component : project.getComponents()) {
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

		List<Status> statuses = JiraClientMock.getMockStatuses();

		for(Status status : statuses) {
			URI uriStatus = status.getSelf();

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					uriStatus.toString());

			JiraStatusLocalServiceUtil.deleteJiraStatus(jiraStatus);
		}

		PortletPreferencesLocalServiceUtil.deletePortletPreferences(
			0,3,0,"jirametricsportlet_WAR_jirametricsportlet_INSTANCE_abcde");
	}


	@Test
	public void testLoad() throws Exception{
		JiraETLUtil.load();

		Project project = JiraClientMock.getMockProject();

		JiraProject jiraProject =
			JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
				project.getKey());

		Assert.assertNotNull(jiraProject);

		Assert.assertEquals(jiraProject.getName(), project.getName() );
		Assert.assertEquals(jiraProject.getKey(), project.getKey() );

		for(BasicComponent component : project.getComponents()) {
			URI uriComponent = component.getSelf();

			JiraComponent jiraComponent =
				JiraComponentLocalServiceUtil.getJiraComponentByUri(
					uriComponent.toString());

			Assert.assertNotNull(jiraComponent);
			Assert.assertEquals(jiraComponent.getName(), component.getName() );
			Assert.assertEquals(
				jiraComponent.getUri(), uriComponent.toString());
		}

		List<Status> statuses = JiraClientMock.getMockStatuses();

		for(Status status : statuses) {
			URI uriStatus = status.getSelf();

			JiraStatus jiraStatus =
				JiraStatusLocalServiceUtil.getJiraStatusByUri(
					uriStatus.toString());

			Assert.assertNotNull(jiraStatus);
			Assert.assertEquals(jiraStatus.getName(),status.getName());
			Assert.assertEquals(jiraStatus.getUri(),uriStatus.toString());
			Assert.assertEquals(jiraStatus.getName(), status.getName());
			Assert.assertEquals(jiraStatus.getUri(), uriStatus.toString());
		}

		List<Priority> priorities = JiraClientMock.getMockPriorities();

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

}