package models.services

import models.ElementType
import models.GameId

trait BoardElementManager {

  def removeAdaptationElement(gameId: GameId, element: ElementType)

}