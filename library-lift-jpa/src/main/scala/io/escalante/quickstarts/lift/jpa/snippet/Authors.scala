/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package io.escalante.quickstarts.lift.jpa.snippet

import scala.xml.Text
import scala.collection.JavaConversions._
import javax.validation.ConstraintViolationException
import net.liftweb.common.{Failure,Full}
import net.liftweb.util.Helpers._
import net.liftweb.http.{RequestVar,SHtml,S}
import io.escalante.quickstarts.lift.jpa.{Model, Log, Author}

/**
 * Authors.
 *
 * @author Galder Zamarreño
 * @since 1.0
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/timperrett/lift-in-action">
 *        Lift In Action book</a>
 */
object Authors {
  object authorVar extends RequestVar(new Author)
}

class Authors extends Log {
  import Authors._
  def author = authorVar.is

  def list = {
    val sel = "tr" #> Model.createNamedQuery[Author]("findAllAuthors").getResultList().map {
      a =>
        ".name" #> a.name &
          ".books" #> SHtml.link("/books/add",
            () => authorVar(a),
            Text("%s books (Add more)".format(a.books.size))) &
          ".edit" #> SHtml.link("add", () => authorVar(a), Text("Edit"))
    }
    sel
  }

  def add = {
    val current = author
    "type=hidden" #> SHtml.hidden(() => authorVar(current)) &
    "type=text" #> SHtml.text(author.name, author.name = _) &
    "type=submit" #> SHtml.onSubmitUnit(() =>
      tryo(Model.mergeAndFlush(author)) match {
        case Failure(msg,Full(err: ConstraintViolationException),_) => 
          S.error(err.getConstraintViolations.toList.flatMap(c => <p>{c.getMessage}</p>))
        case Failure(msg,Full(err: Throwable),_) =>
          error(err, "Unable to store author")
          S.error(err.toString)
        case _ => S.redirectTo("index")
      })
  }

}
