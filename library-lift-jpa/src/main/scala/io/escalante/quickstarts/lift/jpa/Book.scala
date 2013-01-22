/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package io.escalante.quickstarts.lift.jpa

import java.util.Date
import javax.persistence._
import javax.validation.constraints.Size

/**
 * Book entity.
 *
 * @author Galder Zamarreño
 * @since 1.0
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/timperrett/lift-in-action">
 *        Lift In Action book</a>
 */
@NamedQueries(Array(
  new NamedQuery(
    name = "findBooksByAuthor",
    query = "from Book b where b.author.id = :id order by b.title")
))
@Entity
class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id : Long = _
  
  @Size(min = 3, max = 60)
  @Column(unique = true, nullable = false)
  var title : String = ""
  
  @Temporal(TemporalType.DATE)
  @Column(nullable = true)
  var published : Date = new Date()
  
  @ManyToOne(optional = false)
  var author : Author = _
}
