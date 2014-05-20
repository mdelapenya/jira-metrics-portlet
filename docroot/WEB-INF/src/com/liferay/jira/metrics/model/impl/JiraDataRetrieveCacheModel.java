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

import com.liferay.jira.metrics.model.JiraDataRetrieve;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraDataRetrieve in entity cache.
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieve
 * @generated
 */
public class JiraDataRetrieveCacheModel implements CacheModel<JiraDataRetrieve>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{jiraDataRetrieveId=");
		sb.append(jiraDataRetrieveId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusDescription=");
		sb.append(statusDescription);
		sb.append(", day=");
		sb.append(day);
		sb.append(", month=");
		sb.append(month);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraDataRetrieve toEntityModel() {
		JiraDataRetrieveImpl jiraDataRetrieveImpl = new JiraDataRetrieveImpl();

		jiraDataRetrieveImpl.setJiraDataRetrieveId(jiraDataRetrieveId);

		if (createDate == Long.MIN_VALUE) {
			jiraDataRetrieveImpl.setCreateDate(null);
		}
		else {
			jiraDataRetrieveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraDataRetrieveImpl.setModifiedDate(null);
		}
		else {
			jiraDataRetrieveImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (status == null) {
			jiraDataRetrieveImpl.setStatus(StringPool.BLANK);
		}
		else {
			jiraDataRetrieveImpl.setStatus(status);
		}

		if (statusDescription == null) {
			jiraDataRetrieveImpl.setStatusDescription(StringPool.BLANK);
		}
		else {
			jiraDataRetrieveImpl.setStatusDescription(statusDescription);
		}

		jiraDataRetrieveImpl.setDay(day);
		jiraDataRetrieveImpl.setMonth(month);
		jiraDataRetrieveImpl.setYear(year);

		jiraDataRetrieveImpl.resetOriginalValues();

		return jiraDataRetrieveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraDataRetrieveId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readUTF();
		statusDescription = objectInput.readUTF();
		day = objectInput.readInt();
		month = objectInput.readInt();
		year = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraDataRetrieveId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (statusDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusDescription);
		}

		objectOutput.writeInt(day);
		objectOutput.writeInt(month);
		objectOutput.writeInt(year);
	}

	public long jiraDataRetrieveId;
	public long createDate;
	public long modifiedDate;
	public String status;
	public String statusDescription;
	public int day;
	public int month;
	public int year;
}