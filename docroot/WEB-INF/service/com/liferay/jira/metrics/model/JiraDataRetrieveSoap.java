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
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraDataRetrieveServiceSoap}.
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.http.JiraDataRetrieveServiceSoap
 * @generated
 */
public class JiraDataRetrieveSoap implements Serializable {
	public static JiraDataRetrieveSoap toSoapModel(JiraDataRetrieve model) {
		JiraDataRetrieveSoap soapModel = new JiraDataRetrieveSoap();

		soapModel.setJiraDataRetrieveId(model.getJiraDataRetrieveId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusDescription(model.getStatusDescription());
		soapModel.setDay(model.getDay());
		soapModel.setMonth(model.getMonth());
		soapModel.setYear(model.getYear());

		return soapModel;
	}

	public static JiraDataRetrieveSoap[] toSoapModels(JiraDataRetrieve[] models) {
		JiraDataRetrieveSoap[] soapModels = new JiraDataRetrieveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraDataRetrieveSoap[][] toSoapModels(
		JiraDataRetrieve[][] models) {
		JiraDataRetrieveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraDataRetrieveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraDataRetrieveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraDataRetrieveSoap[] toSoapModels(
		List<JiraDataRetrieve> models) {
		List<JiraDataRetrieveSoap> soapModels = new ArrayList<JiraDataRetrieveSoap>(models.size());

		for (JiraDataRetrieve model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraDataRetrieveSoap[soapModels.size()]);
	}

	public JiraDataRetrieveSoap() {
	}

	public long getPrimaryKey() {
		return _jiraDataRetrieveId;
	}

	public void setPrimaryKey(long pk) {
		setJiraDataRetrieveId(pk);
	}

	public long getJiraDataRetrieveId() {
		return _jiraDataRetrieveId;
	}

	public void setJiraDataRetrieveId(long jiraDataRetrieveId) {
		_jiraDataRetrieveId = jiraDataRetrieveId;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getStatusDescription() {
		return _statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		_statusDescription = statusDescription;
	}

	public int getDay() {
		return _day;
	}

	public void setDay(int day) {
		_day = day;
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int month) {
		_month = month;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	private long _jiraDataRetrieveId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _status;
	private String _statusDescription;
	private int _day;
	private int _month;
	private int _year;
}