# helloworld-play: Hello World Play Example

Author: Galder Zamarreño

## What is it?

This example demonstrates the use of *Play 2.x* Scala web framework in Escalante,
with a simple web application displaying a "Hello (Escalante) Play!" message.

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
<http://localhost:9000/escalante-helloworld-play>, where you should see a
message saying: "Hello (Escalante) Play!"

## Logging

To change logging levels on Escalante, please provide
`-Djava.util.logging.config.file=[PATH-TO]/escalante-logging.properties`
parameter to the command running SBT.