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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.atlassian.jira.rest.client.domain.Priority" %>

<%@ page import="com.liferay.jira.metrics.model.JiraComponent" %><%@
page import="com.liferay.jira.metrics.model.JiraDataRetrieve" %><%@
page import="com.liferay.jira.metrics.model.JiraPriority" %><%@
page import="com.liferay.jira.metrics.model.JiraProject" %><%@
page import="com.liferay.jira.metrics.model.JiraStatus" %><%@
page import="com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.JiraProjectLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil" %><%@
page import="com.liferay.jira.metrics.service.impl.JiraPriorityLocalServiceImpl" %><%@
page import="com.liferay.jira.metrics.util.JiraETLUtil" %><%@
page import="com.liferay.jira.metrics.util.PortletKeys" %><%@
page import="com.liferay.jira.metrics.util.comparator.JiraPriorityComparator" %><%@
page import="com.liferay.jira.metrics.util.comparator.JiraProjectComparator" %><%@
page import="com.liferay.jira.metrics.util.comparator.JiraStatusComparator" %><%@
page import="com.liferay.jira.metrics.util.graph.GraphData" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.PropsKeys" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Date" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />