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

/**
 * @author Cristina González
 */
public class JiraStatusComparator extends BaseJiraComparator {

	public JiraStatusComparator() {
		this(false);
	}

	public JiraStatusComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public int getCompareToValue(Object o1, Object o2) {
		JiraStatus jiraStatus1 = (JiraStatus)o1;
		JiraStatus jiraStatus2 = (JiraStatus)o2;

		return jiraStatus1.getName().compareTo(jiraStatus2.getName());
	}

	@Override
	public String getFieldName() {
		return "name";
	}

}