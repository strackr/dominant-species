package models.services

import models.ActionReservation
import models.AnimalType
import models.GameId
import models.ElementType

trait AnimalManager {

  def addElement(gameId: GameId, animal: AnimalType, element: ElementType);

}