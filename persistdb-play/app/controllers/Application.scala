package controllers

import anorm._
import anorm.SqlParser._
import models.Task
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

}