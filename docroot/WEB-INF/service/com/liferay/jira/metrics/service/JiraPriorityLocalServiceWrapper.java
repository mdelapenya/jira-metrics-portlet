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
 * Provides a wrapper for {@link JiraPriorityLocalService}.
 *
 * @author Manuel de la Peña
 * @see JiraPriorityLocalService
 * @generated
 */
public class JiraPriorityLocalServiceWrapper implements JiraPriorityLocalService,
	ServiceWrapper<JiraPriorityLocalService> {
	public JiraPriorityLocalServiceWrapper(
		JiraPriorityLocalService jiraPriorityLocalService) {
		_jiraPriorityLocalService = jiraPriorityLocalService;
	}

	/**
	* Adds the jira priority to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraPriority the jira priority
	* @return the jira priority that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority addJiraPriority(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.addJiraPriority(jiraPriority);
	}

	/**
	* Creates a new jira priority with the primary key. Does not add the jira priority to the database.
	*
	* @param jiraPriorityId the primary key for the new jira priority
	* @return the new jira priority
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority createJiraPriority(
		long jiraPriorityId) {
		return _jiraPriorityLocalService.createJiraPriority(jiraPriorityId);
	}

	/**
	* Deletes the jira priority with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraPriorityId the primary key of the jira priority
	* @return the jira priority that was removed
	* @throws PortalException if a jira priority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority deleteJiraPriority(
		long jiraPriorityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.deleteJiraPriority(jiraPriorityId);
	}

	/**
	* Deletes the jira priority from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraPriority the jira priority
	* @return the jira priority that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority deleteJiraPriority(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.deleteJiraPriority(jiraPriority);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraPriorityLocalService.dynamicQuery();
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
		return _jiraPriorityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraPriorityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraPriorityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraPriorityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _jiraPriorityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _jiraPriorityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority fetchJiraPriority(
		long jiraPriorityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.fetchJiraPriority(jiraPriorityId);
	}

	/**
	* Returns the jira priority with the primary key.
	*
	* @param jiraPriorityId the primary key of the jira priority
	* @return the jira priority
	* @throws PortalException if a jira priority with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority getJiraPriority(
		long jiraPriorityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getJiraPriority(jiraPriorityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraPriority> getJiraPriorities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getJiraPriorities(start, end);
	}

	/**
	* Returns the number of jira priorities.
	*
	* @return the number of jira priorities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJiraPrioritiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getJiraPrioritiesCount();
	}

	/**
	* Updates the jira priority in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraPriority the jira priority
	* @return the jira priority that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraPriority updateJiraPriority(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.updateJiraPriority(jiraPriority);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraPriorityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraPriorityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraPriorityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority addJiraProject(
		java.lang.String value, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.addJiraProject(value, name);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority getJiraPriorityByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getJiraPriorityByName(name);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority getJiraPriorityByValue(
		java.lang.String value)
		throws com.liferay.jira.metrics.NoSuchJiraPriorityException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraPriorityLocalService.getJiraPriorityByValue(value);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraPriorityLocalService getWrappedJiraPriorityLocalService() {
		return _jiraPriorityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraPriorityLocalService(
		JiraPriorityLocalService jiraPriorityLocalService) {
		_jiraPriorityLocalService = jiraPriorityLocalService;
	}

	@Override
	public JiraPriorityLocalService getWrappedService() {
		return _jiraPriorityLocalService;
	}

	@Override
	public void setWrappedService(
		JiraPriorityLocalService jiraPriorityLocalService) {
		_jiraPriorityLocalService = jiraPriorityLocalService;
	}

	private JiraPriorityLocalService _jiraPriorityLocalService;
}