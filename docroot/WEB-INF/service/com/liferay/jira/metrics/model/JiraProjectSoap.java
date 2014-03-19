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
 * @author Manuel de la Pe√±a
 * @see com.liferay.jira.metrics.service.http.JiraProjectServiceSoap
 * @generated
 */
public class JiraProjectSoap implements Serializable {
	public static JiraProjectSoap toSoapModel(JiraProject model) {
		JiraProjectSoap soapModel = new JiraProjectSoap();

		soapModel.setJiraProjectId(model.getJiraProjectId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKey(model.getKey());
		soapModel.setName(model.getName());

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

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _jiraProjectId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _name;
}