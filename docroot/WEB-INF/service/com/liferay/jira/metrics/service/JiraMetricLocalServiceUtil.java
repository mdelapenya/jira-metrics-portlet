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

package com.liferay.jira.metrics.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for JiraMetric. This utility wraps
 * {@link com.liferay.jira.metrics.service.impl.JiraMetricLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Manuel de la Peña
 * @see JiraMetricLocalService
 * @see com.liferay.jira.metrics.service.base.JiraMetricLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.impl.JiraMetricLocalServiceImpl
 * @generated
 */
public class JiraMetricLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.jira.metrics.service.impl.JiraMetricLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the jira metric to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraMetric addJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJiraMetric(jiraMetric);
	}

	/**
	* Creates a new jira metric with the primary key. Does not add the jira metric to the database.
	*
	* @param jiraMetricId the primary key for the new jira metric
	* @return the new jira metric
	*/
	public static com.liferay.jira.metrics.model.JiraMetric createJiraMetric(
		long jiraMetricId) {
		return getService().createJiraMetric(jiraMetricId);
	}

	/**
	* Deletes the jira metric with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric that was removed
	* @throws PortalException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraMetric deleteJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJiraMetric(jiraMetricId);
	}

	/**
	* Deletes the jira metric from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraMetric deleteJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJiraMetric(jiraMetric);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.jira.metrics.model.JiraMetric fetchJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJiraMetric(jiraMetricId);
	}

	/**
	* Returns the jira metric with the primary key.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric
	* @throws PortalException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraMetric(jiraMetricId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the jira metrics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira metrics
	* @param end the upper bound of the range of jira metrics (not inclusive)
	* @return the range of jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraMetrics(start, end);
	}

	/**
	* Returns the number of jira metrics.
	*
	* @return the number of jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public static int getJiraMetricsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraMetricsCount();
	}

	/**
	* Updates the jira metric in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraMetric updateJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJiraMetric(jiraMetric);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.jira.metrics.model.JiraMetric addJiraMetric(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, java.util.Date date, int total)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addJiraMetric(jiraProjectId, jiraComponentId, jiraStatusId,
			priority, date, total);
	}

	public static com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, java.util.Date date)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJiraMetric(jiraProjectId, jiraComponentId, jiraStatusId,
			priority, date);
	}

	public static com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJiraMetric(jiraProjectId, jiraComponentId, jiraStatusId,
			priority, day, month, year);
	}

	public static java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJiraMetrics(jiraProjectId, jiraComponentId,
			jiraStatusId, date);
	}

	public static java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getJiraMetrics(jiraProjectId, jiraComponentId,
			jiraStatusId, day, month, year);
	}

	public static void clearService() {
		_service = null;
	}

	public static JiraMetricLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JiraMetricLocalService.class.getName());

			if (invokableLocalService instanceof JiraMetricLocalService) {
				_service = (JiraMetricLocalService)invokableLocalService;
			}
			else {
				_service = new JiraMetricLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JiraMetricLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JiraMetricLocalService service) {
	}

	private static JiraMetricLocalService _service;
}