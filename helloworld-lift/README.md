# helloworld-lift: Hello World Lift Example

Author: Galder Zamarreño

## What is it?

This example demonstrates the use of *Lift* Scala web framework in Escalante
using the latest Scala version available.

## System requirements

The example can be deployed using Maven from the command line or from Eclipse
using JBoss Tools or JBoss Developer Studio.

To set up Maven or JBoss Tools in Eclipse, refer to the
[Getting Started Developing Applications Guide]
(https://docs.jboss.org/author/display/AS71/Getting+Started+Developing+Applications+Guide)

If you're using Eclipse, or JBoss Developer Studio,
[a couple of extra steps are required in order to be able to develop Scala applications]
(http://escalante.io/quickstarts/#jboss_developer_studio_for_scala_developers).

## Deploying the application

### JBoss Developer Studio

To deploy the application to Escalante using JBoss Developer Studio:

1. Import project into workspace
2. Go to `Servers` tab and click on `new server wizard`
3. Select `JBoss AS 7.1` and change `Server name` to: **Escalante**
4. Click `Next` and select the home directory of Escalante
5. Click `Next` twice and add `escalante-helloworld-lift` application to server
6. Click `Finish` in the wizard
7. Right-click on the Escalante server and click `Start`
8. Check the the application is deployed to
<http://localhost:8080/escalante-helloworld-lift>

### Maven

To deploy the application to Escalante using Maven:

1. Install latest [Maven](http://maven.apache.org/download.cgi)
2. Download Escalante distribution and start from the command line:
`[$ESCALANTE_HOME]/bin/standalone.sh`
3. From the root of this maven project, type:
`mvn clean package jboss-as:deploy`
4. Check the the application is deployed to
<http://localhost:8080/escalante-helloworld-lift>

### SBT

To deploy the application to Escalante using SBT (Simple Build Tool):

1. Install latest [SBT](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html)
2. From the root of the project, enter the SBT console executing: `sbt`
3. Once SBT console loaded, execute:
`> escalante-run`
4. Check the the application is deployed to
<http://localhost:8080/escalante-helloworld-lift>

## Using different Scala and/or Lift versions

This example can be tailored for other Scala versions by changing the required
Scala version in either the `pom.xml` or `build.sbt` file, and installing the
correct Scala IDE version. If using Maven or JBDS, you'll also need to adjust
the Scala version in the META-INF/escalante.yml descriptor. For SBT users,
this last step is not necessary because the Escalante SBT plugin generates
this descriptor file from the metadata information in `build.sbt` file.

This example can also be tailored for other Lift versions by changing the
required Lift version in either the `pom.xml` or `build.sbt` file.
If using Maven or JBDS, you'll also need to adjust the Lift version in the
`META-INF/escalante.yml descriptor`. For SBT users, this last step is not
necessary because the Escalante SBT plugin generates this descriptor file
from the metadata information in `build.sbt` file.

Note that some Scala versions might be more recent than Lift releases, so
there might not be Lift dependencies online for those Scala versions. Bear
that in mind when adjusting Scala/Lift versions.
