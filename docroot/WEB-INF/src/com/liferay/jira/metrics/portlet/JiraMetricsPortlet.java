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

package com.liferay.jira.metrics.portlet;

import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Manuel de la Peña
 */
public class JiraMetricsPortlet extends MVCPortlet {

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		String jiraProjectKey = ParamUtil.getString(
			resourceRequest, "jiraProjectKey");

		JiraProject jiraProject = null;

		try {
			jiraProject =
				JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(
					jiraProjectKey);
		}
		catch (Exception e) {
			throw new PortletException(e);
		}

		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray componentsNameCode =
			JSONFactoryUtil.getJSONFactory().createJSONArray();

		List<JiraComponent> componentList = null;

		try {
			componentList =
				JiraComponentLocalServiceUtil.getJiraComponentsByJiraProjectId(
					jiraProject.getJiraProjectId());
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}

		for (JiraComponent component : componentList) {
			componentsNameCode.put(
				component.getName() + ":" + component.getName());
		}

		jsonFeed.put("componentsNameCode", componentsNameCode);

		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");

		PrintWriter writer = resourceResponse.getWriter();

		writer.write(jsonFeed.toString());
	}

	private static Log _log = LogFactoryUtil.getLog(JiraMetricsPortlet.class);

}