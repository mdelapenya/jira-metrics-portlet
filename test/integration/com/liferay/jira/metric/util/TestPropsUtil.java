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
package com.liferay.jira.metric.util;

import com.liferay.jira.metrics.util.JiraUtil;

import java.io.IOException;

import java.util.Properties;

/**
 * @author Cristina González
 */
public class TestPropsUtil {

	static {
		_loadProperties();
	}

	public static String getValue(String value) {
		return _properties.getProperty(value);
	}

	private static void _loadProperties() {
		_properties = new Properties();
		try {
			ClassLoader classLoader = JiraUtil.class.getClassLoader();

			if (classLoader.getResource(_NAME_EXT_PROPERTIES_FILE) != null) {
				_properties.load(
					classLoader.getResourceAsStream(_NAME_EXT_PROPERTIES_FILE));
			}
			else {
				_properties.load(
					classLoader.getResourceAsStream(_NAME_PROPERTIES_FILE));
			}
		}
		catch (IOException ex) {
			throw new RuntimeException("Can't load properties");
		}
	}

	private static final String _NAME_EXT_PROPERTIES_FILE =
		"portlet-ext.properties";

	private static final String _NAME_PROPERTIES_FILE = "portlet.properties";

	private static Properties _properties;

}