package io.escalante.quickstarts.scaladin.editor

import javax.servlet.annotation.WebServlet
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet
import javax.servlet.http.HttpServletRequest

import vaadin.scala._

/**
 * Alternative for using web.xml.
 *
 * With Scaladin you really don't need any XML.
 */
@WebServlet(urlPatterns = Array("/*"))
class EditorServlet extends AbstractApplicationServlet {

  override def getApplicationClass(): Class[Editor] = classOf[Editor]

  def getNewApplication(request: HttpServletRequest): Editor = new Editor
}