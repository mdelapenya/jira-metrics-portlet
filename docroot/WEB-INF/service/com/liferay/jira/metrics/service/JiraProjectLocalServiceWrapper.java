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
 * Provides a wrapper for {@link JiraProjectLocalService}.
 *
 * @author Manuel de la Peña
 * @see JiraProjectLocalService
 * @generated
 */
public class JiraProjectLocalServiceWrapper implements JiraProjectLocalService,
	ServiceWrapper<JiraProjectLocalService> {
	public JiraProjectLocalServiceWrapper(
		JiraProjectLocalService jiraProjectLocalService) {
		_jiraProjectLocalService = jiraProjectLocalService;
	}

	/**
	* Adds the jira project to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraProject the jira project
	* @return the jira project that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject addJiraProject(
		com.liferay.jira.metrics.model.JiraProject jiraProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.addJiraProject(jiraProject);
	}

	/**
	* Creates a new jira project with the primary key. Does not add the jira project to the database.
	*
	* @param jiraProjectId the primary key for the new jira project
	* @return the new jira project
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject createJiraProject(
		long jiraProjectId) {
		return _jiraProjectLocalService.createJiraProject(jiraProjectId);
	}

	/**
	* Deletes the jira project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project that was removed
	* @throws PortalException if a jira project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject deleteJiraProject(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.deleteJiraProject(jiraProjectId);
	}

	/**
	* Deletes the jira project from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraProject the jira project
	* @return the jira project that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject deleteJiraProject(
		com.liferay.jira.metrics.model.JiraProject jiraProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.deleteJiraProject(jiraProject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jiraProjectLocalService.dynamicQuery();
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
		return _jiraProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraProjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _jiraProjectLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _jiraProjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _jiraProjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.jira.metrics.model.JiraProject fetchJiraProject(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.fetchJiraProject(jiraProjectId);
	}

	/**
	* Returns the jira project with the primary key.
	*
	* @param jiraProjectId the primary key of the jira project
	* @return the jira project
	* @throws PortalException if a jira project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject getJiraProject(
		long jiraProjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProject(jiraProjectId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraProject> getJiraProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProjects(start, end);
	}

	/**
	* Returns the number of jira projects.
	*
	* @return the number of jira projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getJiraProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProjectsCount();
	}

	/**
	* Updates the jira project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraProject the jira project
	* @return the jira project that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject updateJiraProject(
		com.liferay.jira.metrics.model.JiraProject jiraProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.updateJiraProject(jiraProject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jiraProjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jiraProjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jiraProjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Gets a Jira Project by name
	*
	* @param projectCode
	* @return
	* @throws NoSuchJiraProjectException
	* @throws SystemException
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject getJiraProjectByName(
		java.lang.String name)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProjectByName(name);
	}

	/**
	* Gets a Jira Project by projectCode
	*
	* @param projectCode
	* @return
	* @throws NoSuchJiraProjectException
	* @throws SystemException
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject getJiraProjectByProjectCode(
		long projectCode)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProjectByProjectCode(projectCode);
	}

	/**
	* Gets a Jira Project by label
	*
	* @param label
	* @return the Jira project
	* @throws NoSuchJiraProjectException
	* @throws SystemException
	*/
	@Override
	public com.liferay.jira.metrics.model.JiraProject getJiraProjectByProjectLabel(
		java.lang.String label)
		throws com.liferay.jira.metrics.NoSuchJiraProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getJiraProjectByProjectLabel(label);
	}

	/**
	* Retrieves all Jira projects
	*
	* @return a list with all Jira projects
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.liferay.jira.metrics.model.JiraProject> getAllJiraProjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProjectLocalService.getAllJiraProjects();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JiraProjectLocalService getWrappedJiraProjectLocalService() {
		return _jiraProjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJiraProjectLocalService(
		JiraProjectLocalService jiraProjectLocalService) {
		_jiraProjectLocalService = jiraProjectLocalService;
	}

	@Override
	public JiraProjectLocalService getWrappedService() {
		return _jiraProjectLocalService;
	}

	@Override
	public void setWrappedService(
		JiraProjectLocalService jiraProjectLocalService) {
		_jiraProjectLocalService = jiraProjectLocalService;
	}

	private JiraProjectLocalService _jiraProjectLocalService;
}