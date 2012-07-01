persistence-lift: Persistence Lift Example
========================================
Author: Galder Zamarreño

What is it?
-----------

This example demonstrates the use of *Lift* ORM model which interacts with
JBoss' example datasource. This quickstart uses an older Scala version (2.8)
on purpouse to demonstrate that multiple versions of Scala are supported.

System requirements
-------------------

The example can be deployed using Maven from the command line or from Eclipse
using JBoss Tools.

To set up Maven or JBoss Tools in Eclipse, refer to the
<a href="https://docs.jboss.org/author/display/AS71/Getting+Started+Developing+Applications+Guide"
title="Getting Started Developing Applications Guide">Getting Started Developing Applications Guide</a>.

Deploying the application
-------------------------

To deploy the application to Escalante using Maven, start the Escalante and type

    mvn package jboss-as:deploy

The application is deployed to <http://localhost:8080/escalante-persistence-lift>.

Using the application
---------------------

# To use the application, click on 'Sign Up' and fill in the details.
# Once signed up, change your password to 'escalante'
# Now, click on 'Logout' and then click on 'Login' and enter username and new password