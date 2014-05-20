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

package com.liferay.jira.metrics.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Manuel de la Peña
 */
public class JiraMetricFinderUtil {
	public static java.util.List<java.util.Date> findByDistinctDate(int size) {
		return getFinder().findByDistinctDate(size);
	}

	public static JiraMetricFinder getFinder() {
		if (_finder == null) {
			_finder = (JiraMetricFinder)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraMetricFinder.class.getName());

			ReferenceRegistry.registerReference(JiraMetricFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(JiraMetricFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(JiraMetricFinderUtil.class,
			"_finder");
	}

	private static JiraMetricFinder _finder;
}