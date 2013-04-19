package models.services

import models.ActionReservation
import models.AnimalType
import models.GameId

trait ActionManager {

  def reserveAction(gameId: GameId, animal: AnimalType, action: ActionReservation);

}