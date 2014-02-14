/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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

import com.liferay.jira.metrics.model.JiraProject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraProject in entity cache.
 *
 * @author Manuel de la Peña
 * @see JiraProject
 * @generated
 */
public class JiraProjectCacheModel implements CacheModel<JiraProject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jiraProjectId=");
		sb.append(jiraProjectId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", key=");
		sb.append(key);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraProject toEntityModel() {
		JiraProjectImpl jiraProjectImpl = new JiraProjectImpl();

		jiraProjectImpl.setJiraProjectId(jiraProjectId);

		if (createDate == Long.MIN_VALUE) {
			jiraProjectImpl.setCreateDate(null);
		}
		else {
			jiraProjectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraProjectImpl.setModifiedDate(null);
		}
		else {
			jiraProjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			jiraProjectImpl.setKey(StringPool.BLANK);
		}
		else {
			jiraProjectImpl.setKey(key);
		}

		if (name == null) {
			jiraProjectImpl.setName(StringPool.BLANK);
		}
		else {
			jiraProjectImpl.setName(name);
		}

		jiraProjectImpl.resetOriginalValues();

		return jiraProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraProjectId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraProjectId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long jiraProjectId;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String name;
}