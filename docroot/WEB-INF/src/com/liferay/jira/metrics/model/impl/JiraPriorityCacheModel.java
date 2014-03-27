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

import com.liferay.jira.metrics.model.JiraPriority;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraPriority in entity cache.
 *
 * @author Manuel de la Pe√±a
 * @see JiraPriority
 * @generated
 */
public class JiraPriorityCacheModel implements CacheModel<JiraPriority>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jiraPriorityId=");
		sb.append(jiraPriorityId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", value=");
		sb.append(value);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraPriority toEntityModel() {
		JiraPriorityImpl jiraPriorityImpl = new JiraPriorityImpl();

		jiraPriorityImpl.setJiraPriorityId(jiraPriorityId);

		if (createDate == Long.MIN_VALUE) {
			jiraPriorityImpl.setCreateDate(null);
		}
		else {
			jiraPriorityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraPriorityImpl.setModifiedDate(null);
		}
		else {
			jiraPriorityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (value == null) {
			jiraPriorityImpl.setValue(StringPool.BLANK);
		}
		else {
			jiraPriorityImpl.setValue(value);
		}

		if (name == null) {
			jiraPriorityImpl.setName(StringPool.BLANK);
		}
		else {
			jiraPriorityImpl.setName(name);
		}

		jiraPriorityImpl.resetOriginalValues();

		return jiraPriorityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraPriorityId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		value = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraPriorityId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long jiraPriorityId;
	public long createDate;
	public long modifiedDate;
	public String value;
	public String name;
}