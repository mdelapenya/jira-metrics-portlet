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

import com.liferay.jira.metrics.model.JiraMetric;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JiraMetric in entity cache.
 *
 * @author Manuel de la Peña
 * @see JiraMetric
 * @generated
 */
public class JiraMetricCacheModel implements CacheModel<JiraMetric>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{jiraMetricId=");
		sb.append(jiraMetricId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", jiraProjectId=");
		sb.append(jiraProjectId);
		sb.append(", jiraComponentId=");
		sb.append(jiraComponentId);
		sb.append(", jiraStatusId=");
		sb.append(jiraStatusId);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", day=");
		sb.append(day);
		sb.append(", month=");
		sb.append(month);
		sb.append(", year=");
		sb.append(year);
		sb.append(", total=");
		sb.append(total);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JiraMetric toEntityModel() {
		JiraMetricImpl jiraMetricImpl = new JiraMetricImpl();

		jiraMetricImpl.setJiraMetricId(jiraMetricId);

		if (createDate == Long.MIN_VALUE) {
			jiraMetricImpl.setCreateDate(null);
		}
		else {
			jiraMetricImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jiraMetricImpl.setModifiedDate(null);
		}
		else {
			jiraMetricImpl.setModifiedDate(new Date(modifiedDate));
		}

		jiraMetricImpl.setJiraProjectId(jiraProjectId);
		jiraMetricImpl.setJiraComponentId(jiraComponentId);
		jiraMetricImpl.setJiraStatusId(jiraStatusId);
		jiraMetricImpl.setPriority(priority);
		jiraMetricImpl.setDay(day);
		jiraMetricImpl.setMonth(month);
		jiraMetricImpl.setYear(year);
		jiraMetricImpl.setTotal(total);

		jiraMetricImpl.resetOriginalValues();

		return jiraMetricImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jiraMetricId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		jiraProjectId = objectInput.readLong();
		jiraComponentId = objectInput.readLong();
		jiraStatusId = objectInput.readLong();
		priority = objectInput.readInt();
		day = objectInput.readInt();
		month = objectInput.readInt();
		year = objectInput.readInt();
		total = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jiraMetricId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(jiraProjectId);
		objectOutput.writeLong(jiraComponentId);
		objectOutput.writeLong(jiraStatusId);
		objectOutput.writeInt(priority);
		objectOutput.writeInt(day);
		objectOutput.writeInt(month);
		objectOutput.writeInt(year);
		objectOutput.writeInt(total);
	}

	public long jiraMetricId;
	public long createDate;
	public long modifiedDate;
	public long jiraProjectId;
	public long jiraComponentId;
	public long jiraStatusId;
	public int priority;
	public int day;
	public int month;
	public int year;
	public int total;
}