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
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraMetricServiceSoap}.
 *
 * @author Manuel de la Pe√±a
 * @see com.liferay.jira.metrics.service.http.JiraMetricServiceSoap
 * @generated
 */
public class JiraMetricSoap implements Serializable {
	public static JiraMetricSoap toSoapModel(JiraMetric model) {
		JiraMetricSoap soapModel = new JiraMetricSoap();

		soapModel.setJiraMetricId(model.getJiraMetricId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJiraProjectId(model.getJiraProjectId());
		soapModel.setJiraComponentId(model.getJiraComponentId());
		soapModel.setJiraStatusId(model.getJiraStatusId());
		soapModel.setPriority(model.getPriority());
		soapModel.setDay(model.getDay());
		soapModel.setMonth(model.getMonth());
		soapModel.setYear(model.getYear());
		soapModel.setTotal(model.getTotal());

		return soapModel;
	}

	public static JiraMetricSoap[] toSoapModels(JiraMetric[] models) {
		JiraMetricSoap[] soapModels = new JiraMetricSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraMetricSoap[][] toSoapModels(JiraMetric[][] models) {
		JiraMetricSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraMetricSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraMetricSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraMetricSoap[] toSoapModels(List<JiraMetric> models) {
		List<JiraMetricSoap> soapModels = new ArrayList<JiraMetricSoap>(models.size());

		for (JiraMetric model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraMetricSoap[soapModels.size()]);
	}

	public JiraMetricSoap() {
	}

	public long getPrimaryKey() {
		return _jiraMetricId;
	}

	public void setPrimaryKey(long pk) {
		setJiraMetricId(pk);
	}

	public long getJiraMetricId() {
		return _jiraMetricId;
	}

	public void setJiraMetricId(long jiraMetricId) {
		_jiraMetricId = jiraMetricId;
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

	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	public void setJiraProjectId(long jiraProjectId) {
		_jiraProjectId = jiraProjectId;
	}

	public long getJiraComponentId() {
		return _jiraComponentId;
	}

	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponentId = jiraComponentId;
	}

	public long getJiraStatusId() {
		return _jiraStatusId;
	}

	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatusId = jiraStatusId;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
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

	public int getTotal() {
		return _total;
	}

	public void setTotal(int total) {
		_total = total;
	}

	private long _jiraMetricId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _jiraProjectId;
	private long _jiraComponentId;
	private long _jiraStatusId;
	private int _priority;
	private int _day;
	private int _month;
	private int _year;
	private int _total;
}