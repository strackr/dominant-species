package models.actions

import models.ActionReservation
import models.AnimalType
import models.Game

trait SelectActionHandler {

  def execute(game: Game, animalType: AnimalType, selected: ActionReservation): Option[ActivityRequest]

}