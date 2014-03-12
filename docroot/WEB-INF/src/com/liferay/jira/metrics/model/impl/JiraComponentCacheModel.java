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

import com.liferay.jira.metrics.model.JiraComponent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraComponent in entity cache.
 *
 * @author Manuel de la Pe√±a
 * @see JiraComponent
 * @generated
 */
public class JiraComponentCacheModel implements CacheModel<JiraComponent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{jiraComponentId=");
		sb.append(jiraComponentId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", uri=");
		sb.append(uri);
		sb.append(", jiraProjectId=");
		sb.append(jiraProjectId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", disabled=");
		sb.append(disabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraComponent toEntityModel() {
		JiraComponentImpl jiraComponentImpl = new JiraComponentImpl();

		jiraComponentImpl.setJiraComponentId(jiraComponentId);

		if (createDate == Long.MIN_VALUE) {
			jiraComponentImpl.setCreateDate(null);
		}
		else {
			jiraComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraComponentImpl.setModifiedDate(null);
		}
		else {
			jiraComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uri == null) {
			jiraComponentImpl.setUri(StringPool.BLANK);
		}
		else {
			jiraComponentImpl.setUri(uri);
		}

		jiraComponentImpl.setJiraProjectId(jiraProjectId);

		if (name == null) {
			jiraComponentImpl.setName(StringPool.BLANK);
		}
		else {
			jiraComponentImpl.setName(name);
		}

		jiraComponentImpl.setDisabled(disabled);

		jiraComponentImpl.resetOriginalValues();

		return jiraComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraComponentId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uri = objectInput.readUTF();
		jiraProjectId = objectInput.readLong();
		name = objectInput.readUTF();
		disabled = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraComponentId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (uri == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uri);
		}

		objectOutput.writeLong(jiraProjectId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(disabled);
	}

	public long jiraComponentId;
	public long createDate;
	public long modifiedDate;
	public String uri;
	public long jiraProjectId;
	public String name;
	public boolean disabled;
}