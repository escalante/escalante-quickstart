import sbt._
import sbt.Keys._
import io.escalante.sbt.EscalantePlugin._
import io.escalante.sbt.EscalantePlugin.EscalanteKeys._

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

escalanteSettings

liftWarName in liftWar := "escalante-persistence-lift.war"

liftVersion in liftWar := Some("2.4")

libraryDependencies <++= (liftVersion in liftWar) { lv: Option[String] => Seq(
    "net.liftweb" %% "lift-webkit" % lv.get % "provided",
    "net.liftweb" %% "lift-mapper" % lv.get % "provided"
  )
}
