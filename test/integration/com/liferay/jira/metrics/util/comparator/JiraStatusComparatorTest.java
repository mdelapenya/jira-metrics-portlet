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
package com.liferay.jira.metrics.util.comparator;

import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.model.impl.JiraStatusImpl;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Manuel de la Peña
 */
@RunWith(Arquillian.class)
public class JiraStatusComparatorTest {

	@Test
	public void testCompareFirstBeforeSecond() {
		JiraStatus jiraStatus1 = new JiraStatusImpl();

		jiraStatus1.setName("Aaaa");

		JiraStatus jiraStatus2 = new JiraStatusImpl();

		jiraStatus2.setName("aaaa");

		JiraStatusComparator jiraStatusComparator = new JiraStatusComparator(
			true);

		int value = jiraStatusComparator.compare(jiraStatus1, jiraStatus2);

		Assert.assertTrue(value > 0);
	}

	@Test
	public void testCompareSecondBeforeFirst() {
		JiraStatus jiraStatus1 = new JiraStatusImpl();

		jiraStatus1.setName("aaaa");

		JiraStatus jiraStatus2 = new JiraStatusImpl();

		jiraStatus2.setName("Aaaa");

		JiraStatusComparator jiraStatusComparator = new JiraStatusComparator(
			true);

		int value = jiraStatusComparator.compare(jiraStatus1, jiraStatus2);

		Assert.assertTrue(value < 0);
	}

}