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

package com.liferay.jira.metrics.messaging;

import com.liferay.jira.metrics.exception.JiraConnectionException;
import com.liferay.jira.metrics.util.JiraUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Manuel de la Peña
 */
public class JiraLoadScheduler {

	public static void load() {
		try {
			JiraUtil.getJiraUserData();

			JiraUtil.getDefaultSearch();
		} catch (JiraConnectionException e) {
			e.printStackTrace();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(JiraLoadScheduler.class);

}