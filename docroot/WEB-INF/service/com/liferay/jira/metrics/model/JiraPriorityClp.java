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
import com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
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
public class JiraPriorityClp extends BaseModelImpl<JiraPriority>
	implements JiraPriority {
	public JiraPriorityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JiraPriority.class;
	}

	@Override
	public String getModelClassName() {
		return JiraPriority.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jiraPriorityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraPriorityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraPriorityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraPriorityId", getJiraPriorityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("value", getValue());
		attributes.put("name", getName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraPriorityId = (Long)attributes.get("jiraPriorityId");

		if (jiraPriorityId != null) {
			setJiraPriorityId(jiraPriorityId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getJiraPriorityId() {
		return _jiraPriorityId;
	}

	@Override
	public void setJiraPriorityId(long jiraPriorityId) {
		_jiraPriorityId = jiraPriorityId;

		if (_jiraPriorityRemoteModel != null) {
			try {
				Class<?> clazz = _jiraPriorityRemoteModel.getClass();

				Method method = clazz.getMethod("setJiraPriorityId", long.class);

				method.invoke(_jiraPriorityRemoteModel, jiraPriorityId);
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

		if (_jiraPriorityRemoteModel != null) {
			try {
				Class<?> clazz = _jiraPriorityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jiraPriorityRemoteModel, createDate);
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

		if (_jiraPriorityRemoteModel != null) {
			try {
				Class<?> clazz = _jiraPriorityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jiraPriorityRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_jiraPriorityRemoteModel != null) {
			try {
				Class<?> clazz = _jiraPriorityRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_jiraPriorityRemoteModel, value);
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

		if (_jiraPriorityRemoteModel != null) {
			try {
				Class<?> clazz = _jiraPriorityRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_jiraPriorityRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJiraPriorityRemoteModel() {
		return _jiraPriorityRemoteModel;
	}

	public void setJiraPriorityRemoteModel(BaseModel<?> jiraPriorityRemoteModel) {
		_jiraPriorityRemoteModel = jiraPriorityRemoteModel;
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

		Class<?> remoteModelClass = _jiraPriorityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jiraPriorityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			JiraPriorityLocalServiceUtil.addJiraPriority(this);
		}
		else {
			JiraPriorityLocalServiceUtil.updateJiraPriority(this);
		}
	}

	@Override
	public JiraPriority toEscapedModel() {
		return (JiraPriority)ProxyUtil.newProxyInstance(JiraPriority.class.getClassLoader(),
			new Class[] { JiraPriority.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JiraPriorityClp clone = new JiraPriorityClp();

		clone.setJiraPriorityId(getJiraPriorityId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setValue(getValue());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(JiraPriority jiraPriority) {
		int value = 0;

		value = getValue().compareTo(jiraPriority.getValue());

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

		if (!(obj instanceof JiraPriorityClp)) {
			return false;
		}

		JiraPriorityClp jiraPriority = (JiraPriorityClp)obj;

		long primaryKey = jiraPriority.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jiraPriorityId=");
		sb.append(getJiraPriorityId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraPriority");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraPriorityId</column-name><column-value><![CDATA[");
		sb.append(getJiraPriorityId());
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
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jiraPriorityId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _value;
	private String _name;
	private BaseModel<?> _jiraPriorityRemoteModel;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}