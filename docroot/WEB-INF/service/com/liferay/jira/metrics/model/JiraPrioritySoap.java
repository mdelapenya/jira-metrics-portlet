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
 * This class is used by SOAP remote services, specifically {@link com.liferay.jira.metrics.service.http.JiraPriorityServiceSoap}.
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.http.JiraPriorityServiceSoap
 * @generated
 */
public class JiraPrioritySoap implements Serializable {
	public static JiraPrioritySoap toSoapModel(JiraPriority model) {
		JiraPrioritySoap soapModel = new JiraPrioritySoap();

		soapModel.setJiraPriorityId(model.getJiraPriorityId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setValue(model.getValue());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static JiraPrioritySoap[] toSoapModels(JiraPriority[] models) {
		JiraPrioritySoap[] soapModels = new JiraPrioritySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JiraPrioritySoap[][] toSoapModels(JiraPriority[][] models) {
		JiraPrioritySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JiraPrioritySoap[models.length][models[0].length];
		}
		else {
			soapModels = new JiraPrioritySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JiraPrioritySoap[] toSoapModels(List<JiraPriority> models) {
		List<JiraPrioritySoap> soapModels = new ArrayList<JiraPrioritySoap>(models.size());

		for (JiraPriority model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JiraPrioritySoap[soapModels.size()]);
	}

	public JiraPrioritySoap() {
	}

	public long getPrimaryKey() {
		return _jiraPriorityId;
	}

	public void setPrimaryKey(long pk) {
		setJiraPriorityId(pk);
	}

	public long getJiraPriorityId() {
		return _jiraPriorityId;
	}

	public void setJiraPriorityId(long jiraPriorityId) {
		_jiraPriorityId = jiraPriorityId;
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _jiraPriorityId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _value;
	private String _name;
}