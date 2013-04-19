package models.actions

import models.AnimalType
import models.Game

trait ConfirmActionHandler {

  def execute(game: Game, animalType: AnimalType, confirmed: Boolean): Option[ActivityRequest]

}