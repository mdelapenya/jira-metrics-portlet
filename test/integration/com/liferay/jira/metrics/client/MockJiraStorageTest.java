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

package com.liferay.jira.metrics.client;

import com.atlassian.jira.rest.client.domain.BasicComponent;
import com.atlassian.jira.rest.client.domain.Priority;
import com.atlassian.jira.rest.client.domain.Project;
import com.atlassian.jira.rest.client.domain.Status;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class MockJiraStorageTest {

	@Test
	public void testGetMockComponents() throws Exception {
		MockJiraStorage mockJiraStorage = new MockJiraStorage();

		List<BasicComponent> mockComponents =
			mockJiraStorage.getMockComponents();

		Assert.assertEquals(2, mockComponents.size());

		for (int i = 0; i < mockComponents.size(); i++) {
			BasicComponent mockComponent = mockComponents.get(i);

			int id = i + 1;

			Assert.assertEquals("component" + id, mockComponent.getName());
			Assert.assertEquals(
				getUri("component", id), mockComponent.getSelf());
		}
	}

	@Test
	public void testGetMockPriorities() throws Exception {
		MockJiraStorage mockJiraStorage = new MockJiraStorage();

		List<Priority> mockPriorities = mockJiraStorage.getMockPriorities();

		Assert.assertEquals(2, mockPriorities.size());

		for (int i = 0; i < mockPriorities.size(); i++) {
			Priority mockPriority = mockPriorities.get(i);

			int id = i + 1;

			Assert.assertEquals(String.valueOf(id), mockPriority.getName());
			Assert.assertEquals(getUri("priority", id), mockPriority.getSelf());
		}
	}

	@Test
	public void testGetMockProject() throws Exception {
		MockJiraStorage mockJiraStorage = new MockJiraStorage();

		Project mockProject = mockJiraStorage.getMockProject();

		Assert.assertEquals(
			String.valueOf("project" + 1), mockProject.getName());
		Assert.assertEquals(getUri("project", 1), mockProject.getSelf());
	}

	@Test
	public void testGetMockStatuses() throws Exception {
		MockJiraStorage mockJiraStorage = new MockJiraStorage();

		List<Status> mockStatuses = mockJiraStorage.getMockStatuses();

		Assert.assertEquals(2, mockStatuses.size());

		for (int i = 0; i < mockStatuses.size(); i++) {
			Status mockStatus = mockStatuses.get(i);

			int id = i + 1;

			Assert.assertEquals(
				String.valueOf("status" + id), mockStatus.getName());
			Assert.assertEquals(getUri("status", id), mockStatus.getSelf());
		}
	}

	private URI getUri(String keyword, int id) throws URISyntaxException {
		return new URI(_JIRA_TEST_URI + keyword + "/" + id);
	}

	private static final String _JIRA_TEST_URI = "http://www.liferay.com/test/";

}