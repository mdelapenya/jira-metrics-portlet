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

import com.liferay.jira.metrics.model.JiraProject;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the jira project service. This utility wraps {@link JiraProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraProjectPersistence
 * @see JiraProjectPersistenceImpl
 * @generated
 */
public class JiraProjectUtil {
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
	public static void clearCache(JiraProject jiraProject) {
		getPersistence().clearCache(jiraProject);
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
	public static List<JiraProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JiraProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JiraProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static JiraProject update(JiraProject jiraProject)
		throws SystemException {
		return getPersistence().update(jiraProject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static JiraProject update(JiraProject jiraProject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jiraProject, serviceContext);
	}

	/**
	* Returns the jira project where jiraProjectCode = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param jiraProjectCode the jira project code
	* @return the matching jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject findByJiraProjectCode(
		long jiraProjectCode)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJiraProjectCode(jiraProjectCode);
	}

	/**
	* Returns the jira project where jiraProjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param jiraProjectCode the jira project code
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByJiraProjectCode(
		long jiraProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJiraProjectCode(jiraProjectCode);
	}

	/**
	* Returns the jira project where jiraProjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param jiraProjectCode the jira project code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByJiraProjectCode(
		long jiraProjectCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJiraProjectCode(jiraProjectCode, retrieveFromCache);
	}

	/**
	* Removes the jira project where jiraProjectCode = &#63; from the database.
	*
	* @param jiraProjectCode the jira project code
	* @return the jira project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject removeByJiraProjectCode(
		long jiraProjectCode)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByJiraProjectCode(jiraProjectCode);
	}

	/**
	* Returns the number of jira projects where jiraProjectCode = &#63;.
	*
	* @param jiraProjectCode the jira project code
	* @return the number of matching jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJiraProjectCode(long jiraProjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJiraProjectCode(jiraProjectCode);
	}

	/**
	* Returns the jira project where label = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param label the label
	* @return the matching jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject findByLabel(
		java.lang.String label)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLabel(label);
	}

	/**
	* Returns the jira project where label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param label the label
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label);
	}

	/**
	* Returns the jira project where label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param label the label
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByLabel(
		java.lang.String label, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label, retrieveFromCache);
	}

	/**
	* Removes the jira project where label = &#63; from the database.
	*
	* @param label the label
	* @return the jira project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject removeByLabel(
		java.lang.String label)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByLabel(label);
	}

	/**
	* Returns the number of jira projects where label = &#63;.
	*
	* @param label the label
	* @return the number of matching jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLabel(label);
	}

	/**
	* Returns the jira project where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param name the name
	* @return the matching jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject findByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the jira project where name = &#63; from the database.
	*
	* @param name the name
	* @return the jira project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject removeByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of jira projects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the jira project in the entity cache if it is enabled.
	*
	* @param jiraProject the jira project
	*/
	public static void cacheResult(
		com.liferay.jira.metrics.model.JiraProject jiraProject) {
		getPersistence().cacheResult(jiraProject);
	}

	/**
	* Caches the jira projects in the entity cache if it is enabled.
	*
	* @param jiraProjects the jira projects
	*/
	public static void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraProject> jiraProjects) {
		getPersistence().cacheResult(jiraProjects);
	}

	/**
	* Creates a new jira project with the primary key. Does not add the jira project to the database.
	*
	* @param jiraProjectId the primary key for the new jira project
	* @return the new jira project
	*/
	public static com.liferay.jira.metrics.model.JiraProject create(
		long jiraProjectId) {
		return getPersistence().create(jiraProjectId);
	}

	/**
	* Removes the jira project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject remove(
		long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(jiraProjectId);
	}

	public static com.liferay.jira.metrics.model.JiraProject updateImpl(
		com.liferay.jira.metrics.model.JiraProject jiraProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jiraProject);
	}

	/**
	* Returns the jira project with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject findByPrimaryKey(
		long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(jiraProjectId);
	}

	/**
	* Returns the jira project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project, or <code>null</code> if a jira project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraProject fetchByPrimaryKey(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(jiraProjectId);
	}

	/**
	* Returns all the jira projects.
	*
	* @return the jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the jira projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira projects
	* @param end the upper bound of the range of jira projects (not inclusive)
	* @return the range of jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the jira projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jira projects
	* @param end the upper bound of the range of jira projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the jira projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of jira projects.
	*
	* @return the number of jira projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JiraProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JiraProjectPersistence)PortletBeanLocatorUtil.locate(com.liferay.jira.metrics.service.ClpSerializer.getServletContextName(),
					JiraProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(JiraProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(JiraProjectPersistence persistence) {
	}

	private static JiraProjectPersistence _persistence;
}