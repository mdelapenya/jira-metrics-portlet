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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jira project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraProjectPersistenceImpl
 * @see JiraProjectUtil
 * @generated
 */
public interface JiraProjectPersistence extends BasePersistence<JiraProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JiraProjectUtil} to access the jira project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the jira project where key = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param key the key
	* @return the matching jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject findByLabel(
		java.lang.String key)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	/**
	* Returns the jira project where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject fetchByLabel(
		java.lang.String key);

	/**
	* Returns the jira project where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject fetchByLabel(
		java.lang.String key, boolean retrieveFromCache);

	/**
	* Removes the jira project where key = &#63; from the database.
	*
	* @param key the key
	* @return the jira project that was removed
	*/
	public com.liferay.jira.metrics.model.JiraProject removeByLabel(
		java.lang.String key)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	/**
	* Returns the number of jira projects where key = &#63;.
	*
	* @param key the key
	* @return the number of matching jira projects
	*/
	public int countByLabel(java.lang.String key);

	/**
	* Returns the jira project where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param name the name
	* @return the matching jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject findByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	/**
	* Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject fetchByName(
		java.lang.String name);

	/**
	* Returns the jira project where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira project, or <code>null</code> if a matching jira project could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject fetchByName(
		java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the jira project where name = &#63; from the database.
	*
	* @param name the name
	* @return the jira project that was removed
	*/
	public com.liferay.jira.metrics.model.JiraProject removeByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	/**
	* Returns the number of jira projects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching jira projects
	*/
	public int countByName(java.lang.String name);

	/**
	* Caches the jira project in the entity cache if it is enabled.
	*
	* @param jiraProject the jira project
	*/
	public void cacheResult(
		com.liferay.jira.metrics.model.JiraProject jiraProject);

	/**
	* Caches the jira projects in the entity cache if it is enabled.
	*
	* @param jiraProjects the jira projects
	*/
	public void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraProject> jiraProjects);

	/**
	* Creates a new jira project with the primary key. Does not add the jira project to the database.
	*
	* @param jiraProjectId the primary key for the new jira project
	* @return the new jira project
	*/
	public com.liferay.jira.metrics.model.JiraProject create(long jiraProjectId);

	/**
	* Removes the jira project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject remove(long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	public com.liferay.jira.metrics.model.JiraProject updateImpl(
		com.liferay.jira.metrics.model.JiraProject jiraProject);

	/**
	* Returns the jira project with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraProjectException} if it could not be found.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project
	* @throws com.liferay.jira.metrics.NoSuchJiraProjectException if a jira project with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject findByPrimaryKey(
		long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException;

	/**
	* Returns the jira project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project, or <code>null</code> if a jira project with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraProject fetchByPrimaryKey(
		long jiraProjectId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.jira.metrics.model.JiraProject> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the jira projects.
	*
	* @return the jira projects
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll();

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll(
		int start, int end);

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Removes all the jira projects from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of jira projects.
	*
	* @return the number of jira projects
	*/
	public int countAll();
}