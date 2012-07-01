helloworld-lift: Helloworld Lift Example
========================================
Author: Galder Zamarreño

What is it?
-----------

This example demonstrates the use of *Lift* Scala web framework and in Escalante
using the latest Scala version available.

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

The application is deployed to <http://localhost:8080/escalante-helloworld-lift>.