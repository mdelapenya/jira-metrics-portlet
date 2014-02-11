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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraProjectServiceSoap}.
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.http.JiraProjectServiceSoap
 * @generated
 */
public class JiraProjectSoap implements Serializable {
	public static JiraProjectSoap toSoapModel(JiraProject model) {
		JiraProjectSoap soapModel = new JiraProjectSoap();

		soapModel.setJiraProjectId(model.getJiraProjectId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setLabel(model.getLabel());
		soapModel.setJiraProjectCode(model.getJiraProjectCode());

		return soapModel;
	}

	public static JiraProjectSoap[] toSoapModels(JiraProject[] models) {
		JiraProjectSoap[] soapModels = new JiraProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraProjectSoap[][] toSoapModels(JiraProject[][] models) {
		JiraProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraProjectSoap[] toSoapModels(List<JiraProject> models) {
		List<JiraProjectSoap> soapModels = new ArrayList<JiraProjectSoap>(models.size());

		for (JiraProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraProjectSoap[soapModels.size()]);
	}

	public JiraProjectSoap() {
	}

	public long getPrimaryKey() {
		return _jiraProjectId;
	}

	public void setPrimaryKey(long pk) {
		setJiraProjectId(pk);
	}

	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	public void setJiraProjectId(long jiraProjectId) {
		_jiraProjectId = jiraProjectId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public long getJiraProjectCode() {
		return _jiraProjectCode;
	}

	public void setJiraProjectCode(long jiraProjectCode) {
		_jiraProjectCode = jiraProjectCode;
	}

	private long _jiraProjectId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _label;
	private long _jiraProjectCode;
}