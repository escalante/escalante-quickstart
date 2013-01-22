/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package io.escalante.quickstarts.lift.jpa.snippet

import scala.collection.JavaConversions._
import javax.validation.ConstraintViolationException
import net.liftweb.common.{Failure,Full}
import net.liftweb.util.Helpers._
import net.liftweb.http.{RequestVar,SHtml,S}
import io.escalante.quickstarts.lift.jpa.{Model, Author, Book}

/**
 * Books.
 *
 * @author Galder Zamarreño
 * @since 1.0
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/timperrett/lift-in-action">
 *        Lift In Action book</a>
 */
class Books {
  object bookVar extends RequestVar(new Book)
  def book = bookVar.is
  lazy val formatter = new java.text.SimpleDateFormat("yyyy-MM-dd")
  
  def add = {
    val current = book
    val authors = Model.createNamedQuery[Author]("findAllAuthors").getResultList()
    val choices = authors.map(author => (author.id.toString -> author.name)).toList
    val default = Full(Authors.authorVar.is.id.toString)
    
    "type=hidden" #> SHtml.hidden(() => bookVar(current)) &
    "name=title" #> SHtml.text(book.title, book.title = _) &
    "name=published" #> SHtml.text(formatter.format(book.published), v => book.published = formatter.parse(v)) &
    "#author" #> SHtml.select(choices, default, {authId : String => book.author = Model.getReference(classOf[Author], authId.toLong)}) &
    "type=submit" #> SHtml.onSubmitUnit(() =>
      tryo(Model.mergeAndFlush(book)) match {
        case Failure(msg,Full(err: ConstraintViolationException),_) => 
          S.error(err.getConstraintViolations.toList.flatMap(c => <p>{c.getMessage}</p>)) 
        case _ => S.redirectTo("/authors/")
      })
  }    
}