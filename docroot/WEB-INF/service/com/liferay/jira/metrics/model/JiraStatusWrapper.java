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
 * This class is a wrapper for {@link JiraStatus}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraStatus
 * @generated
 */
public class JiraStatusWrapper implements JiraStatus, ModelWrapper<JiraStatus> {
	public JiraStatusWrapper(JiraStatus jiraStatus) {
		_jiraStatus = jiraStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraStatus.class;
	}

	@Override
	public String getModelClassName() {
		return JiraStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraStatusId", getJiraStatusId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uri", getUri());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraStatusId = (Long)attributes.get("jiraStatusId");

		if (jiraStatusId != null) {
			setJiraStatusId(jiraStatusId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String uri = (String)attributes.get("uri");

		if (uri != null) {
			setUri(uri);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this jira status.
	*
	* @return the primary key of this jira status
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira status.
	*
	* @param primaryKey the primary key of this jira status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira status ID of this jira status.
	*
	* @return the jira status ID of this jira status
	*/
	@Override
	public long getJiraStatusId() {
		return _jiraStatus.getJiraStatusId();
	}

	/**
	* Sets the jira status ID of this jira status.
	*
	* @param jiraStatusId the jira status ID of this jira status
	*/
	@Override
	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatus.setJiraStatusId(jiraStatusId);
	}

	/**
	* Returns the create date of this jira status.
	*
	* @return the create date of this jira status
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraStatus.getCreateDate();
	}

	/**
	* Sets the create date of this jira status.
	*
	* @param createDate the create date of this jira status
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraStatus.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira status.
	*
	* @return the modified date of this jira status
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraStatus.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira status.
	*
	* @param modifiedDate the modified date of this jira status
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraStatus.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uri of this jira status.
	*
	* @return the uri of this jira status
	*/
	@Override
	public java.lang.String getUri() {
		return _jiraStatus.getUri();
	}

	/**
	* Sets the uri of this jira status.
	*
	* @param uri the uri of this jira status
	*/
	@Override
	public void setUri(java.lang.String uri) {
		_jiraStatus.setUri(uri);
	}

	/**
	* Returns the name of this jira status.
	*
	* @return the name of this jira status
	*/
	@Override
	public java.lang.String getName() {
		return _jiraStatus.getName();
	}

	/**
	* Sets the name of this jira status.
	*
	* @param name the name of this jira status
	*/
	@Override
	public void setName(java.lang.String name) {
		_jiraStatus.setName(name);
	}

	@Override
	public boolean isNew() {
		return _jiraStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraStatusWrapper((JiraStatus)_jiraStatus.clone());
	}

	@Override
	public int compareTo(com.liferay.jira.metrics.model.JiraStatus jiraStatus) {
		return _jiraStatus.compareTo(jiraStatus);
	}

	@Override
	public int hashCode() {
		return _jiraStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraStatus> toCacheModel() {
		return _jiraStatus.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus toEscapedModel() {
		return new JiraStatusWrapper(_jiraStatus.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraStatus toUnescapedModel() {
		return new JiraStatusWrapper(_jiraStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraStatus.toXmlString();
	}

	@Override
	public void persist() {
		_jiraStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraStatusWrapper)) {
			return false;
		}

		JiraStatusWrapper jiraStatusWrapper = (JiraStatusWrapper)obj;

		if (Validator.equals(_jiraStatus, jiraStatusWrapper._jiraStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public JiraStatus getWrappedJiraStatus() {
		return _jiraStatus;
	}

	@Override
	public JiraStatus getWrappedModel() {
		return _jiraStatus;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _jiraStatus.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _jiraStatus.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_jiraStatus.resetOriginalValues();
	}

	private JiraStatus _jiraStatus;
}