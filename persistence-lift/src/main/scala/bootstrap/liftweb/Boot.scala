/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bootstrap.liftweb

import io.escalante.quickstarts.lift.persistence.model.User
import net.liftweb.sitemap.{Loc, Menu, SiteMap}
import net.liftweb.sitemap.Loc.Link
import net.liftweb.common.Full
import net.liftweb.http._
import net.liftweb.mapper.{DB, Schemifier}
import net.liftweb.db.DefaultConnectionIdentifier

/**
 * Boot class for Lift model, HTML 5, application
 *
 * @author Galder Zamarreño
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/lift/lift_24_sbt">Lift project templates</a>
 */
class Boot extends Bootable {

   def boot() {
      // JBoss AS7 default datasource jndi name
      DefaultConnectionIdentifier.jndiName = "java:jboss/datasources/ExampleDS"

      // Use Lift's Mapper ORM to populate the database
      // you don't need to use Mapper to use Lift... use
      // any ORM you want
      Schemifier.schemify(true, Schemifier.infoF _, User)

      // where to search snippet
      LiftRules.addToPackages("io.escalante.quickstarts.lift.persistence")

      // Build SiteMap
      def sitemap = SiteMap(
         Menu.i("Home") / "index" >> User.AddUserMenusAfter, // the simple way to declare a menu

         // more complex because this menu allows anything in the
         // /static path to be visible
         Menu(Loc("Static", Link(List("static"), true, "/static/index"),
            "Static Content")))

      def sitemapMutators = User.sitemapMutator

      // set the sitemap.  Note if you don't want access control for
      // each page, just comment this line out.
      LiftRules.setSiteMapFunc(() => sitemapMutators(sitemap))

      // Use jQuery 1.4
      LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts

      //Show the spinny image when an Ajax call starts
      LiftRules.ajaxStart =
              Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

      // Make the spinny image go away when it ends
      LiftRules.ajaxEnd =
              Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

      // Force the request to be UTF-8
      LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

      // What is the function to test if a user is logged in?
      LiftRules.loggedInTest = Full(() => User.loggedIn_?)

      // Use HTML5 for rendering
      LiftRules.htmlProperties.default.set((r: Req) =>
         new Html5Properties(r.userAgent))

      // Make a transaction span the whole HTTP request
      S.addAround(DB.buildLoanWrapper)
   }

}
