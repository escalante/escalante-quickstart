/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package io.escalante.quickstarts.lift.jpa

import org.scala_libs.jpa.JndiEMF
import net.liftweb.jpa.RequestVarEM
import javax.persistence.{EntityManagerFactory, EntityManager}

/**
 * Model.
 *
 * @author Galder Zamarreño
 * @since 1.0
 * @see This code is based on sample code provided in the
 *      <a href="https://github.com/timperrett/lift-in-action">
 *        Lift In Action book</a>
 */
class Model {
  // Required so that classOf[Model] can work
}

object Model extends JndiEMF("LiftEntityManagerFactory") with RequestVarEM {

  /**
   * Open entity manager by looking up the EntityManagerFactory
   * (as opposed to the EntityManager) via JNDI.
   *
   * @return EntityManager retrieved from EntityManagerFactory bound to JNDI
   */
  override def openEM(): EntityManager = {
    // JNDI EMs want an existing JTA transaction
    tx.begin()
    // Lookup entity manager via JNDI bound EntityManagerFactory
    ctxt.lookup(jndiName).asInstanceOf[EntityManagerFactory]
      .createEntityManager()
  }

}
