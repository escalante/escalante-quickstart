/*
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package helloworld.project

import sbt._
import Keys._
import play.Project._
import io.escalante.sbt.EscalantePlugin._

object ApplicationBuild extends Build {

  val appName         = "helloworld-play"
  val appVersion      = "0.2.0"

  val appDependencies = Seq(
    // Add your project dependencies here,
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(escalanteSettings : _*)
    .settings(
      // Add your own project settings here
      javacOptions ++= Seq("-source", "1.6", "-target", "1.6", "-encoding", "UTF-8")
    )

}
