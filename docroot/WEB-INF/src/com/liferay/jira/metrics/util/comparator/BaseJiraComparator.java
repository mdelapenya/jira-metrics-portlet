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

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Manuel de la Peña
 */
public abstract class BaseJiraComparator extends OrderByComparator {

	public BaseJiraComparator() {
		this(false);
	}

	public BaseJiraComparator(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int compare(Object o1, Object o2) {
		int value = getCompareToValue(o1, o2);

		if(ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (ascending) {
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
		return ascending;
	}

	protected abstract int getCompareToValue(Object o1, Object o2);

	protected abstract String getFieldName();

	protected final String ORDER_BY_ASC = getFieldName() + " ASC";

	protected final String ORDER_BY_DESC = getFieldName() + " DESC";

	protected final String[] ORDER_BY_FIELDS = {getFieldName()};

	protected boolean ascending;

}