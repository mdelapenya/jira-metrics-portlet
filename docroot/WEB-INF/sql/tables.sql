create table jirametrics_JiraComponent (
	jiraComponentId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	uri VARCHAR(75) null,
	jiraProjectId LONG,
	name VARCHAR(75) null,
	disabled BOOLEAN
);

create table jirametrics_JiraDataRetrieve (
	jiraDataRetrieveId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	status VARCHAR(75) null,
	statusDescription VARCHAR(75) null,
	day INTEGER,
	month INTEGER,
	year INTEGER
);

create table jirametrics_JiraMetric (
	jiraMetricId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	jiraProjectId LONG,
	jiraComponentId LONG,
	jiraStatusId LONG,
	jiraPriorityId LONG,
	day INTEGER,
	month INTEGER,
	year INTEGER,
	total INTEGER
);

create table jirametrics_JiraPriority (
	jiraPriorityId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	value VARCHAR(75) null,
	name VARCHAR(75) null
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
	uri VARCHAR(75) null,
	name VARCHAR(75) null
);