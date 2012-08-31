persistence-lift: Persistence Lift Example
========================================
Author: Galder Zamarreño

What is it?
-----------

This example demonstrates the use of *Lift* ORM model which interacts with
Escalante's example datasource. This quickstart uses an older Scala version
(2.8) on purpouse to demonstrate that multiple versions of Scala are supported
in Escalante.

System requirements
-------------------

The example can be deployed using Maven from the command line or from Eclipse
using JBoss Tools or JBoss Developer Studio.

To set up Maven or JBoss Tools in Eclipse, refer to the
[Getting Started Developing Applications Guide](https://docs.jboss.org/author/display/AS71/Getting+Started+Developing+Applications+Guide)

If you're using Eclipse, or JBoss Developer Studio, a couple of extra steps
are required in order to be able to develop Scala applications. This particular
example is designed for Scala 2.8.x:

1. Install [Scala IDE](http://scala-ide.org/docs/user/gettingstarted.html)
using the [update site for Scala 2.8.x](http://download.scala-ide.org/releases-28/stable/site)
2. Install m2eclipse-scala via the [update site](http://alchim31.free.fr/m2e-scala/update-site)

Remember that multiple Scala IDE instances cannot be installed under the same
Eclipse, or JBoss Developer Studio, instance, so if you want to develop in
multiple Scala versions, you'll need to maintain separate Eclipse, or JBoss
Developer Studio instaces.

Deploying the application
-------------------------

To deploy the application to Escalante using Maven, start the Escalante and type

    mvn package jboss-as:deploy

The application is deployed to <http://localhost:8080/escalante-persistence-lift>.

Using the application
---------------------

1. To use the application, click on `Sign Up` and fill in the details.
2. Once signed up, change your password to `escalante`
3. Now, click on `Logout` and then click on `Login` and enter username
and new password