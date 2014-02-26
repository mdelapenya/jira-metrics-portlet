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

import com.liferay.jira.metrics.model.JiraMetric;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jira metric service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraMetricPersistenceImpl
 * @see JiraMetricUtil
 * @generated
 */
public interface JiraMetricPersistence extends BasePersistence<JiraMetric> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JiraMetricUtil} to access the jira metric persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the jira metric where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and priority = &#63; and day = &#63; and month = &#63; and year = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraMetricException} if it could not be found.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param priority the priority
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira metric
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric findByP_C_S_P_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira metric where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and priority = &#63; and day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param priority the priority
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira metric, or <code>null</code> if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric fetchByP_C_S_P_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira metric where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and priority = &#63; and day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param priority the priority
	* @param day the day
	* @param month the month
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira metric, or <code>null</code> if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric fetchByP_C_S_P_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the jira metric where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and priority = &#63; and day = &#63; and month = &#63; and year = &#63; from the database.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param priority the priority
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the jira metric that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric removeByP_C_S_P_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId,
		int priority, int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and priority = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param priority the priority
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the number of matching jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_C_S_P_D_M_Y(long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int priority, int day, int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findByP_C_S_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param start the lower bound of the range of jira metrics
	* @param end the upper bound of the range of jira metrics (not inclusive)
	* @return the range of matching jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findByP_C_S_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param start the lower bound of the range of jira metrics
	* @param end the upper bound of the range of jira metrics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findByP_C_S_D_M_Y(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira metric
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric findByP_C_S_D_M_Y_First(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira metric, or <code>null</code> if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric fetchByP_C_S_D_M_Y_First(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira metric
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric findByP_C_S_D_M_Y_Last(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira metric, or <code>null</code> if a matching jira metric could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric fetchByP_C_S_D_M_Y_Last(
		long jiraProjectId, long jiraComponentId, long jiraStatusId, int day,
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira metrics before and after the current jira metric in the ordered set where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraMetricId the primary key of the current jira metric
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira metric
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric[] findByP_C_S_D_M_Y_PrevAndNext(
		long jiraMetricId, long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63; from the database.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_C_S_D_M_Y(long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira metrics where jiraProjectId = &#63; and jiraComponentId = &#63; and jiraStatusId = &#63; and day = &#63; and month = &#63; and year = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param jiraComponentId the jira component ID
	* @param jiraStatusId the jira status ID
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the number of matching jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_C_S_D_M_Y(long jiraProjectId, long jiraComponentId,
		long jiraStatusId, int day, int month, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the jira metric in the entity cache if it is enabled.
	*
	* @param jiraMetric the jira metric
	*/
	public void cacheResult(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric);

	/**
	* Caches the jira metrics in the entity cache if it is enabled.
	*
	* @param jiraMetrics the jira metrics
	*/
	public void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraMetric> jiraMetrics);

	/**
	* Creates a new jira metric with the primary key. Does not add the jira metric to the database.
	*
	* @param jiraMetricId the primary key for the new jira metric
	* @return the new jira metric
	*/
	public com.liferay.jira.metrics.model.JiraMetric create(long jiraMetricId);

	/**
	* Removes the jira metric with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric remove(long jiraMetricId)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.jira.metrics.model.JiraMetric updateImpl(
		com.liferay.jira.metrics.model.JiraMetric jiraMetric)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira metric with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraMetricException} if it could not be found.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric
	* @throws com.liferay.jira.metrics.NoSuchJiraMetricException if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric findByPrimaryKey(
		long jiraMetricId)
		throws com.liferay.jira.metrics.NoSuchJiraMetricException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira metric with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraMetricId the primary key of the jira metric
	* @return the jira metric, or <code>null</code> if a jira metric with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraMetric fetchByPrimaryKey(
		long jiraMetricId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jira metrics.
	*
	* @return the jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the jira metrics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraMetricModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira metrics
	* @param end the upper bound of the range of jira metrics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraMetric> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jira metrics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira metrics.
	*
	* @return the number of jira metrics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}