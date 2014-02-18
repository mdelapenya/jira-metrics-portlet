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

import com.liferay.jira.metrics.model.JiraStatus;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the jira status service. This utility wraps {@link JiraStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraStatusPersistence
 * @see JiraStatusPersistenceImpl
 * @generated
 */
public class JiraStatusUtil {
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
	public static void clearCache(JiraStatus jiraStatus) {
		getPersistence().clearCache(jiraStatus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JiraStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JiraStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JiraStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JiraStatus update(JiraStatus jiraStatus)
		throws SystemException {
		return getPersistence().update(jiraStatus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JiraStatus update(JiraStatus jiraStatus,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jiraStatus, serviceContext);
	}

	/**
	* Returns the jira status where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param name the name
	* @return the matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus findByStatus(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(name);
	}

	/**
	* Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus fetchByStatus(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus(name);
	}

	/**
	* Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus fetchByStatus(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus(name, retrieveFromCache);
	}

	/**
	* Removes the jira status where name = &#63; from the database.
	*
	* @param name the name
	* @return the jira status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus removeByStatus(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByStatus(name);
	}

	/**
	* Returns the number of jira statuses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(name);
	}

	/**
	* Returns the jira status where uri = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param uri the uri
	* @return the matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus findByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUri(uri);
	}

	/**
	* Returns the jira status where uri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uri the uri
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus fetchByUri(
		java.lang.String uri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUri(uri);
	}

	/**
	* Returns the jira status where uri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uri the uri
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus fetchByUri(
		java.lang.String uri, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUri(uri, retrieveFromCache);
	}

	/**
	* Removes the jira status where uri = &#63; from the database.
	*
	* @param uri the uri
	* @return the jira status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus removeByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUri(uri);
	}

	/**
	* Returns the number of jira statuses where uri = &#63;.
	*
	* @param uri the uri
	* @return the number of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUri(java.lang.String uri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUri(uri);
	}

	/**
	* Caches the jira status in the entity cache if it is enabled.
	*
	* @param jiraStatus the jira status
	*/
	public static void cacheResult(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus) {
		getPersistence().cacheResult(jiraStatus);
	}

	/**
	* Caches the jira statuses in the entity cache if it is enabled.
	*
	* @param jiraStatuses the jira statuses
	*/
	public static void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraStatus> jiraStatuses) {
		getPersistence().cacheResult(jiraStatuses);
	}

	/**
	* Creates a new jira status with the primary key. Does not add the jira status to the database.
	*
	* @param jiraStatusId the primary key for the new jira status
	* @return the new jira status
	*/
	public static com.liferay.jira.metrics.model.JiraStatus create(
		long jiraStatusId) {
		return getPersistence().create(jiraStatusId);
	}

	/**
	* Removes the jira status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus remove(
		long jiraStatusId)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(jiraStatusId);
	}

	public static com.liferay.jira.metrics.model.JiraStatus updateImpl(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jiraStatus);
	}

	/**
	* Returns the jira status with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus findByPrimaryKey(
		long jiraStatusId)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(jiraStatusId);
	}

	/**
	* Returns the jira status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status, or <code>null</code> if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraStatus fetchByPrimaryKey(
		long jiraStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jiraStatusId);
	}

	/**
	* Returns all the jira statuses.
	*
	* @return the jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the jira statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira statuses
	* @param end the upper bound of the range of jira statuses (not inclusive)
	* @return the range of jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the jira statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira statuses
	* @param end the upper bound of the range of jira statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jira statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jira statuses.
	*
	* @return the number of jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JiraStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JiraStatusPersistence)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(JiraStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JiraStatusPersistence persistence) {
	}

	private static JiraStatusPersistence _persistence;
}