package models.services

import models.AnimalType
import models.GameId

trait InitiativeManager {

  def advanceInitiative(gameId: GameId, animal: AnimalType)

}