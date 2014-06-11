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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the jira data retrieve service. This utility wraps {@link JiraDataRetrievePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrievePersistence
 * @see JiraDataRetrievePersistenceImpl
 * @generated
 */
public class JiraDataRetrieveUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(JiraDataRetrieve jiraDataRetrieve) {
		getPersistence().clearCache(jiraDataRetrieve);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JiraDataRetrieve> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JiraDataRetrieve> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JiraDataRetrieve> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JiraDataRetrieve update(JiraDataRetrieve jiraDataRetrieve) {
		return getPersistence().update(jiraDataRetrieve);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JiraDataRetrieve update(JiraDataRetrieve jiraDataRetrieve,
		ServiceContext serviceContext) {
		return getPersistence().update(jiraDataRetrieve, serviceContext);
	}

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve findByD_M_Y(
		int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().findByD_M_Y(day, month, year);
	}

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchByD_M_Y(
		int day, int month, int year) {
		return getPersistence().fetchByD_M_Y(day, month, year);
	}

	/**
	* Returns the jira data retrieve where day = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchByD_M_Y(
		int day, int month, int year, boolean retrieveFromCache) {
		return getPersistence().fetchByD_M_Y(day, month, year, retrieveFromCache);
	}

	/**
	* Removes the jira data retrieve where day = &#63; and month = &#63; and year = &#63; from the database.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the jira data retrieve that was removed
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve removeByD_M_Y(
		int day, int month, int year)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().removeByD_M_Y(day, month, year);
	}

	/**
	* Returns the number of jira data retrieves where day = &#63; and month = &#63; and year = &#63;.
	*
	* @param day the day
	* @param month the month
	* @param year the year
	* @return the number of matching jira data retrieves
	*/
	public static int countByD_M_Y(int day, int month, int year) {
		return getPersistence().countByD_M_Y(day, month, year);
	}

	/**
	* Returns all the jira data retrieves where status = &#63;.
	*
	* @param status the status
	* @return the matching jira data retrieves
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status) {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last jira data retrieve in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira data retrieve, or <code>null</code> if a matching jira data retrieve could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the jira data retrieves before and after the current jira data retrieve in the ordered set where status = &#63;.
	*
	* @param jiraDataRetrieveId the primary key of the current jira data retrieve
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve[] findByStatus_PrevAndNext(
		long jiraDataRetrieveId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence()
				   .findByStatus_PrevAndNext(jiraDataRetrieveId, status,
			orderByComparator);
	}

	/**
	* Removes all the jira data retrieves where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeByStatus(java.lang.String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of jira data retrieves where status = &#63;.
	*
	* @param status the status
	* @return the number of matching jira data retrieves
	*/
	public static int countByStatus(java.lang.String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the jira data retrieve in the entity cache if it is enabled.
	*
	* @param jiraDataRetrieve the jira data retrieve
	*/
	public static void cacheResult(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		getPersistence().cacheResult(jiraDataRetrieve);
	}

	/**
	* Caches the jira data retrieves in the entity cache if it is enabled.
	*
	* @param jiraDataRetrieves the jira data retrieves
	*/
	public static void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> jiraDataRetrieves) {
		getPersistence().cacheResult(jiraDataRetrieves);
	}

	/**
	* Creates a new jira data retrieve with the primary key. Does not add the jira data retrieve to the database.
	*
	* @param jiraDataRetrieveId the primary key for the new jira data retrieve
	* @return the new jira data retrieve
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve create(
		long jiraDataRetrieveId) {
		return getPersistence().create(jiraDataRetrieveId);
	}

	/**
	* Removes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve remove(
		long jiraDataRetrieveId)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().remove(jiraDataRetrieveId);
	}

	public static com.liferay.jira.metrics.model.JiraDataRetrieve updateImpl(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		return getPersistence().updateImpl(jiraDataRetrieve);
	}

	/**
	* Returns the jira data retrieve with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraDataRetrieveException} if it could not be found.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve
	* @throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException if a jira data retrieve with the primary key could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve findByPrimaryKey(
		long jiraDataRetrieveId)
		throws com.liferay.jira.metrics.NoSuchJiraDataRetrieveException {
		return getPersistence().findByPrimaryKey(jiraDataRetrieveId);
	}

	/**
	* Returns the jira data retrieve with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve, or <code>null</code> if a jira data retrieve with the primary key could not be found
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchByPrimaryKey(
		long jiraDataRetrieveId) {
		return getPersistence().fetchByPrimaryKey(jiraDataRetrieveId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.jira.metrics.model.JiraDataRetrieve> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the jira data retrieves.
	*
	* @return the jira data retrieves
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll() {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jira data retrieves from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jira data retrieves.
	*
	* @return the number of jira data retrieves
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JiraDataRetrievePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JiraDataRetrievePersistence)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraDataRetrievePersistence.class.getName());

			ReferenceRegistry.registerReference(JiraDataRetrieveUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(JiraDataRetrievePersistence persistence) {
	}

	private static JiraDataRetrievePersistence _persistence;
}