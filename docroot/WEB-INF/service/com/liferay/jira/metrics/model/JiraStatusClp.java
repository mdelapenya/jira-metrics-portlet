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
import com.liferay.jira.metrics.service.JiraStatusLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class JiraStatusClp extends BaseModelImpl<JiraStatus>
	implements JiraStatus {
	public JiraStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JiraStatus.class;
	}

	@Override
	public String getModelClassName() {
		return JiraStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jiraStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraStatusId", getJiraStatusId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("jiraStatusCode", getJiraStatusCode());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraStatusId = (Long)attributes.get("jiraStatusId");

		if (jiraStatusId != null) {
			setJiraStatusId(jiraStatusId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long jiraStatusCode = (Long)attributes.get("jiraStatusCode");

		if (jiraStatusCode != null) {
			setJiraStatusCode(jiraStatusCode);
		}

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getJiraStatusId() {
		return _jiraStatusId;
	}

	@Override
	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatusId = jiraStatusId;

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraStatusId", long.class);

				method.invoke(_jiraStatusRemoteModel, jiraStatusId);
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

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jiraStatusRemoteModel, createDate);
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

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jiraStatusRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJiraStatusCode() {
		return _jiraStatusCode;
	}

	@Override
	public void setJiraStatusCode(long jiraStatusCode) {
		_jiraStatusCode = jiraStatusCode;

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraStatusCode", long.class);

				method.invoke(_jiraStatusRemoteModel, jiraStatusCode);
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

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraProjectId", long.class);

				method.invoke(_jiraStatusRemoteModel, jiraProjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_jiraStatusRemoteModel != null) {
			try {
				Class<?> clazz = _jiraStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_jiraStatusRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJiraStatusRemoteModel() {
		return _jiraStatusRemoteModel;
	}

	public void setJiraStatusRemoteModel(BaseModel<?> jiraStatusRemoteModel) {
		_jiraStatusRemoteModel = jiraStatusRemoteModel;
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

		Class<?> remoteModelClass = _jiraStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jiraStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JiraStatusLocalServiceUtil.addJiraStatus(this);
		}
		else {
			JiraStatusLocalServiceUtil.updateJiraStatus(this);
		}
	}

	@Override
	public JiraStatus toEscapedModel() {
		return (JiraStatus)ProxyUtil.newProxyInstance(JiraStatus.class.getClassLoader(),
			new Class[] { JiraStatus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JiraStatusClp clone = new JiraStatusClp();

		clone.setJiraStatusId(getJiraStatusId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setJiraStatusCode(getJiraStatusCode());
		clone.setJiraProjectId(getJiraProjectId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(JiraStatus jiraStatus) {
		int value = 0;

		value = getName().compareTo(jiraStatus.getName());

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

		if (!(obj instanceof JiraStatusClp)) {
			return false;
		}

		JiraStatusClp jiraStatus = (JiraStatusClp)obj;

		long primaryKey = jiraStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{jiraStatusId=");
		sb.append(getJiraStatusId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", jiraStatusCode=");
		sb.append(getJiraStatusCode());
		sb.append(", jiraProjectId=");
		sb.append(getJiraProjectId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraStatusId</column-name><column-value><![CDATA[");
		sb.append(getJiraStatusId());
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
			"<column><column-name>jiraStatusCode</column-name><column-value><![CDATA[");
		sb.append(getJiraStatusCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraProjectId</column-name><column-value><![CDATA[");
		sb.append(getJiraProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jiraStatusId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _jiraStatusCode;
	private long _jiraProjectId;
	private String _name;
	private BaseModel<?> _jiraStatusRemoteModel;
}