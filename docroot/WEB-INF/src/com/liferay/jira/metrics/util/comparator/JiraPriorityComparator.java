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

import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Cristina González
 */
public class JiraPriorityComparator extends BaseJiraComparator {

	public JiraPriorityComparator() {
		this(false);
	}

	public JiraPriorityComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	protected int getCompareToValue(Object o1, Object o2) {
		JiraPriority jiraPriority1 = (JiraPriority)o1;
		JiraPriority jiraPriority2 = (JiraPriority)o2;

		int value = jiraPriority1.getValue().compareTo(
			jiraPriority2.getValue());

		return value;
	}

	@Override
	protected String getFieldName() {
		return "value";
	}

}