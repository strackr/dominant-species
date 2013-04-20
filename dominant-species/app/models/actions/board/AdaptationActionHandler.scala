package models.actions.board

import models.AnimalType
import models.Game
import models.actions.ActivityHandler
import models.actions.SelectAdaptationRequest
import models.actions.SelectAdaptationHandler
import models.ElementType
import models.Animal
import models.IllegalGameStateException

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

class SelectAdaptationActionHandler extends SelectAdaptationHandler {

  override def execute(game: Game, animalType: AnimalType, selected: ElementType) = {
    // TODO complete adaptation selection
    None
  }

}
