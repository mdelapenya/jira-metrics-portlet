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
 * This class is a wrapper for {@link JiraPriority}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraPriority
 * @generated
 */
public class JiraPriorityWrapper implements JiraPriority,
	ModelWrapper<JiraPriority> {
	public JiraPriorityWrapper(JiraPriority jiraPriority) {
		_jiraPriority = jiraPriority;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraPriority.class;
	}

	@Override
	public String getModelClassName() {
		return JiraPriority.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraPriorityId", getJiraPriorityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("value", getValue());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraPriorityId = (Long)attributes.get("jiraPriorityId");

		if (jiraPriorityId != null) {
			setJiraPriorityId(jiraPriorityId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this jira priority.
	*
	* @return the primary key of this jira priority
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraPriority.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira priority.
	*
	* @param primaryKey the primary key of this jira priority
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraPriority.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira priority ID of this jira priority.
	*
	* @return the jira priority ID of this jira priority
	*/
	@Override
	public long getJiraPriorityId() {
		return _jiraPriority.getJiraPriorityId();
	}

	/**
	* Sets the jira priority ID of this jira priority.
	*
	* @param jiraPriorityId the jira priority ID of this jira priority
	*/
	@Override
	public void setJiraPriorityId(long jiraPriorityId) {
		_jiraPriority.setJiraPriorityId(jiraPriorityId);
	}

	/**
	* Returns the create date of this jira priority.
	*
	* @return the create date of this jira priority
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraPriority.getCreateDate();
	}

	/**
	* Sets the create date of this jira priority.
	*
	* @param createDate the create date of this jira priority
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraPriority.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira priority.
	*
	* @return the modified date of this jira priority
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraPriority.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira priority.
	*
	* @param modifiedDate the modified date of this jira priority
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraPriority.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the value of this jira priority.
	*
	* @return the value of this jira priority
	*/
	@Override
	public java.lang.String getValue() {
		return _jiraPriority.getValue();
	}

	/**
	* Sets the value of this jira priority.
	*
	* @param value the value of this jira priority
	*/
	@Override
	public void setValue(java.lang.String value) {
		_jiraPriority.setValue(value);
	}

	/**
	* Returns the name of this jira priority.
	*
	* @return the name of this jira priority
	*/
	@Override
	public java.lang.String getName() {
		return _jiraPriority.getName();
	}

	/**
	* Sets the name of this jira priority.
	*
	* @param name the name of this jira priority
	*/
	@Override
	public void setName(java.lang.String name) {
		_jiraPriority.setName(name);
	}

	@Override
	public boolean isNew() {
		return _jiraPriority.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraPriority.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraPriority.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraPriority.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraPriority.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraPriority.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraPriority.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraPriority.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraPriority.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraPriority.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraPriority.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraPriorityWrapper((JiraPriority)_jiraPriority.clone());
	}

	@Override
	public int compareTo(
		com.liferay.jira.metrics.model.JiraPriority jiraPriority) {
		return _jiraPriority.compareTo(jiraPriority);
	}

	@Override
	public int hashCode() {
		return _jiraPriority.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraPriority> toCacheModel() {
		return _jiraPriority.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority toEscapedModel() {
		return new JiraPriorityWrapper(_jiraPriority.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraPriority toUnescapedModel() {
		return new JiraPriorityWrapper(_jiraPriority.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraPriority.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraPriority.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jiraPriority.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraPriorityWrapper)) {
			return false;
		}

		JiraPriorityWrapper jiraPriorityWrapper = (JiraPriorityWrapper)obj;

		if (Validator.equals(_jiraPriority, jiraPriorityWrapper._jiraPriority)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JiraPriority getWrappedJiraPriority() {
		return _jiraPriority;
	}

	@Override
	public JiraPriority getWrappedModel() {
		return _jiraPriority;
	}

	@Override
	public void resetOriginalValues() {
		_jiraPriority.resetOriginalValues();
	}

	private JiraPriority _jiraPriority;
}