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
 * Provides a wrapper for {@link JiraComponentLocalService}.
 *
 * @author Manuel de la Pe√±a
 * @see JiraComponentLocalService
 * @generated
 */
public class JiraComponentLocalServiceWrapper
	implements JiraComponentLocalService,
		ServiceWrapper<JiraComponentLocalService> {
	public JiraComponentLocalServiceWrapper(
		JiraComponentLocalService jiraComponentLocalService) {
		_jiraComponentLocalService = jiraComponentLocalService;
	}

	/**
	* Adds the jira component to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraComponent the jira component
	* @return the jira component that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent addJiraComponent(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.addJiraComponent(jiraComponent);
	}

	/**
	* Creates a new jira component with the primary key. Does not add the jira component to the database.
	*
	* @param jiraComponentId the primary key for the new jira component
	* @return the new jira component
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent createJiraComponent(
		long jiraComponentId) {
		return _jiraComponentLocalService.createJiraComponent(jiraComponentId);
	}

	/**
	* Deletes the jira component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component that was removed
	* @throws PortalException if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent deleteJiraComponent(
		long jiraComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.deleteJiraComponent(jiraComponentId);
	}

	/**
	* Deletes the jira component from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraComponent the jira component
	* @return the jira component that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent deleteJiraComponent(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.deleteJiraComponent(jiraComponent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraComponentLocalService.dynamicQuery();
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
		return _jiraComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraComponentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraComponentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _jiraComponentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _jiraComponentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent fetchJiraComponent(
		long jiraComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.fetchJiraComponent(jiraComponentId);
	}

	/**
	* Returns the jira component with the primary key.
	*
	* @param jiraComponentId the primary key of the jira component
	* @return the jira component
	* @throws PortalException if a jira component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent getJiraComponent(
		long jiraComponentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponent(jiraComponentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> getJiraComponents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponents(start, end);
	}

	/**
	* Returns the number of jira components.
	*
	* @return the number of jira components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJiraComponentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponentsCount();
	}

	/**
	* Updates the jira component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraComponent the jira component
	* @return the jira component that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraComponent updateJiraComponent(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.updateJiraComponent(jiraComponent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraComponentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraComponentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraComponentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent addJiraComponent(
		java.lang.String uri, long jiraProjectId, java.lang.String name,
		java.lang.Boolean disabled)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.addJiraComponent(uri, jiraProjectId,
			name, disabled);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent getJiraComponentByNameAndJiraProjectId(
		java.lang.String name, long jiraProjectId)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponentByNameAndJiraProjectId(name,
			jiraProjectId);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent getJiraComponentByUri(
		java.lang.String uri)
		throws com.liferay.jira.metrics.NoSuchJiraComponentException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponentByUri(uri);
	}

	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraComponent> getJiraComponentsByJiraProjectId(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraComponentLocalService.getJiraComponentsByJiraProjectId(jiraProjectId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraComponentLocalService getWrappedJiraComponentLocalService() {
		return _jiraComponentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraComponentLocalService(
		JiraComponentLocalService jiraComponentLocalService) {
		_jiraComponentLocalService = jiraComponentLocalService;
	}

	@Override
	public JiraComponentLocalService getWrappedService() {
		return _jiraComponentLocalService;
	}

	@Override
	public void setWrappedService(
		JiraComponentLocalService jiraComponentLocalService) {
		_jiraComponentLocalService = jiraComponentLocalService;
	}

	private JiraComponentLocalService _jiraComponentLocalService;
}