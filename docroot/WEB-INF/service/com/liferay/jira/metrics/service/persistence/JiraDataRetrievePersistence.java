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

import com.liferay.jira.metrics.model.JiraDataRetrieve;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jira data retrieve service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrievePersistenceImpl
 * @see JiraDataRetrieveUtil
 * @generated
 */
public interface JiraDataRetrievePersistence extends BasePersistence<JiraDataRetrieve> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JiraDataRetrieveUtil} to access the jira data retrieve persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve findByD_M_Y(
		int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByD_M_Y(
		int day, int month, int year);

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByD_M_Y(
		int day, int month, int year, boolean retrieveFromCache);

	/**
	* Removes the jira data retrieve where day = &#63; and month = &#63; and year = &#63; from the database.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the jira data retrieve that was removed
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve removeByD_M_Y(
		int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Returns the number of jira data retrieves where day = &#63; and month = &#63; and year = &#63;.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the number of matching jira data retrieves
	*/
	public int countByD_M_Y(int day, int month, int year);

	/**
	* Returns all the jira data retrieves where status = &#63;.
	*
	* @param status the status
	* @return the matching jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status);

	/**
	* Returns a range of all the jira data retrieves where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of jira data retrieves
	* @param end the upper bound of the range of jira data retrieves (not inclusive)
	* @return the range of matching jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status, int start, int end);

	/**
	* Returns an ordered range of all the jira data retrieves where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of jira data retrieves
	* @param end the upper bound of the range of jira data retrieves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the first jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Returns the first jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the last jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Returns the last jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the jira data retrieves before and after the current jira data retrieve in the ordered set where status = &#63;.
	*
	* @param jiraDataRetrieveId the primary key of the current jira data retrieve
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve[] findByStatus_PrevAndNext(
		long jiraDataRetrieveId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Removes all the jira data retrieves where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeByStatus(java.lang.String status);

	/**
	* Returns the number of jira data retrieves where status = &#63;.
	*
	* @param status the status
	* @return the number of matching jira data retrieves
	*/
	public int countByStatus(java.lang.String status);

	/**
	* Caches the jira data retrieve in the entity cache if it is enabled.
	*
	* @param jiraDataRetrieve the jira data retrieve
	*/
	public void cacheResult(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve);

	/**
	* Caches the jira data retrieves in the entity cache if it is enabled.
	*
	* @param jiraDataRetrieves the jira data retrieves
	*/
	public void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> jiraDataRetrieves);

	/**
	* Creates a new jira data retrieve with the primary key. Does not add the jira data retrieve to the database.
	*
	* @param jiraDataRetrieveId the primary key for the new jira data retrieve
	* @return the new jira data retrieve
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve create(
		long jiraDataRetrieveId);

	/**
	* Removes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve remove(
		long jiraDataRetrieveId)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	public com.liferay.jira.metrics.model.JiraDataRetrieve updateImpl(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve);

	/**
	* Returns the jira data retrieve with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve findByPrimaryKey(
		long jiraDataRetrieveId)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException;

	/**
	* Returns the jira data retrieve with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve, or <code>null</code> if a jira data retrieve with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByPrimaryKey(
		long jiraDataRetrieveId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.jira.metrics.model.JiraDataRetrieve> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the jira data retrieves.
	*
	* @return the jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll();

	/**
	* Returns a range of all the jira data retrieves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira data retrieves
	* @param end the upper bound of the range of jira data retrieves (not inclusive)
	* @return the range of jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll(
		int start, int end);

	/**
	* Returns an ordered range of all the jira data retrieves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira data retrieves
	* @param end the upper bound of the range of jira data retrieves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira data retrieves
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Removes all the jira data retrieves from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of jira data retrieves.
	*
	* @return the number of jira data retrieves
	*/
	public int countAll();
}