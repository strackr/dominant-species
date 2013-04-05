package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html
import play.api.i18n.Messages

object Application extends Controller {

  def index = Action {
    val welcome = Messages("application.welcome")
    Ok(views.html.index(Html(welcome)))
  }

  def game(id: String) = Action {
    val title = Messages("application.name")
    val welcome = Messages("game.welcome", id)
    Ok(views.html.main(title)(Html(welcome)))
  }

}