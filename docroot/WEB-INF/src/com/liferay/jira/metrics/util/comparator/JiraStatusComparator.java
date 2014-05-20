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
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Cristina González
 */
public class JiraStatusComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "name ASC";

	public static final String ORDER_BY_DESC = "name DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public JiraStatusComparator() {
		this(false);
	}

	public JiraStatusComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object o1, Object o2) {
		JiraStatus jiraStatus1 = (JiraStatus)o1;
		JiraStatus jiraStatus2 = (JiraStatus)o2;

		int value = jiraStatus1.getName().compareTo(jiraStatus2.getName());

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