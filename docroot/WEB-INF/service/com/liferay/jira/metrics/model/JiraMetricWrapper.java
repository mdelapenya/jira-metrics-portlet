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

package com.liferay.jira.metrics.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JiraMetric}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraMetric
 * @generated
 */
public class JiraMetricWrapper implements JiraMetric, ModelWrapper<JiraMetric> {
	public JiraMetricWrapper(JiraMetric jiraMetric) {
		_jiraMetric = jiraMetric;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraMetric.class;
	}

	@Override
	public String getModelClassName() {
		return JiraMetric.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraMetricId", getJiraMetricId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("jiraComponentId", getJiraComponentId());
		attributes.put("jiraStatusId", getJiraStatusId());
		attributes.put("priority", getPriority());
		attributes.put("day", getDay());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());
		attributes.put("total", getTotal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraMetricId = (Long)attributes.get("jiraMetricId");

		if (jiraMetricId != null) {
			setJiraMetricId(jiraMetricId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		Long jiraComponentId = (Long)attributes.get("jiraComponentId");

		if (jiraComponentId != null) {
			setJiraComponentId(jiraComponentId);
		}

		Long jiraStatusId = (Long)attributes.get("jiraStatusId");

		if (jiraStatusId != null) {
			setJiraStatusId(jiraStatusId);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer total = (Integer)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}
	}

	/**
	* Returns the primary key of this jira metric.
	*
	* @return the primary key of this jira metric
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraMetric.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira metric.
	*
	* @param primaryKey the primary key of this jira metric
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraMetric.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira metric ID of this jira metric.
	*
	* @return the jira metric ID of this jira metric
	*/
	@Override
	public long getJiraMetricId() {
		return _jiraMetric.getJiraMetricId();
	}

	/**
	* Sets the jira metric ID of this jira metric.
	*
	* @param jiraMetricId the jira metric ID of this jira metric
	*/
	@Override
	public void setJiraMetricId(long jiraMetricId) {
		_jiraMetric.setJiraMetricId(jiraMetricId);
	}

	/**
	* Returns the user ID of this jira metric.
	*
	* @return the user ID of this jira metric
	*/
	@Override
	public long getUserId() {
		return _jiraMetric.getUserId();
	}

	/**
	* Sets the user ID of this jira metric.
	*
	* @param userId the user ID of this jira metric
	*/
	@Override
	public void setUserId(long userId) {
		_jiraMetric.setUserId(userId);
	}

	/**
	* Returns the user uuid of this jira metric.
	*
	* @return the user uuid of this jira metric
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraMetric.getUserUuid();
	}

	/**
	* Sets the user uuid of this jira metric.
	*
	* @param userUuid the user uuid of this jira metric
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jiraMetric.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this jira metric.
	*
	* @return the user name of this jira metric
	*/
	@Override
	public java.lang.String getUserName() {
		return _jiraMetric.getUserName();
	}

	/**
	* Sets the user name of this jira metric.
	*
	* @param userName the user name of this jira metric
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_jiraMetric.setUserName(userName);
	}

	/**
	* Returns the create date of this jira metric.
	*
	* @return the create date of this jira metric
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraMetric.getCreateDate();
	}

	/**
	* Sets the create date of this jira metric.
	*
	* @param createDate the create date of this jira metric
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraMetric.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira metric.
	*
	* @return the modified date of this jira metric
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraMetric.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira metric.
	*
	* @param modifiedDate the modified date of this jira metric
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraMetric.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the jira project ID of this jira metric.
	*
	* @return the jira project ID of this jira metric
	*/
	@Override
	public long getJiraProjectId() {
		return _jiraMetric.getJiraProjectId();
	}

	/**
	* Sets the jira project ID of this jira metric.
	*
	* @param jiraProjectId the jira project ID of this jira metric
	*/
	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_jiraMetric.setJiraProjectId(jiraProjectId);
	}

	/**
	* Returns the jira component ID of this jira metric.
	*
	* @return the jira component ID of this jira metric
	*/
	@Override
	public long getJiraComponentId() {
		return _jiraMetric.getJiraComponentId();
	}

	/**
	* Sets the jira component ID of this jira metric.
	*
	* @param jiraComponentId the jira component ID of this jira metric
	*/
	@Override
	public void setJiraComponentId(long jiraComponentId) {
		_jiraMetric.setJiraComponentId(jiraComponentId);
	}

	/**
	* Returns the jira status ID of this jira metric.
	*
	* @return the jira status ID of this jira metric
	*/
	@Override
	public long getJiraStatusId() {
		return _jiraMetric.getJiraStatusId();
	}

	/**
	* Sets the jira status ID of this jira metric.
	*
	* @param jiraStatusId the jira status ID of this jira metric
	*/
	@Override
	public void setJiraStatusId(long jiraStatusId) {
		_jiraMetric.setJiraStatusId(jiraStatusId);
	}

	/**
	* Returns the priority of this jira metric.
	*
	* @return the priority of this jira metric
	*/
	@Override
	public int getPriority() {
		return _jiraMetric.getPriority();
	}

	/**
	* Sets the priority of this jira metric.
	*
	* @param priority the priority of this jira metric
	*/
	@Override
	public void setPriority(int priority) {
		_jiraMetric.setPriority(priority);
	}

	/**
	* Returns the day of this jira metric.
	*
	* @return the day of this jira metric
	*/
	@Override
	public int getDay() {
		return _jiraMetric.getDay();
	}

	/**
	* Sets the day of this jira metric.
	*
	* @param day the day of this jira metric
	*/
	@Override
	public void setDay(int day) {
		_jiraMetric.setDay(day);
	}

	/**
	* Returns the month of this jira metric.
	*
	* @return the month of this jira metric
	*/
	@Override
	public int getMonth() {
		return _jiraMetric.getMonth();
	}

	/**
	* Sets the month of this jira metric.
	*
	* @param month the month of this jira metric
	*/
	@Override
	public void setMonth(int month) {
		_jiraMetric.setMonth(month);
	}

	/**
	* Returns the year of this jira metric.
	*
	* @return the year of this jira metric
	*/
	@Override
	public int getYear() {
		return _jiraMetric.getYear();
	}

	/**
	* Sets the year of this jira metric.
	*
	* @param year the year of this jira metric
	*/
	@Override
	public void setYear(int year) {
		_jiraMetric.setYear(year);
	}

	/**
	* Returns the total of this jira metric.
	*
	* @return the total of this jira metric
	*/
	@Override
	public int getTotal() {
		return _jiraMetric.getTotal();
	}

	/**
	* Sets the total of this jira metric.
	*
	* @param total the total of this jira metric
	*/
	@Override
	public void setTotal(int total) {
		_jiraMetric.setTotal(total);
	}

	@Override
	public boolean isNew() {
		return _jiraMetric.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraMetric.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraMetric.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraMetric.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraMetric.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraMetric.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraMetric.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraMetric.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraMetric.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraMetric.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraMetric.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraMetricWrapper((JiraMetric)_jiraMetric.clone());
	}

	@Override
	public int compareTo(com.liferay.jira.metrics.model.JiraMetric jiraMetric) {
		return _jiraMetric.compareTo(jiraMetric);
	}

	@Override
	public int hashCode() {
		return _jiraMetric.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraMetric> toCacheModel() {
		return _jiraMetric.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraMetric toEscapedModel() {
		return new JiraMetricWrapper(_jiraMetric.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraMetric toUnescapedModel() {
		return new JiraMetricWrapper(_jiraMetric.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraMetric.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraMetric.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jiraMetric.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraMetricWrapper)) {
			return false;
		}

		JiraMetricWrapper jiraMetricWrapper = (JiraMetricWrapper)obj;

		if (Validator.equals(_jiraMetric, jiraMetricWrapper._jiraMetric)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JiraMetric getWrappedJiraMetric() {
		return _jiraMetric;
	}

	@Override
	public JiraMetric getWrappedModel() {
		return _jiraMetric;
	}

	@Override
	public void resetOriginalValues() {
		_jiraMetric.resetOriginalValues();
	}

	private JiraMetric _jiraMetric;
}