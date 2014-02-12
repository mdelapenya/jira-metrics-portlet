create table jirametrics_JiraComponent (
	jiraComponentId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	uri VARCHAR(75) null,
	jiraProjectId LONG,
	name VARCHAR(75) null,
	status INTEGER
);

create table jirametrics_JiraMetric (
	jiraMetricId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	jiraProjectId LONG,
	jiraComponentId LONG,
	jiraStatusId LONG,
	priority INTEGER,
	day INTEGER,
	month INTEGER,
	year INTEGER,
	total INTEGER
);

create table jirametrics_JiraProject (
	jiraProjectId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	name VARCHAR(75) null
);

create table jirametrics_JiraStatus (
	jiraStatusId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	jiraStatusCode LONG,
	jiraProjectId LONG,
	name VARCHAR(75) null
);