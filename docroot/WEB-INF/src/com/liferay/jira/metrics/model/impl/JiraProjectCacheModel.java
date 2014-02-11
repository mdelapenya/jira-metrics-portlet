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
		StringBundler sb = new StringBundler(17);

		sb.append("{jiraProjectId=");
		sb.append(jiraProjectId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", jiraProjectCode=");
		sb.append(jiraProjectCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraProject toEntityModel() {
		JiraProjectImpl jiraProjectImpl = new JiraProjectImpl();

		jiraProjectImpl.setJiraProjectId(jiraProjectId);
		jiraProjectImpl.setUserId(userId);

		if (userName == null) {
			jiraProjectImpl.setUserName(StringPool.BLANK);
		}
		else {
			jiraProjectImpl.setUserName(userName);
		}

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

		if (name == null) {
			jiraProjectImpl.setName(StringPool.BLANK);
		}
		else {
			jiraProjectImpl.setName(name);
		}

		if (label == null) {
			jiraProjectImpl.setLabel(StringPool.BLANK);
		}
		else {
			jiraProjectImpl.setLabel(label);
		}

		jiraProjectImpl.setJiraProjectCode(jiraProjectCode);

		jiraProjectImpl.resetOriginalValues();

		return jiraProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraProjectId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		jiraProjectCode = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraProjectId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeLong(jiraProjectCode);
	}

	public long jiraProjectId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String label;
	public long jiraProjectCode;
}