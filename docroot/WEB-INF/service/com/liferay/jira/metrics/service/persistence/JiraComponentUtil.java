/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

import com.liferay.jira.metrics.model.JiraComponent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the jira component service. This utility wraps {@link JiraComponentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraComponentPersistence
 * @see JiraComponentPersistenceImpl
 * @generated
 */
public class JiraComponentUtil {
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
	public static void clearCache(JiraComponent jiraComponent) {
		getPersistence().clearCache(jiraComponent);
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
	public static List<JiraComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JiraComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JiraComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JiraComponent update(JiraComponent jiraComponent)
		throws SystemException {
		return getPersistence().update(jiraComponent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JiraComponent update(JiraComponent jiraComponent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jiraComponent, serviceContext);
	}

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent findByJiraComponent(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJiraComponent(name, jiraProjectId);
	}

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByJiraComponent(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJiraComponent(name, jiraProjectId);
	}

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByJiraComponent(
		java.lang.String name, long jiraProjectId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJiraComponent(name, jiraProjectId, retrieveFromCache);
	}

	/**
	* Removes the jira component where name = &#63; and jiraProjectId = &#63; from the database.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the jira component that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent removeByJiraComponent(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByJiraComponent(name, jiraProjectId);
	}

	/**
	* Returns the number of jira components where name = &#63; and jiraProjectId = &#63;.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the number of matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJiraComponent(java.lang.String name,
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJiraComponent(name, jiraProjectId);
	}

	/**
	* Returns the jira component where uri = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param uri the uri
	* @return the matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent findByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUri(uri);
	}

	/**
	* Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uri the uri
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByUri(
		java.lang.String uri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUri(uri);
	}

	/**
	* Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uri the uri
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByUri(
		java.lang.String uri, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUri(uri, retrieveFromCache);
	}

	/**
	* Removes the jira component where uri = &#63; from the database.
	*
	* @param uri the uri
	* @return the jira component that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent removeByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUri(uri);
	}

	/**
	* Returns the number of jira components where uri = &#63;.
	*
	* @param uri the uri
	* @return the number of matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUri(java.lang.String uri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUri(uri);
	}

	/**
	* Returns all the jira components where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJiraProjectId(jiraProjectId);
	}

	/**
	* Returns a range of all the jira components where jiraProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param start the lower bound of the range of jira components
	* @param end the upper bound of the range of jira components (not inclusive)
	* @return the range of matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJiraProjectId(jiraProjectId, start, end);
	}

	/**
	* Returns an ordered range of all the jira components where jiraProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param start the lower bound of the range of jira components
	* @param end the upper bound of the range of jira components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJiraProjectId(jiraProjectId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent findByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJiraProjectId_First(jiraProjectId, orderByComparator);
	}

	/**
	* Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJiraProjectId_First(jiraProjectId, orderByComparator);
	}

	/**
	* Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent findByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJiraProjectId_Last(jiraProjectId, orderByComparator);
	}

	/**
	* Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira component, or <code>null</code> if a matching jira component could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJiraProjectId_Last(jiraProjectId, orderByComparator);
	}

	/**
	* Returns the jira components before and after the current jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraComponentId the primary key of the current jira component
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent[] findByJiraProjectId_PrevAndNext(
		long jiraComponentId, long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJiraProjectId_PrevAndNext(jiraComponentId,
			jiraProjectId, orderByComparator);
	}

	/**
	* Removes all the jira components where jiraProjectId = &#63; from the database.
	*
	* @param jiraProjectId the jira project ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByJiraProjectId(long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByJiraProjectId(jiraProjectId);
	}

	/**
	* Returns the number of jira components where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the number of matching jira components
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJiraProjectId(long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJiraProjectId(jiraProjectId);
	}

	/**
	* Caches the jira component in the entity cache if it is enabled.
	*
	* @param jiraComponent the jira component
	*/
	public static void cacheResult(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent) {
		getPersistence().cacheResult(jiraComponent);
	}

	/**
	* Caches the jira components in the entity cache if it is enabled.
	*
	* @param jiraComponents the jira components
	*/
	public static void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraComponent> jiraComponents) {
		getPersistence().cacheResult(jiraComponents);
	}

	/**
	* Creates a new jira component with the primary key. Does not add the jira component to the database.
	*
	* @param jiraComponentId the primary key for the new jira component
	* @return the new jira component
	*/
	public static com.liferay.jira.metrics.model.JiraComponent create(
		long jiraComponentId) {
		return getPersistence().create(jiraComponentId);
	}

	/**
	* Removes the jira component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent remove(
		long jiraComponentId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(jiraComponentId);
	}

	public static com.liferay.jira.metrics.model.JiraComponent updateImpl(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jiraComponent);
	}

	/**
	* Returns the jira component with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent findByPrimaryKey(
		long jiraComponentId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(jiraComponentId);
	}

	/**
	* Returns the jira component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component, or <code>null</code> if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraComponent fetchByPrimaryKey(
		long jiraComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jiraComponentId);
	}

	/**
	* Returns all the jira components.
	*
	* @return the jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the jira components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira components
	* @param end the upper bound of the range of jira components (not inclusive)
	* @return the range of jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the jira components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira components
	* @param end the upper bound of the range of jira components (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira components
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jira components from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jira components.
	*
	* @return the number of jira components
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JiraComponentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JiraComponentPersistence)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraComponentPersistence.class.getName());

			ReferenceRegistry.registerReference(JiraComponentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JiraComponentPersistence persistence) {
	}

	private static JiraComponentPersistence _persistence;
}