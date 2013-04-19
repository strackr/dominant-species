package models.actions

import models.AnimalType
import models.Game

trait ActivityHandler {

  def execute(game: Game, animalType: AnimalType): Option[ActivityRequest]

}