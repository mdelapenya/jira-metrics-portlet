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
import com.liferay.jira.metrics.service.JiraComponentLocalServiceUtil;

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
public class JiraComponentClp extends BaseModelImpl<JiraComponent>
	implements JiraComponent {
	public JiraComponentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JiraComponent.class;
	}

	@Override
	public String getModelClassName() {
		return JiraComponent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jiraComponentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraComponentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraComponentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraComponentId", getJiraComponentId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uri", getUri());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("name", getName());
		attributes.put("disabled", getDisabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraComponentId = (Long)attributes.get("jiraComponentId");

		if (jiraComponentId != null) {
			setJiraComponentId(jiraComponentId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String uri = (String)attributes.get("uri");

		if (uri != null) {
			setUri(uri);
		}

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean disabled = (Boolean)attributes.get("disabled");

		if (disabled != null) {
			setDisabled(disabled);
		}
	}

	@Override
	public long getJiraComponentId() {
		return _jiraComponentId;
	}

	@Override
	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponentId = jiraComponentId;

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraComponentId", long.class);

				method.invoke(_jiraComponentRemoteModel, jiraComponentId);
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

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jiraComponentRemoteModel, createDate);
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

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jiraComponentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUri() {
		return _uri;
	}

	@Override
	public void setUri(String uri) {
		_uri = uri;

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setUri", String.class);

				method.invoke(_jiraComponentRemoteModel, uri);
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

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraProjectId", long.class);

				method.invoke(_jiraComponentRemoteModel, jiraProjectId);
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

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_jiraComponentRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisabled() {
		return _disabled;
	}

	@Override
	public boolean isDisabled() {
		return _disabled;
	}

	@Override
	public void setDisabled(boolean disabled) {
		_disabled = disabled;

		if (_jiraComponentRemoteModel != null) {
			try {
				Class<?> clazz = _jiraComponentRemoteModel.getClass();

				Method method = clazz.getMethod("setDisabled", boolean.class);

				method.invoke(_jiraComponentRemoteModel, disabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJiraComponentRemoteModel() {
		return _jiraComponentRemoteModel;
	}

	public void setJiraComponentRemoteModel(
		BaseModel<?> jiraComponentRemoteModel) {
		_jiraComponentRemoteModel = jiraComponentRemoteModel;
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

		Class<?> remoteModelClass = _jiraComponentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jiraComponentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JiraComponentLocalServiceUtil.addJiraComponent(this);
		}
		else {
			JiraComponentLocalServiceUtil.updateJiraComponent(this);
		}
	}

	@Override
	public JiraComponent toEscapedModel() {
		return (JiraComponent)ProxyUtil.newProxyInstance(JiraComponent.class.getClassLoader(),
			new Class[] { JiraComponent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JiraComponentClp clone = new JiraComponentClp();

		clone.setJiraComponentId(getJiraComponentId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUri(getUri());
		clone.setJiraProjectId(getJiraProjectId());
		clone.setName(getName());
		clone.setDisabled(getDisabled());

		return clone;
	}

	@Override
	public int compareTo(JiraComponent jiraComponent) {
		int value = 0;

		value = getName().compareTo(jiraComponent.getName());

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

		if (!(obj instanceof JiraComponentClp)) {
			return false;
		}

		JiraComponentClp jiraComponent = (JiraComponentClp)obj;

		long primaryKey = jiraComponent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{jiraComponentId=");
		sb.append(getJiraComponentId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", uri=");
		sb.append(getUri());
		sb.append(", jiraProjectId=");
		sb.append(getJiraProjectId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", disabled=");
		sb.append(getDisabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraComponent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraComponentId</column-name><column-value><![CDATA[");
		sb.append(getJiraComponentId());
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
			"<column><column-name>uri</column-name><column-value><![CDATA[");
		sb.append(getUri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraProjectId</column-name><column-value><![CDATA[");
		sb.append(getJiraProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disabled</column-name><column-value><![CDATA[");
		sb.append(getDisabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jiraComponentId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uri;
	private long _jiraProjectId;
	private String _name;
	private boolean _disabled;
	private BaseModel<?> _jiraComponentRemoteModel;
}