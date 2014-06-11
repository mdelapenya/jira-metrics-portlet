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
 * Provides a wrapper for {@link JiraDataRetrieveLocalService}.
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieveLocalService
 * @generated
 */
public class JiraDataRetrieveLocalServiceWrapper
	implements JiraDataRetrieveLocalService,
		ServiceWrapper<JiraDataRetrieveLocalService> {
	public JiraDataRetrieveLocalServiceWrapper(
		JiraDataRetrieveLocalService jiraDataRetrieveLocalService) {
		_jiraDataRetrieveLocalService = jiraDataRetrieveLocalService;
	}

	/**
	* Adds the jira data retrieve to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was added
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve addJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		return _jiraDataRetrieveLocalService.addJiraDataRetrieve(jiraDataRetrieve);
	}

	/**
	* Creates a new jira data retrieve with the primary key. Does not add the jira data retrieve to the database.
	*
	* @param jiraDataRetrieveId the primary key for the new jira data retrieve
	* @return the new jira data retrieve
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve createJiraDataRetrieve(
		long jiraDataRetrieveId) {
		return _jiraDataRetrieveLocalService.createJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Deletes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve that was removed
	* @throws PortalException if a jira data retrieve with the primary key could not be found
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve deleteJiraDataRetrieve(
		long jiraDataRetrieveId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jiraDataRetrieveLocalService.deleteJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Deletes the jira data retrieve from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was removed
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve deleteJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		return _jiraDataRetrieveLocalService.deleteJiraDataRetrieve(jiraDataRetrieve);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraDataRetrieveLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _jiraDataRetrieveLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _jiraDataRetrieveLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraDataRetrieveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _jiraDataRetrieveLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _jiraDataRetrieveLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _jiraDataRetrieveLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchJiraDataRetrieve(
		long jiraDataRetrieveId) {
		return _jiraDataRetrieveLocalService.fetchJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Returns the jira data retrieve with the primary key.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve
	* @throws PortalException if a jira data retrieve with the primary key could not be found
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve getJiraDataRetrieve(
		long jiraDataRetrieveId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jiraDataRetrieveLocalService.getJiraDataRetrieve(jiraDataRetrieveId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _jiraDataRetrieveLocalService.getActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jiraDataRetrieveLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _jiraDataRetrieveLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> getJiraDataRetrieves(
		int start, int end) {
		return _jiraDataRetrieveLocalService.getJiraDataRetrieves(start, end);
	}

	/**
	* Returns the number of jira data retrieves.
	*
	* @return the number of jira data retrieves
	*/
	@Override
	public int getJiraDataRetrievesCount() {
		return _jiraDataRetrieveLocalService.getJiraDataRetrievesCount();
	}

	/**
	* Updates the jira data retrieve in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was updated
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve updateJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		return _jiraDataRetrieveLocalService.updateJiraDataRetrieve(jiraDataRetrieve);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraDataRetrieveLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraDataRetrieveLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraDataRetrieveLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve addJiraDataRetrieve(
		java.lang.String status, java.lang.String statusDescription,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraDataRetrieveLocalService.addJiraDataRetrieve(status,
			statusDescription, date);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve fetchByDate(
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraDataRetrieveLocalService.fetchByDate(date);
	}

	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> getByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraDataRetrieveLocalService.getByStatus(status, start, end);
	}

	@Override
	public java.util.Date getDate(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraDataRetrieveLocalService.getDate(jiraDataRetrieve);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public JiraDataRetrieveLocalService getWrappedJiraDataRetrieveLocalService() {
		return _jiraDataRetrieveLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedJiraDataRetrieveLocalService(
		JiraDataRetrieveLocalService jiraDataRetrieveLocalService) {
		_jiraDataRetrieveLocalService = jiraDataRetrieveLocalService;
	}

	@Override
	public JiraDataRetrieveLocalService getWrappedService() {
		return _jiraDataRetrieveLocalService;
	}

	@Override
	public void setWrappedService(
		JiraDataRetrieveLocalService jiraDataRetrieveLocalService) {
		_jiraDataRetrieveLocalService = jiraDataRetrieveLocalService;
	}

	private JiraDataRetrieveLocalService _jiraDataRetrieveLocalService;
}