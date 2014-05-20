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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for JiraDataRetrieve. This utility wraps
 * {@link com.liferay.jira.metrics.service.impl.JiraDataRetrieveLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieveLocalService
 * @see com.liferay.jira.metrics.service.base.JiraDataRetrieveLocalServiceBaseImpl
 * @see com.liferay.jira.metrics.service.impl.JiraDataRetrieveLocalServiceImpl
 * @generated
 */
public class JiraDataRetrieveLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.jira.metrics.service.impl.JiraDataRetrieveLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the jira data retrieve to the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve addJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJiraDataRetrieve(jiraDataRetrieve);
	}

	/**
	* Creates a new jira data retrieve with the primary key. Does not add the jira data retrieve to the database.
	*
	* @param jiraDataRetrieveId the primary key for the new jira data retrieve
	* @return the new jira data retrieve
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve createJiraDataRetrieve(
		long jiraDataRetrieveId) {
		return getService().createJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Deletes the jira data retrieve with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve that was removed
	* @throws PortalException if a jira data retrieve with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve deleteJiraDataRetrieve(
		long jiraDataRetrieveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Deletes the jira data retrieve from the database. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve deleteJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJiraDataRetrieve(jiraDataRetrieve);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.jira.metrics.model.JiraDataRetrieve fetchJiraDataRetrieve(
		long jiraDataRetrieveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJiraDataRetrieve(jiraDataRetrieveId);
	}

	/**
	* Returns the jira data retrieve with the primary key.
	*
	* @param jiraDataRetrieveId the primary key of the jira data retrieve
	* @return the jira data retrieve
	* @throws PortalException if a jira data retrieve with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve getJiraDataRetrieve(
		long jiraDataRetrieveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraDataRetrieve(jiraDataRetrieveId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.jira.metrics.model.JiraDataRetrieve> getJiraDataRetrieves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraDataRetrieves(start, end);
	}

	/**
	* Returns the number of jira data retrieves.
	*
	* @return the number of jira data retrieves
	* @throws SystemException if a system exception occurred
	*/
	public static int getJiraDataRetrievesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJiraDataRetrievesCount();
	}

	/**
	* Updates the jira data retrieve in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jiraDataRetrieve the jira data retrieve
	* @return the jira data retrieve that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.jira.metrics.model.JiraDataRetrieve updateJiraDataRetrieve(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJiraDataRetrieve(jiraDataRetrieve);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.jira.metrics.model.JiraDataRetrieve addJiraDataRetrieve(
		java.lang.String status, java.lang.String statusDescription,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addJiraDataRetrieve(status, statusDescription, date);
	}

	public static void clearService() {
		_service = null;
	}

	public static JiraDataRetrieveLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JiraDataRetrieveLocalService.class.getName());

			if (invokableLocalService instanceof JiraDataRetrieveLocalService) {
				_service = (JiraDataRetrieveLocalService)invokableLocalService;
			}
			else {
				_service = new JiraDataRetrieveLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JiraDataRetrieveLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JiraDataRetrieveLocalService service) {
	}

	private static JiraDataRetrieveLocalService _service;
}