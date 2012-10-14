package io.escalante.quickstarts.scaladin.helloworld

import vaadin.scala._
import java.util.Date

class HelloWorldApp extends Application {

  override val main = new VerticalLayout {
    margin = true
    components += new Label {
      contentMode = Label.ContentMode.Xhtml
      value = "Hello World from <b>Escalante</b> at %s".format(new Date)
    }
  }
}