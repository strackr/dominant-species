package models.actions.board

import models.ActionReservation
import models.AnimalType
import models.Game
import models.IllegalGameStateException
import models.InitiativeAction
import models.actions.ActivityHandler
import models.actions.ConfirmActionHandler
import models.actions.ConfirmActionRequest
import models.actions.SelectActionHandler
import models.actions.SelectActionRequest
import models.services.ActionManager
import models.services.InitiativeManager

class InitiativeActionHandler extends ActivityHandler {

  override def execute(game: Game, animalType: AnimalType) = {
    val nextAction = classOf[ConfirmInitiativeActionHandler]
    Some(ConfirmActionRequest(nextAction))
  }

}

class ConfirmInitiativeActionHandler(initiativeManager: InitiativeManager)
    extends ConfirmActionHandler {

  override def execute(game: Game, animalType: AnimalType, confirmed: Boolean) = {
    if (confirmed) {
      initiativeManager.advanceInitiative(game.id, animalType)

      val availableActions = game.availableActions - ActionReservation(InitiativeAction)
      val nextAction = classOf[SelectActionFromInitiativeHandler]
      Some(SelectActionRequest(availableActions, nextAction))
    } else {
      None
    }
  }

}

class SelectActionFromInitiativeHandler(actionManager: ActionManager)
    extends SelectActionHandler {

  override def execute(game: Game, animalType: AnimalType, selected: ActionReservation) = {
    if (game.availableActions.contains(selected)) {
      actionManager.reserveAction(game.id, animalType, selected)
    } else {
      throw new IllegalGameStateException(s"action $selected is not available for selection")
    }
    None
  }

}

