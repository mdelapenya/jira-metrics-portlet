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

import com.liferay.jira.metrics.model.JiraComponent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jira component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraComponentPersistenceImpl
 * @see JiraComponentUtil
 * @generated
 */
public interface JiraComponentPersistence extends BasePersistence<JiraComponent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JiraComponentUtil} to access the jira component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent findByJiraComponent(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByJiraComponent(
		java.lang.String name, long jiraProjectId);

	/**
	* Returns the jira component where name = &#63; and jiraProjectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByJiraComponent(
		java.lang.String name, long jiraProjectId, boolean retrieveFromCache);

	/**
	* Removes the jira component where name = &#63; and jiraProjectId = &#63; from the database.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the jira component that was removed
	*/
	public com.liferay.jira.metrics.model.JiraComponent removeByJiraComponent(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the number of jira components where name = &#63; and jiraProjectId = &#63;.
	*
	* @param name the name
	* @param jiraProjectId the jira project ID
	* @return the number of matching jira components
	*/
	public int countByJiraComponent(java.lang.String name, long jiraProjectId);

	/**
	* Returns the jira component where uri = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param uri the uri
	* @return the matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent findByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uri the uri
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByUri(
		java.lang.String uri);

	/**
	* Returns the jira component where uri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uri the uri
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByUri(
		java.lang.String uri, boolean retrieveFromCache);

	/**
	* Removes the jira component where uri = &#63; from the database.
	*
	* @param uri the uri
	* @return the jira component that was removed
	*/
	public com.liferay.jira.metrics.model.JiraComponent removeByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the number of jira components where uri = &#63;.
	*
	* @param uri the uri
	* @return the number of matching jira components
	*/
	public int countByUri(java.lang.String uri);

	/**
	* Returns all the jira components where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the matching jira components
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId);

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId, int start, int end);

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findByJiraProjectId(
		long jiraProjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent findByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the first jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent findByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the last jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira component, or <code>null</code> if a matching jira component could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Returns the jira components before and after the current jira component in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraComponentId the primary key of the current jira component
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent[] findByJiraProjectId_PrevAndNext(
		long jiraComponentId, long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Removes all the jira components where jiraProjectId = &#63; from the database.
	*
	* @param jiraProjectId the jira project ID
	*/
	public void removeByJiraProjectId(long jiraProjectId);

	/**
	* Returns the number of jira components where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the number of matching jira components
	*/
	public int countByJiraProjectId(long jiraProjectId);

	/**
	* Caches the jira component in the entity cache if it is enabled.
	*
	* @param jiraComponent the jira component
	*/
	public void cacheResult(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent);

	/**
	* Caches the jira components in the entity cache if it is enabled.
	*
	* @param jiraComponents the jira components
	*/
	public void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraComponent> jiraComponents);

	/**
	* Creates a new jira component with the primary key. Does not add the jira component to the database.
	*
	* @param jiraComponentId the primary key for the new jira component
	* @return the new jira component
	*/
	public com.liferay.jira.metrics.model.JiraComponent create(
		long jiraComponentId);

	/**
	* Removes the jira component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent remove(
		long jiraComponentId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	public com.liferay.jira.metrics.model.JiraComponent updateImpl(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent);

	/**
	* Returns the jira component with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraComponentException} if it could not be found.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component
	* @throws com.liferay.jira.metrics.NoSuchJiraComponentException if a jira component with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent findByPrimaryKey(
		long jiraComponentId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException;

	/**
	* Returns the jira component with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component, or <code>null</code> if a jira component with the primary key could not be found
	*/
	public com.liferay.jira.metrics.model.JiraComponent fetchByPrimaryKey(
		long jiraComponentId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.jira.metrics.model.JiraComponent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the jira components.
	*
	* @return the jira components
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll();

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll(
		int start, int end);

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
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

	/**
	* Removes all the jira components from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of jira components.
	*
	* @return the number of jira components
	*/
	public int countAll();
}