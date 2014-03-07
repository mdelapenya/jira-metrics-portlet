# JIRA Metrics Portlet

## Motivation

More and more often, development teams managers need to monitor current status of their projects based on some metrics defined by themselves.

JIRA is a proprietary issue tracking product, developed by Atlassian, used for bug tracking, issue tracking and project management.

As JIRA provides many metrics by itself, we've decided to start a [Liferay](http://www.liferay.com) + [AlloyUI](http://www.alloyui.com) + [Jira](https://www.atlassian.com/software/jira) integration portlet that allows to display some customized metrics in an easy and portal-deployable way. For that, a Liferay portal Admin, can deploy this portlet in his/her portal, allowing its users to watch metrics and stats defined, in an user-friendly style, using AlloyUI built-in cappabilities.

## Configuration

Placeholder for configuration

## Testing

For testing purpose, we are using [Arquillian](http://arquillian.org), which builds the plugin and deploys it to the server. retrieving test results to the test client that executed the tests (console or IDE). If you want to configure this, you must:

- Change build.xml from plugins SDK, enabling IVY to download transitive dependencies.
- Change build-common-plugin.xml from plugins SDK, more concretely the 'test-cmd' target, removing the 'dir' attribute.
- Compile the project, so that IVY downloads all the dependencies.
- Make your test classes extend BaseArquillianTestCase, base test class that performs all the 'magic' to build the plugin and deploys to a remote server
- Enable JMX on the Tomcat app server you use with your SDK (If you use another app server, please see arquillian dependencies on ivy.xml file, and update it): **-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=8099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false** (Please see arquillian.xml file under test folder to verify that JMX Port is correctly set)
- Add the 'manager' application for Tomcat, adding, in example, a 'tomcat' user with password 'tomcat' (Please see arquillian.xml file under test folder)

## v.1.0.0

Placeholder for related work

## License

This library, "JIRA Metrics Portlet", is free software ("Licensed Software"); you can redistribute it and/or modify it under the terms of the [GNU Lesser General Public License](http://www.gnu.org/licenses/lgpl-2.1.html) as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; including but not limited to, the implied warranty of MERCHANTABILITY, NONINFRINGEMENT, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

You should have received a copy of the [GNU Lesser General Public License](http://www.gnu.org/licenses/lgpl-2.1.html) along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
