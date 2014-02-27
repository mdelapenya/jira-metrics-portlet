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
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraStatusServiceSoap}.
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.http.JiraStatusServiceSoap
 * @generated
 */
public class JiraStatusSoap implements Serializable {
	public static JiraStatusSoap toSoapModel(JiraStatus model) {
		JiraStatusSoap soapModel = new JiraStatusSoap();

		soapModel.setJiraStatusId(model.getJiraStatusId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUri(model.getUri());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static JiraStatusSoap[] toSoapModels(JiraStatus[] models) {
		JiraStatusSoap[] soapModels = new JiraStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraStatusSoap[][] toSoapModels(JiraStatus[][] models) {
		JiraStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraStatusSoap[] toSoapModels(List<JiraStatus> models) {
		List<JiraStatusSoap> soapModels = new ArrayList<JiraStatusSoap>(models.size());

		for (JiraStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraStatusSoap[soapModels.size()]);
	}

	public JiraStatusSoap() {
	}

	public long getPrimaryKey() {
		return _jiraStatusId;
	}

	public void setPrimaryKey(long pk) {
		setJiraStatusId(pk);
	}

	public long getJiraStatusId() {
		return _jiraStatusId;
	}

	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatusId = jiraStatusId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _jiraStatusId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uri;
	private String _name;
}