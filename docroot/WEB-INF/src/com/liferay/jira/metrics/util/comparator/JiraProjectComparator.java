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

import com.liferay.jira.metrics.model.JiraProject;

/**
 * @author Cristina González
 */
public class JiraProjectComparator extends BaseJiraComparator {

	public JiraProjectComparator() {
		this(false);
	}

	public JiraProjectComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public int getCompareToValue(Object o1, Object o2) {
		JiraProject jiraProject1 = (JiraProject)o1;
		JiraProject jiraProject2 = (JiraProject)o2;

		return jiraProject1.getKey().compareTo(jiraProject2.getKey());
	}

	@Override
	public String getFieldName() {
		return "key";
	}

}