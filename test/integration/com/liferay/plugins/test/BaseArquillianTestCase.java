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

package com.liferay.plugins.test;

import com.liferay.jira.metrics.client.JiraClientImpl;
import com.liferay.jira.metrics.client.MockJiraClientImpl;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

/**
 * @author Manuel de la Peña
 * @author Cristina González
 */
@RunWith(Arquillian.class)
public abstract class BaseArquillianTestCase {

	@Deployment
	public static Archive<?> getGetDeployment() throws IOException {
		try {
			_temporaryFolder = new TemporaryFolder();

			_temporaryFolder.create();

			_temporaryFolderRoot = _temporaryFolder.getRoot();

			Project antProject = configureAntProject();

			antProject.executeTarget(
				LiferayPluginsBuildConstants.TARGET_DIRECT_DEPLOY);

			String pluginName =
				antProject.getProperty(
					LiferayPluginsBuildConstants.PROPERTY_PLUGIN_NAME);

			pluginName += LiferayPluginsBuildConstants.EXTENSION_WAR;

			File warFile = new File(
				_temporaryFolderRoot.getAbsolutePath(), pluginName);

			WebArchive webArchive = ShrinkWrap.createFromZipFile(
				WebArchive.class, warFile);

			mockJiraSpringConfig(webArchive);

			return webArchive;
		}
		finally {
			_temporaryFolder.delete();
		}
	}

	protected static Project configureAntProject() {
		File buildFile = new File(
			LiferayPluginsBuildConstants.BUILD_XML_FILE_NAME);

		Project project = new Project();

		project.setUserProperty(
			LiferayPluginsBuildConstants.PROPERTY_ANT_FILE,
			buildFile.getAbsolutePath());

		project.init();

		ProjectHelper projectHelper = ProjectHelper.getProjectHelper();

		project.addReference(
			LiferayPluginsBuildConstants.PROPERTY_ANT_PROJECTHELPER,
			projectHelper);

		projectHelper.parse(project, buildFile);

		project.setProperty(
			LiferayPluginsBuildConstants.PROPERTY_APP_SERVER_DEPLOY_DIR,
			_temporaryFolderRoot.getAbsolutePath());

		project.setProperty(
			LiferayPluginsBuildConstants.PROPERTY_AUTO_DEPLOY_UNPACK_WAR,
			"false");

		return project;
	}

	protected static void mockJiraSpringConfig(WebArchive webArchive) {
		Node jiraSpringFile = webArchive.get(
			"/WEB-INF/classes/META-INF/jira-spring.xml");

		webArchive.addClass(BaseArquillianTestCase.class);

		webArchive.delete(jiraSpringFile.getPath());

		webArchive.deleteClass(JiraClientImpl.class);

		webArchive.addClass(MockJiraClientImpl.class);

		File jiraSpringMockFile = new File(
			"./test/integration/" +
				"META-INF/jira-spring.xml");

		webArchive.addAsWebResource(
			jiraSpringMockFile, "/WEB-INF/classes/META-INF/jira-spring.xml");
	}

	private static TemporaryFolder _temporaryFolder;
	private static File _temporaryFolderRoot;

}