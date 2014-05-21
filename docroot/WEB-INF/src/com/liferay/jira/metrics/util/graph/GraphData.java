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
package com.liferay.jira.metrics.util.graph;

import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraDataRetrieve;
import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cristina González
 */
public class GraphData {

	public GraphData(
			List<JiraDataRetrieve> jiraDataRetrieves, JiraProject jiraProject,
			List<JiraStatus> jiraStatuses, List<JiraComponent> jiraComponents,
			List<JiraPriority> jiraPriorities)
		throws PortalException, SystemException {

		for (JiraDataRetrieve jiraDataRetrieve : jiraDataRetrieves) {
			Map<String, Integer> bugsByPriority = new HashMap<String, Integer>();

			Date date =
				JiraDataRetrieveLocalServiceUtil.getDate(jiraDataRetrieve);

			for (JiraComponent jiraComponent : jiraComponents) {
				for (JiraStatus jiraStatus : jiraStatuses) {
					Integer value = bugsByPriority.get("");

					if (value == null) {
						value = 0;
					}

					JiraMetric jiraMetric =
						JiraMetricLocalServiceUtil.getJiraMetric(
							jiraProject.getJiraProjectId(),
							jiraComponent.getJiraComponentId(),
							jiraStatus.getJiraStatusId(), -1, date);

					value += jiraMetric.getTotal();

					bugsByPriority.put("priorityEmpty", value);
				}
			}

			for (JiraPriority jiraPriority : jiraPriorities) {
				for (JiraComponent jiraComponent : jiraComponents) {
					for (JiraStatus jiraStatus : jiraStatuses) {
						Integer value =
							bugsByPriority.get(jiraPriority.getValue());

						if (value == null) {
							value = 0;
						}

						JiraMetric jiraMetric =
							JiraMetricLocalServiceUtil.getJiraMetric(
								jiraProject.getJiraProjectId(),
								jiraComponent.getJiraComponentId(),
								jiraStatus.getJiraStatusId(),
								jiraPriority.getJiraPriorityId(), date);

						value += jiraMetric.getTotal();

						bugsByPriority.put(
							"priority"+jiraPriority.getValue(), value);
					}
				}
			}

			for (String bugByPriority :bugsByPriority.keySet()) {
				List<Values> values = _data.get(date);

				if (values == null) {
					values = new ArrayList<Values>();
				}

				if(!_series.contains(bugsByPriority)) {
					_series.add(bugByPriority);
				}

				values.add(
					new Values(
						bugByPriority, bugsByPriority.get(bugByPriority)));

				_data.put(date, values);
			}
		}
	}

	public List<String> getGraphSeries() {
		return _series;
	}

	public String getGraphSeriesStyles() {

		int i = 0;
		if(_series != null) {

			StringBundler sb = new StringBundler(19);

			sb.append("");

			for(String serie : _series) {
				if(!sb.toString().equals("")) {
					sb.append(",\n");
				}

				sb.append(serie + ":" + "{");

				sb.append("area: {");

				sb.append("color: \"");
				sb.append(_BACKGROUND_COLORS[i]);
				sb.append("\"");

				sb.append("},");

				sb.append("marker: {");

				sb.append("fill: {");

				sb.append("color: \"");
				sb.append(_BACKGROUND_COLORS[i]);
				sb.append("\"");

				sb.append("},");

				sb.append("border: {");

				sb.append("color: \"");
				sb.append(_LINES_COLORS[i]);
				sb.append("\"");

				sb.append("},");

				sb.append("over: {");

				sb.append("fill: {");

				sb.append("color: \"");
				sb.append(_LINES_COLORS[i]);
				sb.append("\"");

				sb.append("},");

				sb.append("border: {");

				sb.append("color: \"");
				sb.append(_LINES_COLORS[i]);
				sb.append("\"");

				sb.append("},");

				sb.append("width: 12,");
				sb.append("height: 12");

				sb.append("},");

				sb.append("},");

				sb.append("line: {");

				sb.append("color: \"");
				sb.append(_LINES_COLORS[i]);
				sb.append("\"");

				sb.append("}");

				sb.append("}");

				i++;
			}

			return sb.toString();
		}
		return null;
	}

	public String getStringData() {
		if(_data != null) {
			StringBundler sb = new StringBundler(19);

			sb.append("");

			for (Date date: _data.keySet()) {
				
				String stringDate = _formatter.format(date);

				if(!sb.toString().equals("")) {
					sb.append(",\n");
				}
				sb.append("{date:\"" +stringDate+"\"");

				for(Values value: _data.get(date)) {
					sb.append(", " + value.getSerieName() + ":" + value.getValue());
				}

				sb.append("}");
			}

			return sb.toString();
		}
		return null;

	}

	private Map<Date, List<Values>> _data = new HashMap<Date, List<Values>>();
	private List<String> _series = new ArrayList<String>();
	private static DateFormat _formatter = new SimpleDateFormat("MM/dd/yyyy");
	private static final String[] _BACKGROUND_COLORS = new String[] {"#4572A7", "#AA4643", "#89A54E", "#80699B", "#3D96AE", "#DB843D", "#92A8CD", "#A47D7C", "#B5CA92"};
	private static final String[] _LINES_COLORS = new String[] {"#365476", "#5F2624", "#4C5C2A", "#80699B", "#3D96AE", "#DB843D", "#92A8CD", "#A47D7C", "#B5CA92"};

}
