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

package com.liferay.jira.metrics.model.impl;

import com.liferay.jira.metrics.model.JiraStatus;
import com.liferay.jira.metrics.model.JiraStatusModel;
import com.liferay.jira.metrics.model.JiraStatusSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JiraStatus service. Represents a row in the &quot;jirametrics_JiraStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.jira.metrics.model.JiraStatusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JiraStatusImpl}.
 * </p>
 *
 * @author Manuel de la Pe√±a
 * @see JiraStatusImpl
 * @see com.liferay.jira.metrics.model.JiraStatus
 * @see com.liferay.jira.metrics.model.JiraStatusModel
 * @generated
 */
@JSON(strict = true)
public class JiraStatusModelImpl extends BaseModelImpl<JiraStatus>
	implements JiraStatusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a jira status model instance should use the {@link com.liferay.jira.metrics.model.JiraStatus} interface instead.
	 */
	public static final String TABLE_NAME = "jirametrics_JiraStatus";
	public static final Object[][] TABLE_COLUMNS = {
			{ "jiraStatusId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "uri", Types.VARCHAR },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table jirametrics_JiraStatus (jiraStatusId LONG not null primary key,createDate DATE null,modifiedDate DATE null,uri VARCHAR(75) null,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table jirametrics_JiraStatus";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraStatus.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY jirametrics_JiraStatus.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.jira.metrics.model.JiraStatus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.jira.metrics.model.JiraStatus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.jira.metrics.model.JiraStatus"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;
	public static long URI_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JiraStatus toModel(JiraStatusSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JiraStatus model = new JiraStatusImpl();

		model.setJiraStatusId(soapModel.getJiraStatusId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setUri(soapModel.getUri());
		model.setName(soapModel.getName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JiraStatus> toModels(JiraStatusSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JiraStatus> models = new ArrayList<JiraStatus>(soapModels.length);

		for (JiraStatusSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.jira.metrics.model.JiraStatus"));

	public JiraStatusModelImpl() {
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
	public Class<?> getModelClass() {
		return JiraStatus.class;
	}

	@Override
	public String getModelClassName() {
		return JiraStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraStatusId", getJiraStatusId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uri", getUri());
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

		String uri = (String)attributes.get("uri");

		if (uri != null) {
			setUri(uri);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@JSON
	@Override
	public long getJiraStatusId() {
		return _jiraStatusId;
	}

	@Override
	public void setJiraStatusId(long jiraStatusId) {
		_jiraStatusId = jiraStatusId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getUri() {
		if (_uri == null) {
			return StringPool.BLANK;
		}
		else {
			return _uri;
		}
	}

	@Override
	public void setUri(String uri) {
		_columnBitmask |= URI_COLUMN_BITMASK;

		if (_originalUri == null) {
			_originalUri = _uri;
		}

		_uri = uri;
	}

	public String getOriginalUri() {
		return GetterUtil.getString(_originalUri);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JiraStatus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JiraStatus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JiraStatus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JiraStatusImpl jiraStatusImpl = new JiraStatusImpl();

		jiraStatusImpl.setJiraStatusId(getJiraStatusId());
		jiraStatusImpl.setCreateDate(getCreateDate());
		jiraStatusImpl.setModifiedDate(getModifiedDate());
		jiraStatusImpl.setUri(getUri());
		jiraStatusImpl.setName(getName());

		jiraStatusImpl.resetOriginalValues();

		return jiraStatusImpl;
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

		if (!(obj instanceof JiraStatus)) {
			return false;
		}

		JiraStatus jiraStatus = (JiraStatus)obj;

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
	public void resetOriginalValues() {
		JiraStatusModelImpl jiraStatusModelImpl = this;

		jiraStatusModelImpl._originalUri = jiraStatusModelImpl._uri;

		jiraStatusModelImpl._originalName = jiraStatusModelImpl._name;

		jiraStatusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JiraStatus> toCacheModel() {
		JiraStatusCacheModel jiraStatusCacheModel = new JiraStatusCacheModel();

		jiraStatusCacheModel.jiraStatusId = getJiraStatusId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraStatusCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraStatusCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jiraStatusCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jiraStatusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jiraStatusCacheModel.uri = getUri();

		String uri = jiraStatusCacheModel.uri;

		if ((uri != null) && (uri.length() == 0)) {
			jiraStatusCacheModel.uri = null;
		}

		jiraStatusCacheModel.name = getName();

		String name = jiraStatusCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			jiraStatusCacheModel.name = null;
		}

		return jiraStatusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jiraStatusId=");
		sb.append(getJiraStatusId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", uri=");
		sb.append(getUri());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

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
			"<column><column-name>uri</column-name><column-value><![CDATA[");
		sb.append(getUri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JiraStatus.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			JiraStatus.class
		};
	private long _jiraStatusId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uri;
	private String _originalUri;
	private String _name;
	private String _originalName;
	private long _columnBitmask;
	private JiraStatus _escapedModel;
}