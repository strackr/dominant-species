package models.actions

import models.ActionReservation
import models.AnimalType
import models.Game
import models.ElementType

trait SelectAdaptationHandler {

  def execute(game: Game, animalType: AnimalType, selected: ElementType): Option[ActivityRequest]

}