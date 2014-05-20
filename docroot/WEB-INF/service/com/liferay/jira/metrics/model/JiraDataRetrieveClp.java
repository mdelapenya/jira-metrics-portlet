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

import com.liferay.jira.metrics.service.ClpSerializer;
import com.liferay.jira.metrics.service.JiraDataRetrieveLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public class JiraDataRetrieveClp extends BaseModelImpl<JiraDataRetrieve>
	implements JiraDataRetrieve {
	public JiraDataRetrieveClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JiraDataRetrieve.class;
	}

	@Override
	public String getModelClassName() {
		return JiraDataRetrieve.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraDataRetrieveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraDataRetrieveId", getJiraDataRetrieveId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusDescription", getStatusDescription());
		attributes.put("day", getDay());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraDataRetrieveId = (Long)attributes.get("jiraDataRetrieveId");

		if (jiraDataRetrieveId != null) {
			setJiraDataRetrieveId(jiraDataRetrieveId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusDescription = (String)attributes.get("statusDescription");

		if (statusDescription != null) {
			setStatusDescription(statusDescription);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public long getJiraDataRetrieveId() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setJiraDataRetrieveId(long jiraDataRetrieveId) {
		_jiraDataRetrieveId = jiraDataRetrieveId;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraDataRetrieveId",
						long.class);

				method.invoke(_jiraDataRetrieveRemoteModel, jiraDataRetrieveId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jiraDataRetrieveRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jiraDataRetrieveRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_jiraDataRetrieveRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusDescription() {
		return _statusDescription;
	}

	@Override
	public void setStatusDescription(String statusDescription) {
		_statusDescription = statusDescription;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDescription",
						String.class);

				method.invoke(_jiraDataRetrieveRemoteModel, statusDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_day = day;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setDay", int.class);

				method.invoke(_jiraDataRetrieveRemoteModel, day);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMonth() {
		return _month;
	}

	@Override
	public void setMonth(int month) {
		_month = month;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setMonth", int.class);

				method.invoke(_jiraDataRetrieveRemoteModel, month);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_jiraDataRetrieveRemoteModel != null) {
			try {
				Class<?> clazz = _jiraDataRetrieveRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_jiraDataRetrieveRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJiraDataRetrieveRemoteModel() {
		return _jiraDataRetrieveRemoteModel;
	}

	public void setJiraDataRetrieveRemoteModel(
		BaseModel<?> jiraDataRetrieveRemoteModel) {
		_jiraDataRetrieveRemoteModel = jiraDataRetrieveRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _jiraDataRetrieveRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_jiraDataRetrieveRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JiraDataRetrieveLocalServiceUtil.addJiraDataRetrieve(this);
		}
		else {
			JiraDataRetrieveLocalServiceUtil.updateJiraDataRetrieve(this);
		}
	}

	@Override
	public JiraDataRetrieve toEscapedModel() {
		return (JiraDataRetrieve)ProxyUtil.newProxyInstance(JiraDataRetrieve.class.getClassLoader(),
			new Class[] { JiraDataRetrieve.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JiraDataRetrieveClp clone = new JiraDataRetrieveClp();

		clone.setJiraDataRetrieveId(getJiraDataRetrieveId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setStatusDescription(getStatusDescription());
		clone.setDay(getDay());
		clone.setMonth(getMonth());
		clone.setYear(getYear());

		return clone;
	}

	@Override
	public int compareTo(JiraDataRetrieve jiraDataRetrieve) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				jiraDataRetrieve.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraDataRetrieveClp)) {
			return false;
		}

		JiraDataRetrieveClp jiraDataRetrieve = (JiraDataRetrieveClp)obj;

		long primaryKey = jiraDataRetrieve.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{jiraDataRetrieveId=");
		sb.append(getJiraDataRetrieveId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusDescription=");
		sb.append(getStatusDescription());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", year=");
		sb.append(getYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraDataRetrieve");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraDataRetrieveId</column-name><column-value><![CDATA[");
		sb.append(getJiraDataRetrieveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDescription</column-name><column-value><![CDATA[");
		sb.append(getStatusDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month</column-name><column-value><![CDATA[");
		sb.append(getMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jiraDataRetrieveId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _status;
	private String _statusDescription;
	private int _day;
	private int _month;
	private int _year;
	private BaseModel<?> _jiraDataRetrieveRemoteModel;
}