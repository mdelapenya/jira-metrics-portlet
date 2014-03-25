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

import com.liferay.jira.metrics.model.JiraPriority;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the jira priority service. This utility wraps {@link JiraPriorityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Pe√±a
 * @see JiraPriorityPersistence
 * @see JiraPriorityPersistenceImpl
 * @generated
 */
public class JiraPriorityUtil {
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
	public static void clearCache(JiraPriority jiraPriority) {
		getPersistence().clearCache(jiraPriority);
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
	public static List<JiraPriority> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JiraPriority> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JiraPriority> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JiraPriority update(JiraPriority jiraPriority)
		throws SystemException {
		return getPersistence().update(jiraPriority);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JiraPriority update(JiraPriority jiraPriority,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jiraPriority, serviceContext);
	}

	/**
	* Returns the jira priority where value = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	*
	* @param value the value
	* @return the matching jira priority
	* @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority findByValue(
		java.lang.String value)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByValue(value);
	}

	/**
	* Returns the jira priority where value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param value the value
	* @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority fetchByValue(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByValue(value);
	}

	/**
	* Returns the jira priority where value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param value the value
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority fetchByValue(
		java.lang.String value, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByValue(value, retrieveFromCache);
	}

	/**
	* Removes the jira priority where value = &#63; from the database.
	*
	* @param value the value
	* @return the jira priority that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority removeByValue(
		java.lang.String value)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByValue(value);
	}

	/**
	* Returns the number of jira priorities where value = &#63;.
	*
	* @param value the value
	* @return the number of matching jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByValue(java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByValue(value);
	}

	/**
	* Returns the jira priority where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	*
	* @param name the name
	* @return the matching jira priority
	* @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority findByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the jira priority where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the jira priority where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira priority, or <code>null</code> if a matching jira priority could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the jira priority where name = &#63; from the database.
	*
	* @param name the name
	* @return the jira priority that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority removeByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of jira priorities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the jira priority in the entity cache if it is enabled.
	*
	* @param jiraPriority the jira priority
	*/
	public static void cacheResult(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority) {
		getPersistence().cacheResult(jiraPriority);
	}

	/**
	* Caches the jira priorities in the entity cache if it is enabled.
	*
	* @param jiraPriorities the jira priorities
	*/
	public static void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraPriority> jiraPriorities) {
		getPersistence().cacheResult(jiraPriorities);
	}

	/**
	* Creates a new jira priority with the primary key. Does not add the jira priority to the database.
	*
	* @param jiraPriorityId the primary key for the new jira priority
	* @return the new jira priority
	*/
	public static com.liferay.jira.metrics.model.JiraPriority create(
		long jiraPriorityId) {
		return getPersistence().create(jiraPriorityId);
	}

	/**
	* Removes the jira priority with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraPriorityId the primary key of the jira priority
	* @return the jira priority that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority remove(
		long jiraPriorityId)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(jiraPriorityId);
	}

	public static com.liferay.jira.metrics.model.JiraPriority updateImpl(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jiraPriority);
	}

	/**
	* Returns the jira priority with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraPriorityException} if it could not be found.
	*
	* @param jiraPriorityId the primary key of the jira priority
	* @return the jira priority
	* @throws com.liferay.jira.metrics.NoSuchJiraPriorityException if a jira priority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority findByPrimaryKey(
		long jiraPriorityId)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(jiraPriorityId);
	}

	/**
	* Returns the jira priority with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraPriorityId the primary key of the jira priority
	* @return the jira priority, or <code>null</code> if a jira priority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraPriority fetchByPrimaryKey(
		long jiraPriorityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jiraPriorityId);
	}

	/**
	* Returns all the jira priorities.
	*
	* @return the jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraPriority> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the jira priorities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira priorities
	* @param end the upper bound of the range of jira priorities (not inclusive)
	* @return the range of jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraPriority> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the jira priorities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira priorities
	* @param end the upper bound of the range of jira priorities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraPriority> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jira priorities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jira priorities.
	*
	* @return the number of jira priorities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JiraPriorityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JiraPriorityPersistence)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraPriorityPersistence.class.getName());

			ReferenceRegistry.registerReference(JiraPriorityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JiraPriorityPersistence persistence) {
	}

	private static JiraPriorityPersistence _persistence;
}