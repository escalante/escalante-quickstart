# editor-scaladin: Bean editor Scaladin Example

Author: Risto Yrjänä / Vaadin

## What is it?

This example demonstrates the use of the *Vaadin* web framework with the
*Scaladin* add-on in Escalante. The application is a simple bean list +
editor in about 100 LOC.

The war file contains all the required dependencies: Vaadin, Scaladin and
the Scala library.

## System requirements

The example can be deployed using Maven from the command line or from Eclipse
using JBoss Tools or JBoss Developer Studio.

To set up Maven or JBoss Tools in Eclipse, refer to the
[Getting Started Developing Applications Guide](https://docs.jboss.org/author/display/AS71/Getting+Started+Developing+Applications+Guide)

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
5. Click `Next` twice and add `escalante-editor-scaladin` application to the server
6. Click `Finish` in the wizard
7. Right-click on the Escalante server and click `Start`
8. Check the the application is deployed to
<http://localhost:8080/escalante-editor-scaladin>

### Maven

To deploy the application to Escalante using Maven:

1. Start the Escalante from the command line
2. From the root of this maven project, type:
`mvn clean package jboss-as:deploy`
3. Check the the application is deployed to
<http://localhost:8080/escalante-editor-scaladin>.