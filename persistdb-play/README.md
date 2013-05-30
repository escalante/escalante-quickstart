# persistdb-play: Persist to Database Play Example

Author: Galder Zamarreño

## What is it?

This example demonstrates the use of *Play 2.x* Scala web framework in Escalante
with an application that persists data to a database configured in
`conf/application.conf`.

## System requirements

The example is deployed using SBT. To set up, please refer to the latest
install guide for [SBT](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html)

## Deploying the application

### SBT

To deploy the application to Escalante using SBT (Simple Build Tool):

1. From the root of the project, enter the SBT console executing: `sbt`
2. Once SBT console loaded, execute:
`> escalante-run`
3. Check the application is deployed to
<http://localhost:9000/escalante-persistdb-play>

## Using the application

1. Create a new task giving it a name, e.g. "Deploy to Escalante"
and click on `Create` button. It should show that 1 task was added with name
specified. The task is stored in the database and the list presented is
retrieved from the database.
2. Click on `Delete` button to verify that the task can be deleted. After
clicking on the button, there should be 0 tasks.

## Logging

To change logging levels on Escalante, please provide
`-Djava.util.logging.config.file=[PATH-TO]/escalante-logging.properties`
parameter to the command running SBT.