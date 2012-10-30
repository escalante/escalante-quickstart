package io.escalante.quickstarts.scaladin.editor

import scala.reflect.BeanProperty
import scala.util.Random

import vaadin.scala._

/**
 * Example app with a list of beans, a table to show the beans and a form to edit them
 */
class Editor extends Application("Escalante Scaladin Quickstart: registration editor") {

  //replace with any kind of datasource that provides a collection of beans
  var registrations: List[Registration] = List.empty
  def saveRegistration(registration: Registration): Unit = registrations = registration :: registrations

  override val main: ComponentContainer = new VerticalLayout {
    sizeFull()
    styleName = Reindeer.LayoutWhite

    //button and a table for showing the bean list
    val tableLayout = new VerticalLayout {
      size(50 pct, 50 pct)
      spacing = true

      val table = new Table {
        sizeFull()
        styleNames += Reindeer.TableStrong
        container = new BeanItemContainer(registrations)
        visibleColumns = Seq("username", "realName")
      }

      val addButton = Button("Register", showForm)
      components += (table, addButton)
    }

    //form for showing the fields of a bean
    lazy val form = new Form {
      size(50 pct, 50 pct)
      caption = "Registration"
      writeThrough = false
      formFieldFactory = registrationFormFieldFactory
      footer = new HorizontalLayout {
        components += Button("Save", showList)
      }
    }

    components += tableLayout
    alignment(tableLayout -> Alignment.MiddleCenter)

    def showForm(): Unit = {
      form.item = new BeanItem(Registration())
      form.visibleItemProperties = Seq("realName", "username", "password")
      form.addField(Option("confirmation"), form.formFieldFactory.flatMap(_.createField(FormFieldIngredients(form.item.get, "confirmation", form))))
      replaceComponent(tableLayout, form)
      alignment(form -> Alignment.MiddleCenter)
    }

    def showList(): Unit = {
      if (form.commit.isValid) { //form handles error
        val bean = form.item.get.asInstanceOf[BeanItem[Registration]].bean
        saveRegistration(bean)
        tableLayout.table.container = new BeanItemContainer(registrations)
        tableLayout.table.visibleColumns = Seq("username", "realName")
        replaceComponent(form, tableLayout)
        alignment(tableLayout -> Alignment.MiddleCenter)
        mainWindow.showNotification("User %s registered".format(bean.username))
      }
    }
  }

  //customize the password and password confirmation fields
  val registrationFormFieldFactory = FormFieldFactory(ing => {
    var field: Option[Field] = ing match {
      case FormFieldIngredients(_, "password", _) =>
        Some(new PasswordField {
          caption = DefaultFieldFactory.createCaptionByPropertyId("password")
        })

      case FormFieldIngredients(_, "confirmation", form: Form) =>
        Some(new PasswordField {
          caption = "Confirm password"
          validators += Validator(value =>
            if (value == form.field("password").get.value) Valid
            else Invalid(List("Passwords must match")))
        })

      case otherIngredient => {
        DefaultFieldFactory.createField(otherIngredient)
      }
    }

    field.foreach(_.required = true)
    field.foreach(f => f.requiredError = "%s is required".format(f.caption.get))
    field
  })
}

//simple case class bean
//@BeanProperty is required for BeanItemContainer since it uses Java reflection to scan the fields
case class Registration(
  @BeanProperty var username: String = "username" + Random.nextInt,
  @BeanProperty var password: String = "",
  @BeanProperty var realName: String = "Joe Tester")