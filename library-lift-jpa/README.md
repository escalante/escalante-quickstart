# library-lift-jpa: Library Lift JPA Example

Author: Galder Zamarreño

## What is it?

This example demonstrates the use of [*Lift*](http://liftweb.net/) Scala web
framework together with [JPA]
(http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html)
in order to maintain a virtual library.

The way Lift integrates with JPA is by deploying a persistence unit with an
[EntityManagerFactory](http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManagerFactory.html)
which is bound to [JNDI](http://www.oracle.com/technetwork/java/jndi/index.html)
, and with the application looking it up.

The library keeps track of books and their corresponding authors.

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
<http://localhost:8080/escalante-library-lift-jpa>

### Maven

To deploy the application to Escalante using Maven:

1. Install latest [Maven](http://maven.apache.org/download.cgi)
2. Download Escalante distribution and start from the command line:
`[$ESCALANTE_HOME]/bin/standalone.sh`
3. From the root of this maven project, type:
`mvn clean package jboss-as:deploy`
4. Check the the application is deployed to
<http://localhost:8080/escalante-library-lift-jpa>

### SBT

To deploy the application to Escalante using SBT (Simple Build Tool):

1. Install latest [SBT](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html)
2. From the root of the project, enter the SBT console executing: `sbt`
3. Once SBT console loaded, execute:
`> escalante-run`
4. Check the the application is deployed to
<http://localhost:8080/escalante-library-lift-jpa>

## Using the application

1. To use the application, click on `JPA: Authors: Add` and fill in the details.
2. Click on `Add more` to add a book for the author entered in previous step.
3. Give the book a title, i.e. `Escalante In Action` ;), and click `Submit`
4. You should now see a book assigned to the entered author.

## Using different Scala and/or Lift versions

This example can be tailored for other Scala versions by changing the required
Scala version in either the `pom.xml` or `build.sbt` file, and installing the
correct Scala IDE version. Remember to also need to adjust the Scala version
in the `META-INF/escalante.yml` descriptor.

This example can also be tailored for other Lift versions by changing the
required Lift version in either the `pom.xml` or `build.sbt` file.
Remember to also need to adjust the Lift version in the
`META-INF/escalante.yml` descriptor.

If you're only using SBT as build system, remember that there's no need to
maintain a `META-INF/escalante.yml` separately, since the Escalante SBT
plugin will generate it for you. Since these quickstarts are tailored for
both Maven and SBT, the file is already present, in which case the generated
descriptor is ignored, and the one under the source tree is used.

Note that some Scala versions might be more recent than Lift releases, so
there might not be Lift dependencies online for those Scala versions. Bear
that in mind when adjusting Scala/Lift versions.
