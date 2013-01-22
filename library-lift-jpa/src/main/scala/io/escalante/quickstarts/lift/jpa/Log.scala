package io.escalante.quickstarts.lift.jpa

import org.jboss.logging.Logger

/**
 * Logging interface.
 *
 * @author Galder Zamarreño
 * @since 1.0
 */
trait Log {

   private lazy val log = Logger.getLogger(getClass.getPackage.getName)

   def error(t: Throwable, msg: => String) {
      log.errorf(t, msg)
   }

}
