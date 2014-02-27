/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

package com.liferay.jira.metrics;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Manuel de la Peña
 */
public class NoSuchJiraMetricException extends NoSuchModelException {

	public NoSuchJiraMetricException() {
		super();
	}

	public NoSuchJiraMetricException(String msg) {
		super(msg);
	}

	public NoSuchJiraMetricException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchJiraMetricException(Throwable cause) {
		super(cause);
	}

}