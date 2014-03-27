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
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Cristina González
 */
public class JiraProjectComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "key ASC";

	public static final String ORDER_BY_DESC = "key DESC";

	public static final String[] ORDER_BY_FIELDS = {"key"};


	public JiraProjectComparator() {
		this(false);
	}

	public JiraProjectComparator(boolean ascending) {
		_ascending = ascending;
	}


	@Override
	public int compare(Object o1, Object o2) {
		JiraProject jiraProject1 = (JiraProject)o1;
		JiraProject jiraProject2 = (JiraProject)o2;

		int value = jiraProject1.getKey().compareTo(jiraProject2.getKey());

		if(_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;
}