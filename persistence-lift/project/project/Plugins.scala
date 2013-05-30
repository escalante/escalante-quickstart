import sbt._
import Keys._

object Plugins extends Build {

  lazy val pluginProject = Project("plugins", file(".")).settings(
    resolvers ++= Seq(
      "JBoss repository" at "http://repository.jboss.org/nexus/content/groups/public/",
      "Project Odd repository" at "http://repository-projectodd.forge.cloudbees.com/upstream/")
  ).dependsOn(sbtEscalante)

  lazy val sbtEscalante = uri("git://github.com/escalante/sbt-escalante.git#0.2.0")
}