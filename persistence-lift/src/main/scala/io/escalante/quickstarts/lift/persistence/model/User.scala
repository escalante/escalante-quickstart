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
package io.escalante.quickstarts.lift.persistence.model

import net.liftweb.common.Full
import net.liftweb.mapper.{MappedTextarea, MegaProtoUser, MetaMegaProtoUser}

/**
 * The singleton that has methods for accessing the database
 *
 * @author Galder Zamarreño
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/lift/lift_24_sbt">Lift project templates</a>
 */
object User extends User with MetaMegaProtoUser[User] {

   override def dbTableName = "users"

   // define the DB table name
   override def screenWrap = Full(<lift:surround with="default" at="content">
         <lift:bind/>
   </lift:surround>)

   // define the order fields will appear in forms and output
   override def fieldOrder = List(id, firstName, lastName, email,
      locale, timezone, password, textArea)

   // comment this line out to require email validations
   override def skipEmailValidation = true
}

/**
 * An O-R mapped "User" class that includes first name, last name, password.
 *
 * @author Galder Zamarreño
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/lift/lift_24_sbt">Lift project templates</a>
 */
class User extends MegaProtoUser[User] {

   def getSingleton = User

   // what's the "meta" server

   // define an additional field for a personal essay
   object textArea extends MappedTextarea(this, 2048) {

      override def textareaRows = 10

      override def textareaCols = 50

      override def displayName = "Galder Zamarreño"

   }

}

