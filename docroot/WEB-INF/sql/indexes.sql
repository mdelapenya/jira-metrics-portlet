create index IX_BBC84FEB on jirametrics_JiraComponent (jiraProjectId);
create index IX_82250E8C on jirametrics_JiraComponent (name, jiraProjectId);
create unique index IX_3BB25991 on jirametrics_JiraComponent (uri);

create index IX_D10324B9 on jirametrics_JiraDataRetrieve (day, month, year);
create index IX_3DAF921F on jirametrics_JiraDataRetrieve (status, day, month, year);

create index IX_C13FF376 on jirametrics_JiraMetric (jiraProjectId, jiraComponentId, jiraStatusId, day, month, year);
create unique index IX_57C1197 on jirametrics_JiraMetric (jiraProjectId, jiraComponentId, jiraStatusId, jiraPriorityId, day, month, year);
create unique index IX_FA8763CE on jirametrics_JiraMetric (jiraProjectId, jiraComponentId, jiraStatusId, priority, day, month, year);

create unique index IX_2D34B941 on jirametrics_JiraPriority (name);
create unique index IX_208E569F on jirametrics_JiraPriority (value);

create unique index IX_37B0B9B on jirametrics_JiraProject (key_);
create unique index IX_85BD986 on jirametrics_JiraProject (name);

create unique index IX_1E34278F on jirametrics_JiraStatus (name);
create unique index IX_1A29E6CC on jirametrics_JiraStatus (uri);