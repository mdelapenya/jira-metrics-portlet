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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jira status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraStatusPersistenceImpl
 * @see JiraStatusUtil
 * @generated
 */
public interface JiraStatusPersistence extends BasePersistence<JiraStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JiraStatusUtil} to access the jira status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the jira status where name = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param name the name
	* @return the matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus findByStatus(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByStatus(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByStatus(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the jira status where name = &#63; from the database.
	*
	* @param name the name
	* @return the jira status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus removeByStatus(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira statuses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status where jiraStatusCode = &#63; or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param jiraStatusCode the jira status code
	* @return the matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus findByJiraStatusCode(
		long jiraStatusCode)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status where jiraStatusCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param jiraStatusCode the jira status code
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByJiraStatusCode(
		long jiraStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status where jiraStatusCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param jiraStatusCode the jira status code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByJiraStatusCode(
		long jiraStatusCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the jira status where jiraStatusCode = &#63; from the database.
	*
	* @param jiraStatusCode the jira status code
	* @return the jira status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus removeByJiraStatusCode(
		long jiraStatusCode)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira statuses where jiraStatusCode = &#63;.
	*
	* @param jiraStatusCode the jira status code
	* @return the number of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByJiraStatusCode(long jiraStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jira statuses where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findByJiraProjectId(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the jira statuses where jiraProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param start the lower bound of the range of jira statuses
	* @param end the upper bound of the range of jira statuses (not inclusive)
	* @return the range of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findByJiraProjectId(
		long jiraProjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the jira statuses where jiraProjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jiraProjectId the jira project ID
	* @param start the lower bound of the range of jira statuses
	* @param end the upper bound of the range of jira statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findByJiraProjectId(
		long jiraProjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first jira status in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus findByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first jira status in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByJiraProjectId_First(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last jira status in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus findByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last jira status in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching jira status, or <code>null</code> if a matching jira status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByJiraProjectId_Last(
		long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira statuses before and after the current jira status in the ordered set where jiraProjectId = &#63;.
	*
	* @param jiraStatusId the primary key of the current jira status
	* @param jiraProjectId the jira project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus[] findByJiraProjectId_PrevAndNext(
		long jiraStatusId, long jiraProjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jira statuses where jiraProjectId = &#63; from the database.
	*
	* @param jiraProjectId the jira project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJiraProjectId(long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira statuses where jiraProjectId = &#63;.
	*
	* @param jiraProjectId the jira project ID
	* @return the number of matching jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByJiraProjectId(long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the jira status in the entity cache if it is enabled.
	*
	* @param jiraStatus the jira status
	*/
	public void cacheResult(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus);

	/**
	* Caches the jira statuses in the entity cache if it is enabled.
	*
	* @param jiraStatuses the jira statuses
	*/
	public void cacheResult(
		java.util.List<com.liferay.jira.metrics.model.JiraStatus> jiraStatuses);

	/**
	* Creates a new jira status with the primary key. Does not add the jira status to the database.
	*
	* @param jiraStatusId the primary key for the new jira status
	* @return the new jira status
	*/
	public com.liferay.jira.metrics.model.JiraStatus create(long jiraStatusId);

	/**
	* Removes the jira status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status that was removed
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus remove(long jiraStatusId)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.jira.metrics.model.JiraStatus updateImpl(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status with the primary key or throws a {@link com.liferay.jira.metrics.NoSuchJiraStatusException} if it could not be found.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status
	* @throws com.liferay.jira.metrics.NoSuchJiraStatusException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus findByPrimaryKey(
		long jiraStatusId)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jira status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status, or <code>null</code> if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.jira.metrics.model.JiraStatus fetchByPrimaryKey(
		long jiraStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jira statuses.
	*
	* @return the jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jira statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jira statuses.
	*
	* @return the number of jira statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}