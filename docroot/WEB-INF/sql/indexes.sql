create unique index IX_3ACBB661 on jirametrics_JiraComponent (jiraComponentCode);
create index IX_BBC84FEB on jirametrics_JiraComponent (jiraProjectId);
create unique index IX_2DBA0D6A on jirametrics_JiraComponent (name);

create index IX_C13FF376 on jirametrics_JiraMetric (jiraProjectId, jiraComponentId, jiraStatusId, day, month, year);
create unique index IX_FA8763CE on jirametrics_JiraMetric (jiraProjectId, jiraComponentId, jiraStatusId, priority, day, month, year);

create unique index IX_2F622F21 on jirametrics_JiraProject (jiraProjectCode);
create unique index IX_37B0B9B on jirametrics_JiraProject (key_);
create unique index IX_98B8D7BD on jirametrics_JiraProject (label);
create unique index IX_85BD986 on jirametrics_JiraProject (name);

create index IX_78A8CF66 on jirametrics_JiraStatus (jiraProjectId);
create unique index IX_C6E90151 on jirametrics_JiraStatus (jiraStatusCode);
create unique index IX_1E34278F on jirametrics_JiraStatus (name);