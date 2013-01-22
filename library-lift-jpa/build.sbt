import sbt._
import sbt.Keys._
import io.escalante.sbt.EscalantePlugin._
import io.escalante.sbt.EscalantePlugin.EscalanteKeys._

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

escalanteSettings

liftWarName in liftWar := "escalante-library-lift-jpa.war"

liftVersion in liftWar := Some("2.4")

libraryDependencies <++= (liftVersion in liftWar) { lv: Option[String] => Seq(
    "net.liftweb" %% "lift-webkit" % lv.get % "provided",
    "net.liftweb" %% "lift-mapper" % lv.get % "provided",
    "net.liftweb" %% "lift-jpa" % lv.get % "provided"
  )
}

libraryDependencies ++= Seq(
  "org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final" % "provided",
  "javax.validation" % "validation-api" % "1.0.0.GA" % "provided",
  "org.jboss.spec.javax.transaction" % "jboss-transaction-api_1.1_spec" % "1.0.1.Final" % "provided",
  "org.jboss.logging" % "jboss-logging" % "3.1.2.GA" % "provided"
)
