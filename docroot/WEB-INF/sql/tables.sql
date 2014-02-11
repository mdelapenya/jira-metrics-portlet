create table jirametrics_JiraComponent (
	jiraComponentId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	jiraComponentCode LONG,
	jiraProjectId LONG,
	name VARCHAR(75) null,
	status INTEGER
);

create table jirametrics_JiraMetric (
	jiraMetricId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
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
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	label VARCHAR(75) null,
	jiraProjectCode LONG
);

create table jirametrics_JiraStatus (
	jiraStatusId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	jiraStatusCode LONG,
	jiraProjectId LONG,
	name VARCHAR(75) null
);