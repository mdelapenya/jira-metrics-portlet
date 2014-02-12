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
 * This class is a wrapper for {@link JiraProject}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraProject
 * @generated
 */
public class JiraProjectWrapper implements JiraProject,
	ModelWrapper<JiraProject> {
	public JiraProjectWrapper(JiraProject jiraProject) {
		_jiraProject = jiraProject;
	}

	@Override
	public Class<?> getModelClass() {
		return JiraProject.class;
	}

	@Override
	public String getModelClassName() {
		return JiraProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("jiraProjectCode", getJiraProjectCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Long jiraProjectCode = (Long)attributes.get("jiraProjectCode");

		if (jiraProjectCode != null) {
			setJiraProjectCode(jiraProjectCode);
		}
	}

	/**
	* Returns the primary key of this jira project.
	*
	* @return the primary key of this jira project
	*/
	@Override
	public long getPrimaryKey() {
		return _jiraProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jira project.
	*
	* @param primaryKey the primary key of this jira project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jiraProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jira project ID of this jira project.
	*
	* @return the jira project ID of this jira project
	*/
	@Override
	public long getJiraProjectId() {
		return _jiraProject.getJiraProjectId();
	}

	/**
	* Sets the jira project ID of this jira project.
	*
	* @param jiraProjectId the jira project ID of this jira project
	*/
	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_jiraProject.setJiraProjectId(jiraProjectId);
	}

	/**
	* Returns the user ID of this jira project.
	*
	* @return the user ID of this jira project
	*/
	@Override
	public long getUserId() {
		return _jiraProject.getUserId();
	}

	/**
	* Sets the user ID of this jira project.
	*
	* @param userId the user ID of this jira project
	*/
	@Override
	public void setUserId(long userId) {
		_jiraProject.setUserId(userId);
	}

	/**
	* Returns the user uuid of this jira project.
	*
	* @return the user uuid of this jira project
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jiraProject.getUserUuid();
	}

	/**
	* Sets the user uuid of this jira project.
	*
	* @param userUuid the user uuid of this jira project
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jiraProject.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this jira project.
	*
	* @return the user name of this jira project
	*/
	@Override
	public java.lang.String getUserName() {
		return _jiraProject.getUserName();
	}

	/**
	* Sets the user name of this jira project.
	*
	* @param userName the user name of this jira project
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_jiraProject.setUserName(userName);
	}

	/**
	* Returns the create date of this jira project.
	*
	* @return the create date of this jira project
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jiraProject.getCreateDate();
	}

	/**
	* Sets the create date of this jira project.
	*
	* @param createDate the create date of this jira project
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jiraProject.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jira project.
	*
	* @return the modified date of this jira project
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jiraProject.getModifiedDate();
	}

	/**
	* Sets the modified date of this jira project.
	*
	* @param modifiedDate the modified date of this jira project
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jiraProject.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this jira project.
	*
	* @return the name of this jira project
	*/
	@Override
	public java.lang.String getName() {
		return _jiraProject.getName();
	}

	/**
	* Sets the name of this jira project.
	*
	* @param name the name of this jira project
	*/
	@Override
	public void setName(java.lang.String name) {
		_jiraProject.setName(name);
	}

	/**
	* Returns the label of this jira project.
	*
	* @return the label of this jira project
	*/
	@Override
	public java.lang.String getLabel() {
		return _jiraProject.getLabel();
	}

	/**
	* Sets the label of this jira project.
	*
	* @param label the label of this jira project
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_jiraProject.setLabel(label);
	}

	/**
	* Returns the jira project code of this jira project.
	*
	* @return the jira project code of this jira project
	*/
	@Override
	public long getJiraProjectCode() {
		return _jiraProject.getJiraProjectCode();
	}

	/**
	* Sets the jira project code of this jira project.
	*
	* @param jiraProjectCode the jira project code of this jira project
	*/
	@Override
	public void setJiraProjectCode(long jiraProjectCode) {
		_jiraProject.setJiraProjectCode(jiraProjectCode);
	}

	@Override
	public boolean isNew() {
		return _jiraProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jiraProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jiraProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jiraProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jiraProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jiraProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jiraProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jiraProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jiraProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jiraProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jiraProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JiraProjectWrapper((JiraProject)_jiraProject.clone());
	}

	@Override
	public int compareTo(com.liferay.jira.metrics.model.JiraProject jiraProject) {
		return _jiraProject.compareTo(jiraProject);
	}

	@Override
	public int hashCode() {
		return _jiraProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.jira.metrics.model.JiraProject> toCacheModel() {
		return _jiraProject.toCacheModel();
	}

	@Override
	public com.liferay.jira.metrics.model.JiraProject toEscapedModel() {
		return new JiraProjectWrapper(_jiraProject.toEscapedModel());
	}

	@Override
	public com.liferay.jira.metrics.model.JiraProject toUnescapedModel() {
		return new JiraProjectWrapper(_jiraProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jiraProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jiraProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jiraProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraProjectWrapper)) {
			return false;
		}

		JiraProjectWrapper jiraProjectWrapper = (JiraProjectWrapper)obj;

		if (Validator.equals(_jiraProject, jiraProjectWrapper._jiraProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JiraProject getWrappedJiraProject() {
		return _jiraProject;
	}

	@Override
	public JiraProject getWrappedModel() {
		return _jiraProject;
	}

	@Override
	public void resetOriginalValues() {
		_jiraProject.resetOriginalValues();
	}

	private JiraProject _jiraProject;
}