/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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
 * This class is a wrapper for {@link JiraComponent}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraComponent
 * @generated
 */
public class JiraComponentWrapper implements JiraComponent,
	ModelWrapper<JiraComponent> {
	public JiraComponentWrapper(JiraComponent jiraComponent) {
		_jiraComponent = jiraComponent;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraComponent.class;
	}

	@Override
	public String getModelClassName() {
		return JiraComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraComponentId", getJiraComponentId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uri", getUri());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("name", getName());
		attributes.put("disabled", getDisabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraComponentId = (Long)attributes.get("jiraComponentId");

		if (jiraComponentId != null) {
			setJiraComponentId(jiraComponentId);
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

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean disabled = (Boolean)attributes.get("disabled");

		if (disabled != null) {
			setDisabled(disabled);
		}
	}

	/**
	* Returns the primary key of this jira component.
	*
	* @return the primary key of this jira component
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraComponent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira component.
	*
	* @param primaryKey the primary key of this jira component
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraComponent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira component ID of this jira component.
	*
	* @return the jira component ID of this jira component
	*/
	@Override
	public long getJiraComponentId() {
		return _jiraComponent.getJiraComponentId();
	}

	/**
	* Sets the jira component ID of this jira component.
	*
	* @param jiraComponentId the jira component ID of this jira component
	*/
	@Override
	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponent.setJiraComponentId(jiraComponentId);
	}

	/**
	* Returns the create date of this jira component.
	*
	* @return the create date of this jira component
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraComponent.getCreateDate();
	}

	/**
	* Sets the create date of this jira component.
	*
	* @param createDate the create date of this jira component
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraComponent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira component.
	*
	* @return the modified date of this jira component
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraComponent.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira component.
	*
	* @param modifiedDate the modified date of this jira component
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraComponent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uri of this jira component.
	*
	* @return the uri of this jira component
	*/
	@Override
	public java.lang.String getUri() {
		return _jiraComponent.getUri();
	}

	/**
	* Sets the uri of this jira component.
	*
	* @param uri the uri of this jira component
	*/
	@Override
	public void setUri(java.lang.String uri) {
		_jiraComponent.setUri(uri);
	}

	/**
	* Returns the jira project ID of this jira component.
	*
	* @return the jira project ID of this jira component
	*/
	@Override
	public long getJiraProjectId() {
		return _jiraComponent.getJiraProjectId();
	}

	/**
	* Sets the jira project ID of this jira component.
	*
	* @param jiraProjectId the jira project ID of this jira component
	*/
	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_jiraComponent.setJiraProjectId(jiraProjectId);
	}

	/**
	* Returns the name of this jira component.
	*
	* @return the name of this jira component
	*/
	@Override
	public java.lang.String getName() {
		return _jiraComponent.getName();
	}

	/**
	* Sets the name of this jira component.
	*
	* @param name the name of this jira component
	*/
	@Override
	public void setName(java.lang.String name) {
		_jiraComponent.setName(name);
	}

	/**
	* Returns the disabled of this jira component.
	*
	* @return the disabled of this jira component
	*/
	@Override
	public boolean getDisabled() {
		return _jiraComponent.getDisabled();
	}

	/**
	* Returns <code>true</code> if this jira component is disabled.
	*
	* @return <code>true</code> if this jira component is disabled; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisabled() {
		return _jiraComponent.isDisabled();
	}

	/**
	* Sets whether this jira component is disabled.
	*
	* @param disabled the disabled of this jira component
	*/
	@Override
	public void setDisabled(boolean disabled) {
		_jiraComponent.setDisabled(disabled);
	}

	@Override
	public boolean isNew() {
		return _jiraComponent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraComponent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraComponent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraComponent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraComponent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraComponent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraComponent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraComponent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraComponent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraComponent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraComponent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraComponentWrapper((JiraComponent)_jiraComponent.clone());
	}

	@Override
	public int compareTo(
		com.liferay.jira.metrics.model.JiraComponent jiraComponent) {
		return _jiraComponent.compareTo(jiraComponent);
	}

	@Override
	public int hashCode() {
		return _jiraComponent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraComponent> toCacheModel() {
		return _jiraComponent.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent toEscapedModel() {
		return new JiraComponentWrapper(_jiraComponent.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraComponent toUnescapedModel() {
		return new JiraComponentWrapper(_jiraComponent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraComponent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraComponent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jiraComponent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraComponentWrapper)) {
			return false;
		}

		JiraComponentWrapper jiraComponentWrapper = (JiraComponentWrapper)obj;

		if (Validator.equals(_jiraComponent, jiraComponentWrapper._jiraComponent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JiraComponent getWrappedJiraComponent() {
		return _jiraComponent;
	}

	@Override
	public JiraComponent getWrappedModel() {
		return _jiraComponent;
	}

	@Override
	public void resetOriginalValues() {
		_jiraComponent.resetOriginalValues();
	}

	private JiraComponent _jiraComponent;
}