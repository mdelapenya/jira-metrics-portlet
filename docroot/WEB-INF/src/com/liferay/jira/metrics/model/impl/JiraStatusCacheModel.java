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

import com.liferay.jira.metrics.model.JiraStatus;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraStatus in entity cache.
 *
 * @author Manuel de la Peña
 * @see JiraStatus
 * @generated
 */
public class JiraStatusCacheModel implements CacheModel<JiraStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{jiraStatusId=");
		sb.append(jiraStatusId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", uri=");
		sb.append(uri);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraStatus toEntityModel() {
		JiraStatusImpl jiraStatusImpl = new JiraStatusImpl();

		jiraStatusImpl.setJiraStatusId(jiraStatusId);

		if (createDate == Long.MIN_VALUE) {
			jiraStatusImpl.setCreateDate(null);
		}
		else {
			jiraStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraStatusImpl.setModifiedDate(null);
		}
		else {
			jiraStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uri == null) {
			jiraStatusImpl.setUri(StringPool.BLANK);
		}
		else {
			jiraStatusImpl.setUri(uri);
		}

		if (name == null) {
			jiraStatusImpl.setName(StringPool.BLANK);
		}
		else {
			jiraStatusImpl.setName(name);
		}

		jiraStatusImpl.resetOriginalValues();

		return jiraStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraStatusId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uri = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraStatusId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (uri == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uri);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long jiraStatusId;
	public long createDate;
	public long modifiedDate;
	public String uri;
	public String name;
}