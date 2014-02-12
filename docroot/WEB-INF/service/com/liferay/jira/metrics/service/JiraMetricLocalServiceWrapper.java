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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JiraMetricLocalService}.
 *
 * @author Manuel de la Peña
 * @see JiraMetricLocalService
 * @generated
 */
public class JiraMetricLocalServiceWrapper implements JiraMetricLocalService,
	ServiceWrapper<JiraMetricLocalService> {
	public JiraMetricLocalServiceWrapper(
		JiraMetricLocalService jiraMetricLocalService) {
		_jiraMetricLocalService = jiraMetricLocalService;
	}

	/**
	* Adds the jira metric to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric addJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.addJiraMetric(jiraMetric);
	}

	/**
	* Creates a new jira metric with the primary key. Does not add the jira metric to the database.
	*
	* @param jiraMetricId the primary key for the new jira metric
	* @return the new jira metric
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric createJiraMetric(
		long jiraMetricId) {
		return _jiraMetricLocalService.createJiraMetric(jiraMetricId);
	}

	/**
	* Deletes the jira metric with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric that was removed
	* @throws PortalException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric deleteJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.deleteJiraMetric(jiraMetricId);
	}

	/**
	* Deletes the jira metric from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric deleteJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.deleteJiraMetric(jiraMetric);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraMetricLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraMetric fetchJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.fetchJiraMetric(jiraMetricId);
	}

	/**
	* Returns the jira metric with the primary key.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric
	* @throws PortalException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetric(jiraMetricId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetrics(start, end);
	}

	/**
	* Returns the number of jira metrics.
	*
	* @return the number of jira metrics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJiraMetricsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetricsCount();
	}

	/**
	* Updates the jira metric in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraMetric the jira metric
	* @return the jira metric that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraMetric updateJiraMetric(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.updateJiraMetric(jiraMetric);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraMetricLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraMetricLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraMetricLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, java.util.Date date)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetric(jiraProjectId,
			jiraComponentId, jiraStatusId, priority, date);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraMetric getJiraMetric(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetric(jiraProjectId,
			jiraComponentId, jiraStatusId, priority, day, month, year);
	}

	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetrics(jiraProjectId,
			jiraComponentId, jiraStatusId, date);
	}

	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> getJiraMetrics(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetricLocalService.getJiraMetrics(jiraProjectId,
			jiraComponentId, jiraStatusId, day, month, year);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraMetricLocalService getWrappedJiraMetricLocalService() {
		return _jiraMetricLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraMetricLocalService(
		JiraMetricLocalService jiraMetricLocalService) {
		_jiraMetricLocalService = jiraMetricLocalService;
	}

	@Override
	public JiraMetricLocalService getWrappedService() {
		return _jiraMetricLocalService;
	}

	@Override
	public void setWrappedService(JiraMetricLocalService jiraMetricLocalService) {
		_jiraMetricLocalService = jiraMetricLocalService;
	}

	private JiraMetricLocalService _jiraMetricLocalService;
}