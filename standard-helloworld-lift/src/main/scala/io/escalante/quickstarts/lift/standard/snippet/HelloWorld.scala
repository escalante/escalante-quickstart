package io.escalante.quickstarts.lift.standard.snippet

/**
 * Hello world example.
 *
 * @author Galder Zamarreño
 * @since 1.0
 */
class HelloWorld {

   def howdy =
      <span>
         Hello World from
         <b>Escalante</b>
         !
            <br/>
         The date is:
         {new _root_.java.util.Date}
      </span>

}
