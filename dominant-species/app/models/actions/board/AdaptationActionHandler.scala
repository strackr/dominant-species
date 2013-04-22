package models.actions.board

import models.AnimalType
import models.Game
import models.actions.ActivityHandler
import models.actions.SelectAdaptationRequest
import models.actions.SelectElementHandler
import models.ElementType
import models.Animal
import models.IllegalGameStateException
import models.services.AnimalManager
import models.services.BoardElementManager

class AdaptationActionHandler extends ActivityHandler {

  override def execute(game: Game, animalType: AnimalType) = {
    game.animals.get(animalType) match {
      case Some(animal) => {
        if (animal.elementsNumber < animal.elementsCapacity) {
          val nextAction = classOf[SelectAdaptationActionHandler]
          Some(SelectAdaptationRequest(nextAction))
        } else {
          None
        }
      }
      case None => throw new IllegalGameStateException(s"animal $animalType does not exist")
    }
  }

}

class SelectAdaptationActionHandler(
  animalManager: AnimalManager,
  boardElementManager: BoardElementManager)
    extends SelectElementHandler {

  override def execute(game: Game, animalType: AnimalType, selected: ElementType) = {
    game.animals.get(animalType) match {
      case Some(animal) => {
        val animalCanAddapt = animal.elementsNumber < animal.elementsCapacity
        val elementExists = game.adaptationElements.getOrElse(selected, 0) > 0
        if (animalCanAddapt && elementExists) {
          animalManager.addElement(game.id, animalType, selected)
          boardElementManager.removeAdaptationElement(game.id, selected)
        } else {
          throw new IllegalGameStateException(s"animal $animalType cannot adapt to element $selected")
        }
      }
      case None => throw new IllegalGameStateException(s"animal $animalType does not exist")
    }
    None
  }

}
