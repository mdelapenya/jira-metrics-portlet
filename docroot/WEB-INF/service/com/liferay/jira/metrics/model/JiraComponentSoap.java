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
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraComponentServiceSoap}.
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.http.JiraComponentServiceSoap
 * @generated
 */
public class JiraComponentSoap implements Serializable {
	public static JiraComponentSoap toSoapModel(JiraComponent model) {
		JiraComponentSoap soapModel = new JiraComponentSoap();

		soapModel.setJiraComponentId(model.getJiraComponentId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUri(model.getUri());
		soapModel.setJiraProjectId(model.getJiraProjectId());
		soapModel.setName(model.getName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static JiraComponentSoap[] toSoapModels(JiraComponent[] models) {
		JiraComponentSoap[] soapModels = new JiraComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraComponentSoap[][] toSoapModels(JiraComponent[][] models) {
		JiraComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraComponentSoap[] toSoapModels(List<JiraComponent> models) {
		List<JiraComponentSoap> soapModels = new ArrayList<JiraComponentSoap>(models.size());

		for (JiraComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraComponentSoap[soapModels.size()]);
	}

	public JiraComponentSoap() {
	}

	public long getPrimaryKey() {
		return _jiraComponentId;
	}

	public void setPrimaryKey(long pk) {
		setJiraComponentId(pk);
	}

	public long getJiraComponentId() {
		return _jiraComponentId;
	}

	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponentId = jiraComponentId;
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

	public String getUri() {
		return _uri;
	}

	public void setUri(String uri) {
		_uri = uri;
	}

	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	public void setJiraProjectId(long jiraProjectId) {
		_jiraProjectId = jiraProjectId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _jiraComponentId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uri;
	private long _jiraProjectId;
	private String _name;
	private int _status;
}