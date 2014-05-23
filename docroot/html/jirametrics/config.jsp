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

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL" />

<%
	String teamName = portletPreferences.getValue("teamName", null);

	String jiraProjectKey = portletPreferences.getValue("jiraProject", null);

	String[] jiraStatusesNames = portletPreferences.getValues("jiraStatuses", null);

	String[] jiraPrioritiesVales = portletPreferences.getValues("jiraPriorities", null);

	String[] jiraComponentsNames = portletPreferences.getValues("jiraComponents", null);

	List<JiraProject> jiraProjects = JiraProjectLocalServiceUtil.getAllJiraProjects(new JiraProjectComparator());

	List<JiraStatus> jiraStatuses = JiraStatusLocalServiceUtil.getAllJiraStatuses(new JiraStatusComparator());

	JiraProject jiraProjectSelected = JiraProjectLocalServiceUtil.getJiraProjectByProjectLabel(jiraProjectKey);

	List<JiraComponent> jiraComponents = JiraComponentLocalServiceUtil.getJiraComponentsByJiraProjectId(jiraProjectSelected.getJiraProjectId());

	List<JiraPriority> jiraPriorities = JiraPriorityLocalServiceUtil.getAllJiraPriorities(new JiraPriorityComparator());
%>

<liferay-portlet:resourceURL id="myResourceID01" portletConfiguration="true"  var="fetchValues" />

<liferay-portlet:resourceURL id="myResourceID01" portletConfiguration="true"  var="fetchValues" />

<liferay-portlet:resourceURL portletName="jirametricsportlet_WAR_jirametricsportlet" var="fetchValuesOriginalValues" />

<aui:script use="aui-io-request">
	var projectSelector = A.one('#<portlet:namespace />jiraProject');

	projectSelector.on(
		'change',
		function(event) {
			A.io.request(
				'<%= fetchValuesOriginalValues %>&jiraProjectKey=' + event.currentTarget.val() + '&actionName=componentsValues',
				{
					dataType: 'json',
					on: {
						success: function(event) {
							var data = this.get('responseData');

							var newComponentsSelector = A.Node.create('<select class="aui-field-select" id="<portlet:namespace />jiraComponents" multiple="" name="<portlet:namespace />jiraComponents">');

							for (var i = 0; i < data.componentsNameCode.length; i++) {
								componentNameCode = data.componentsNameCode[i].split(':');

								newComponentsSelector.append('<option value="' + componentNameCode[0] + '">' + componentNameCode[1] + '</option>');
							}

							A.one('#<portlet:namespace />jiraComponents').replace(newComponentsSelector);
						}
					}
				}
			);
		}
	);
</aui:script>

<aui:form action="<%= actionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:input label="name" name="<%= PortletKeys.PARAM_JIRA_TEAM_NAME %>" value="<%= teamName %>" />

	<aui:select id="<%= PortletKeys.PARAM_JIRA_PROJECT %>" inlineField="true" label="project"  name="<%= PortletKeys.PARAM_JIRA_PROJECT %>">

		<%
			for (JiraProject jiraProject : jiraProjects) {
		%>

		<%String jiraProjectLabel = jiraProject.getKey() + " - " + jiraProject.getName(); %>

		<aui:option label="<%=jiraProjectLabel %>" selected="<%= jiraProjectKey.equals(jiraProject.getKey()) %>" value="<%= jiraProject.getKey() %>" />

		<%
			}
		%>

	</aui:select>

	<aui:select id="<%= PortletKeys.PARAM_JIRA_COMPONENTS %>" inlineField="true" label="components" multiple="true" name="<%= PortletKeys.PARAM_JIRA_COMPONENTS %>">

		<%
			for (JiraComponent jiraComponent : jiraComponents) {
		%>

		<aui:option label="<%=jiraComponent.getName() %>"  selected="<%= ArrayUtil.contains(jiraComponentsNames, jiraComponent.getName()) %>" value="<%=jiraComponent.getName() %>" />

		<%
			}
		%>

	</aui:select>

	<aui:select inlineField="true" label="status" multiple="true" name="<%= PortletKeys.PARAM_JIRA_STATUSES %>">

		<%
			for (JiraStatus jiraStatus : jiraStatuses) {
		%>

		<aui:option label="<%=jiraStatus.getName() %>"  selected="<%= ArrayUtil.contains(jiraStatusesNames, jiraStatus.getName()) %>" value="<%= jiraStatus.getName() %>" />

		<%
			}
		%>

	</aui:select>

	<aui:select inlineField="true" label="priority" multiple="true" name="<%= PortletKeys.PARAM_JIRA_PRIORITIES %>">

		<%
			for (JiraPriority jiraPriority: jiraPriorities) {
		%>

		<aui:option label="<%= jiraPriority.getValue() %>"  selected="<%= ArrayUtil.contains(jiraPrioritiesVales, jiraPriority.getValue()) %>" value="<%= jiraPriority.getValue() %>" />

		<%
			}
		%>

	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>