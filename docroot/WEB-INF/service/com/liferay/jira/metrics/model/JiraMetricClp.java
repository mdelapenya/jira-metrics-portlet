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
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manuel de la Peña
 */
public class JiraMetricClp extends BaseModelImpl<JiraMetric>
	implements JiraMetric {
	public JiraMetricClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JiraMetric.class;
	}

	@Override
	public String getModelClassName() {
		return JiraMetric.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jiraMetricId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraMetricId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraMetricId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraMetricId", getJiraMetricId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("jiraComponentId", getJiraComponentId());
		attributes.put("jiraStatusId", getJiraStatusId());
		attributes.put("priority", getPriority());
		attributes.put("day", getDay());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());
		attributes.put("total", getTotal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraMetricId = (Long)attributes.get("jiraMetricId");

		if (jiraMetricId != null) {
			setJiraMetricId(jiraMetricId);
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

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		Long jiraComponentId = (Long)attributes.get("jiraComponentId");

		if (jiraComponentId != null) {
			setJiraComponentId(jiraComponentId);
		}

		Long jiraStatusId = (Long)attributes.get("jiraStatusId");

		if (jiraStatusId != null) {
			setJiraStatusId(jiraStatusId);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
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

		Integer total = (Integer)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}
	}

	@Override
	public long getJiraMetricId() {
		return _jiraMetricId;
	}

	@Override
	public void setJiraMetricId(long jiraMetricId) {
		_jiraMetricId = jiraMetricId;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraMetricId", long.class);

				method.invoke(_jiraMetricRemoteModel, jiraMetricId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_jiraMetricRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_jiraMetricRemoteModel, userName);
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

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jiraMetricRemoteModel, createDate);
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

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jiraMetricRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_jiraProjectId = jiraProjectId;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraProjectId", long.class);

				method.invoke(_jiraMetricRemoteModel, jiraProjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJiraComponentId() {
		return _jiraComponentId;
	}

	@Override
	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponentId = jiraComponentId;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraComponentId", long.class);

				method.invoke(_jiraMetricRemoteModel, jiraComponentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJiraStatusId() {
		return _jiraStatusId;
	}

	@Override
	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatusId = jiraStatusId;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraStatusId", long.class);

				method.invoke(_jiraMetricRemoteModel, jiraStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		_priority = priority;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority", int.class);

				method.invoke(_jiraMetricRemoteModel, priority);
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

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setDay", int.class);

				method.invoke(_jiraMetricRemoteModel, day);
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

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setMonth", int.class);

				method.invoke(_jiraMetricRemoteModel, month);
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

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_jiraMetricRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTotal() {
		return _total;
	}

	@Override
	public void setTotal(int total) {
		_total = total;

		if (_jiraMetricRemoteModel != null) {
			try {
				Class<?> clazz = _jiraMetricRemoteModel.getClass();

				Method method = clazz.getMethod("setTotal", int.class);

				method.invoke(_jiraMetricRemoteModel, total);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJiraMetricRemoteModel() {
		return _jiraMetricRemoteModel;
	}

	public void setJiraMetricRemoteModel(BaseModel<?> jiraMetricRemoteModel) {
		_jiraMetricRemoteModel = jiraMetricRemoteModel;
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

		Class<?> remoteModelClass = _jiraMetricRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jiraMetricRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JiraMetricLocalServiceUtil.addJiraMetric(this);
		}
		else {
			JiraMetricLocalServiceUtil.updateJiraMetric(this);
		}
	}

	@Override
	public JiraMetric toEscapedModel() {
		return (JiraMetric)ProxyUtil.newProxyInstance(JiraMetric.class.getClassLoader(),
			new Class[] { JiraMetric.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JiraMetricClp clone = new JiraMetricClp();

		clone.setJiraMetricId(getJiraMetricId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setJiraProjectId(getJiraProjectId());
		clone.setJiraComponentId(getJiraComponentId());
		clone.setJiraStatusId(getJiraStatusId());
		clone.setPriority(getPriority());
		clone.setDay(getDay());
		clone.setMonth(getMonth());
		clone.setYear(getYear());
		clone.setTotal(getTotal());

		return clone;
	}

	@Override
	public int compareTo(JiraMetric jiraMetric) {
		long primaryKey = jiraMetric.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraMetricClp)) {
			return false;
		}

		JiraMetricClp jiraMetric = (JiraMetricClp)obj;

		long primaryKey = jiraMetric.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{jiraMetricId=");
		sb.append(getJiraMetricId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", jiraProjectId=");
		sb.append(getJiraProjectId());
		sb.append(", jiraComponentId=");
		sb.append(getJiraComponentId());
		sb.append(", jiraStatusId=");
		sb.append(getJiraStatusId());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraMetric");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraMetricId</column-name><column-value><![CDATA[");
		sb.append(getJiraMetricId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>jiraProjectId</column-name><column-value><![CDATA[");
		sb.append(getJiraProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraComponentId</column-name><column-value><![CDATA[");
		sb.append(getJiraComponentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraStatusId</column-name><column-value><![CDATA[");
		sb.append(getJiraStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
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
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jiraMetricId;
	private long _userId;
	private String _userUuid;
	private String _userName;
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
	private BaseModel<?> _jiraMetricRemoteModel;
}