<%--
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
--%>

<%@ include file="/html/jirametrics/init.jsp" %>

<%
	String teamName = portletPreferences.getValue("teamName", null);

	String jiraProjectKey = portletPreferences.getValue("jiraProject", null);

	String[] jiraStatusesNames = portletPreferences.getValues("jiraStatuses", null);

	String[] jiraComponentsNames = portletPreferences.getValues("jiraComponents", null);

	JiraProject jiraProject = JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(jiraProjectKey);

	List<JiraStatus> jiraStatuses = new ArrayList<JiraStatus>();

	for (String jiraStatusName : jiraStatusesNames) {
		JiraStatus jiraStatus = JiraStatusLocalServiceUtil.getJiraStatusByName(jiraStatusName);
		jiraStatuses.add(jiraStatus);
	}

	List<JiraComponent> jiraComponents = new ArrayList<JiraComponent>();

	for (String jiraComponentName : jiraComponentsNames) {
		JiraComponent jiraComponent = JiraComponentLocalServiceUtil.getJiraComponentByNameAndJiraProjectId(jiraComponentName, jiraProject.getJiraProjectId());
		jiraComponents.add(jiraComponent);
	}

	List<JiraPriority> jiraPriorities = JiraPriorityLocalServiceUtil.getAllJiraPriorities(new JiraPriorityComparator());

	List<JiraDataRetrieve> jiraDataRetrieves = JiraDataRetrieveLocalServiceUtil.getByStatus(JiraETLUtil.STATUS_OK, 0, 5);

	GraphData data = new GraphData(jiraDataRetrieves, jiraProject, jiraStatuses, jiraComponents, jiraPriorities);

	String stringData = data.getStringData();
%>

<b><%= teamName %></b>

<div class="group-statistics-chart">
	<div id="groupStatisticsChart"></div>
</div>



<aui:script use="charts-legend">
	var graphData = [
		<%= stringData %>
	];

	var tooltip = {
		markerLabelFunction: function(categoryItem, valueItem, itemIndex, series, seriesIndex) {
			return categoryItem.value+':'+series;
		},
		styles: {
			backgroundColor: '#FFF',
			borderColor: '#4572A7',
			borderWidth: 1,
			color: '#000',
			textAlign: 'center'
		}
	};

	var chartContainer = A.one('#groupStatisticsChart');

	var getContainerWidth = function(container) {
		return container.width() * 0.7;
	};

	var containerWidth = getContainerWidth(chartContainer);

	chartContainer.setStyle('height', containerWidth);


	var styleDef = {
			series: {
				<%= data.getGraphSeriesStyles()%>
			}
	};

	var chart = new A.Chart(
		{
			legend: {
				position: "right",
				width: 300,
				height: 300,
				styles: {
					hAlign: "center",
					hSpacing: 4
				}
			},
			axes: {
				category: {
					keys: ["date"],
					type: "category",
					styles: {
						label: {
							rotation: -45
						}
					}
				}
			},
			dataProvider: graphData,
			categoryKey: 'date',
			categoryType:'time',
			seriesKeys:['priority5', 'priority4', 'priority3'],
			tooltip: tooltip,
			type:"combo",
			stacked:true,
			styles:styleDef,
			horizontalGridlines: true,
			verticalGridlines: true,
			interactionType:"planar"
	}
	).render(chartContainer);

	chartContainer.one('.yui3-graph-content').all('path[fill=none], circle').each(
		function(item) {
			item.ancestor().append(item);
		}
	);

	Liferay.after(
		['portletMoved', 'liferaypanel:collapse'],
		function(event) {
			var width = getContainerWidth(chartContainer);

			if (width && (event.type == 'portletMoved' && event.portletId == '<%= portletDisplay.getId() %>') ||
				(event.type == 'liferaypanel:collapse' && event.panelId == 'groupStatisticsPanel')) {

				chart.set('width', width);

				chartContainer.setStyle('height', width);
			}
		}
	);
</aui:script>