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

package com.liferay.jira.metrics.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JiraStatusLocalService}.
 *
 * @author Manuel de la Pe√±a
 * @see JiraStatusLocalService
 * @generated
 */
public class JiraStatusLocalServiceWrapper implements JiraStatusLocalService,
	ServiceWrapper<JiraStatusLocalService> {
	public JiraStatusLocalServiceWrapper(
		JiraStatusLocalService jiraStatusLocalService) {
		_jiraStatusLocalService = jiraStatusLocalService;
	}

	/**
	* Adds the jira status to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraStatus the jira status
	* @return the jira status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus addJiraStatus(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.addJiraStatus(jiraStatus);
	}

	/**
	* Creates a new jira status with the primary key. Does not add the jira status to the database.
	*
	* @param jiraStatusId the primary key for the new jira status
	* @return the new jira status
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus createJiraStatus(
		long jiraStatusId) {
		return _jiraStatusLocalService.createJiraStatus(jiraStatusId);
	}

	/**
	* Deletes the jira status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status that was removed
	* @throws PortalException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus deleteJiraStatus(
		long jiraStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.deleteJiraStatus(jiraStatusId);
	}

	/**
	* Deletes the jira status from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraStatus the jira status
	* @return the jira status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus deleteJiraStatus(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.deleteJiraStatus(jiraStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraStatusLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus fetchJiraStatus(
		long jiraStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.fetchJiraStatus(jiraStatusId);
	}

	/**
	* Returns the jira status with the primary key.
	*
	* @param jiraStatusId the primary key of the jira status
	* @return the jira status
	* @throws PortalException if a jira status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus getJiraStatus(
		long jiraStatusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getJiraStatus(jiraStatusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraStatus> getJiraStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getJiraStatuses(start, end);
	}

	/**
	* Returns the number of jira statuses.
	*
	* @return the number of jira statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJiraStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getJiraStatusesCount();
	}

	/**
	* Updates the jira status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraStatus the jira status
	* @return the jira status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraStatus updateJiraStatus(
		com.liferay.jira.metrics.model.JiraStatus jiraStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.updateJiraStatus(jiraStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus addJiraStatus(
		java.lang.String uri, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.addJiraStatus(uri, name);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus getJiraStatusByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getJiraStatusByUri(uri);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus getJiraStatusByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraStatusLocalService.getJiraStatusByName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraStatusLocalService getWrappedJiraStatusLocalService() {
		return _jiraStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraStatusLocalService(
		JiraStatusLocalService jiraStatusLocalService) {
		_jiraStatusLocalService = jiraStatusLocalService;
	}

	@Override
	public JiraStatusLocalService getWrappedService() {
		return _jiraStatusLocalService;
	}

	@Override
	public void setWrappedService(JiraStatusLocalService jiraStatusLocalService) {
		_jiraStatusLocalService = jiraStatusLocalService;
	}

	private JiraStatusLocalService _jiraStatusLocalService;
}