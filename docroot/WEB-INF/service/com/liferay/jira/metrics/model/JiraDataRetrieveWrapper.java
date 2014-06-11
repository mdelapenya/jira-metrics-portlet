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
 * This class is a wrapper for {@link JiraDataRetrieve}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieve
 * @generated
 */
public class JiraDataRetrieveWrapper implements JiraDataRetrieve,
	ModelWrapper<JiraDataRetrieve> {
	public JiraDataRetrieveWrapper(JiraDataRetrieve jiraDataRetrieve) {
		_jiraDataRetrieve = jiraDataRetrieve;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraDataRetrieve.class;
	}

	@Override
	public String getModelClassName() {
		return JiraDataRetrieve.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraDataRetrieveId", getJiraDataRetrieveId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusDescription", getStatusDescription());
		attributes.put("day", getDay());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraDataRetrieveId = (Long)attributes.get("jiraDataRetrieveId");

		if (jiraDataRetrieveId != null) {
			setJiraDataRetrieveId(jiraDataRetrieveId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusDescription = (String)attributes.get("statusDescription");

		if (statusDescription != null) {
			setStatusDescription(statusDescription);
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
	}

	/**
	* Returns the primary key of this jira data retrieve.
	*
	* @return the primary key of this jira data retrieve
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraDataRetrieve.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira data retrieve.
	*
	* @param primaryKey the primary key of this jira data retrieve
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraDataRetrieve.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira data retrieve ID of this jira data retrieve.
	*
	* @return the jira data retrieve ID of this jira data retrieve
	*/
	@Override
	public long getJiraDataRetrieveId() {
		return _jiraDataRetrieve.getJiraDataRetrieveId();
	}

	/**
	* Sets the jira data retrieve ID of this jira data retrieve.
	*
	* @param jiraDataRetrieveId the jira data retrieve ID of this jira data retrieve
	*/
	@Override
	public void setJiraDataRetrieveId(long jiraDataRetrieveId) {
		_jiraDataRetrieve.setJiraDataRetrieveId(jiraDataRetrieveId);
	}

	/**
	* Returns the create date of this jira data retrieve.
	*
	* @return the create date of this jira data retrieve
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraDataRetrieve.getCreateDate();
	}

	/**
	* Sets the create date of this jira data retrieve.
	*
	* @param createDate the create date of this jira data retrieve
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraDataRetrieve.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira data retrieve.
	*
	* @return the modified date of this jira data retrieve
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraDataRetrieve.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira data retrieve.
	*
	* @param modifiedDate the modified date of this jira data retrieve
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraDataRetrieve.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this jira data retrieve.
	*
	* @return the status of this jira data retrieve
	*/
	@Override
	public java.lang.String getStatus() {
		return _jiraDataRetrieve.getStatus();
	}

	/**
	* Sets the status of this jira data retrieve.
	*
	* @param status the status of this jira data retrieve
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_jiraDataRetrieve.setStatus(status);
	}

	/**
	* Returns the status description of this jira data retrieve.
	*
	* @return the status description of this jira data retrieve
	*/
	@Override
	public java.lang.String getStatusDescription() {
		return _jiraDataRetrieve.getStatusDescription();
	}

	/**
	* Sets the status description of this jira data retrieve.
	*
	* @param statusDescription the status description of this jira data retrieve
	*/
	@Override
	public void setStatusDescription(java.lang.String statusDescription) {
		_jiraDataRetrieve.setStatusDescription(statusDescription);
	}

	/**
	* Returns the day of this jira data retrieve.
	*
	* @return the day of this jira data retrieve
	*/
	@Override
	public int getDay() {
		return _jiraDataRetrieve.getDay();
	}

	/**
	* Sets the day of this jira data retrieve.
	*
	* @param day the day of this jira data retrieve
	*/
	@Override
	public void setDay(int day) {
		_jiraDataRetrieve.setDay(day);
	}

	/**
	* Returns the month of this jira data retrieve.
	*
	* @return the month of this jira data retrieve
	*/
	@Override
	public int getMonth() {
		return _jiraDataRetrieve.getMonth();
	}

	/**
	* Sets the month of this jira data retrieve.
	*
	* @param month the month of this jira data retrieve
	*/
	@Override
	public void setMonth(int month) {
		_jiraDataRetrieve.setMonth(month);
	}

	/**
	* Returns the year of this jira data retrieve.
	*
	* @return the year of this jira data retrieve
	*/
	@Override
	public int getYear() {
		return _jiraDataRetrieve.getYear();
	}

	/**
	* Sets the year of this jira data retrieve.
	*
	* @param year the year of this jira data retrieve
	*/
	@Override
	public void setYear(int year) {
		_jiraDataRetrieve.setYear(year);
	}

	@Override
	public boolean isNew() {
		return _jiraDataRetrieve.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraDataRetrieve.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraDataRetrieve.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraDataRetrieve.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraDataRetrieve.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraDataRetrieve.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraDataRetrieve.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraDataRetrieve.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraDataRetrieve.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraDataRetrieve.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraDataRetrieve.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraDataRetrieveWrapper((JiraDataRetrieve)_jiraDataRetrieve.clone());
	}

	@Override
	public int compareTo(
		com.liferay.jira.metrics.model.JiraDataRetrieve jiraDataRetrieve) {
		return _jiraDataRetrieve.compareTo(jiraDataRetrieve);
	}

	@Override
	public int hashCode() {
		return _jiraDataRetrieve.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraDataRetrieve> toCacheModel() {
		return _jiraDataRetrieve.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve toEscapedModel() {
		return new JiraDataRetrieveWrapper(_jiraDataRetrieve.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraDataRetrieve toUnescapedModel() {
		return new JiraDataRetrieveWrapper(_jiraDataRetrieve.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraDataRetrieve.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraDataRetrieve.toXmlString();
	}

	@Override
	public void persist() {
		_jiraDataRetrieve.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraDataRetrieveWrapper)) {
			return false;
		}

		JiraDataRetrieveWrapper jiraDataRetrieveWrapper = (JiraDataRetrieveWrapper)obj;

		if (Validator.equals(_jiraDataRetrieve,
					jiraDataRetrieveWrapper._jiraDataRetrieve)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public JiraDataRetrieve getWrappedJiraDataRetrieve() {
		return _jiraDataRetrieve;
	}

	@Override
	public JiraDataRetrieve getWrappedModel() {
		return _jiraDataRetrieve;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _jiraDataRetrieve.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _jiraDataRetrieve.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_jiraDataRetrieve.resetOriginalValues();
	}

	private JiraDataRetrieve _jiraDataRetrieve;
}