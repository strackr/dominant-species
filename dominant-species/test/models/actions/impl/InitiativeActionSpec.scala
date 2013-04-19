package models.actions.impl

import org.specs2.mock.Mockito
import org.specs2.mutable.SpecificationWithJUnit

import models.AbundanceAction
import models.ActionReservation
import models.AnimalType
import models.Game
import models.GameId
import models.IllegalGameStateException
import models.InitiativeAction
import models.Mammal
import models.actions.ConfirmActionHandler
import models.actions.SelectActionHandler
import models.actions.SelectActionRequest
import models.services.ActionManager
import models.services.InitiativeManager

class InitiativeActionSpec extends SpecificationWithJUnit with Mockito {

  "initiative action handler" should {

    "request confirmation" in {
      val initiativeHandler = new InitiativeActionHandler
      val anyGame = mock[Game]
      val anyType = Mammal

      val request = initiativeHandler.execute(anyGame, anyType)

      val confirmRequest = request.get
      classOf[ConfirmActionHandler].isAssignableFrom(confirmRequest.forward) should beTrue
    }

  }

  "confirm initiative action handler" should {

    "do nothing when confirmation rejected" in {
      val initiativeManager = mock[InitiativeManager]
      val confirmationHandler = new ConfirmInitiativeActionHandler(initiativeManager)
      val anyGame = mock[Game]
      val anyType = Mammal

      val request = confirmationHandler.execute(anyGame, anyType, false)

      request should beNone
    }

    "advance initiative and request action selection when confirmed" in {
      // given
      val initiativeManager = mock[InitiativeManager]
      val confirmationHandler = new ConfirmInitiativeActionHandler(initiativeManager)

      val availableActions = Set(
        ActionReservation(InitiativeAction),
        ActionReservation(AbundanceAction, 0),
        ActionReservation(AbundanceAction, 1))
      val gameId = GameId(123L)
      val game = mock[Game]
      game.id returns gameId
      game.availableActions returns availableActions
      val playerType = Mammal

      // when
      val request = confirmationHandler.execute(game, playerType, true)

      // then
      val selectRequest = request.get.asInstanceOf[SelectActionRequest]
      selectRequest.availableActions must haveSize(2)
      selectRequest.availableActions must not contain (ActionReservation(InitiativeAction))
      classOf[SelectActionHandler].isAssignableFrom(selectRequest.forward) should beTrue

      there was initiativeManager.advanceInitiative(gameId, playerType)
    }

  }

  "select action handler" should {

    val availableActions = Set(ActionReservation(AbundanceAction, 1))
    val gameId = GameId(123L)
    val game = mock[Game]
    game.id returns gameId
    game.availableActions returns availableActions
    val playerType = Mammal

    "make reservation when action is available" in {
      // given
      val actionManager = mock[ActionManager]
      val selectHandler = new SelectActionFromInitiativeHandler(actionManager)

      val availableReservation = ActionReservation(AbundanceAction, 1)

      // when
      selectHandler.execute(game, playerType, availableReservation)

      // then
      there was actionManager.reserveAction(gameId, playerType, availableReservation)
    }

    "signalize error when reservation is unavailable" in {
      // given
      val actionManager = mock[ActionManager]
      val selectHandler = new SelectActionFromInitiativeHandler(actionManager)

      val unavailableReservation = ActionReservation(AbundanceAction, 0)

      // when
      lazy val actionExecution = {
        selectHandler.execute(game, playerType, unavailableReservation)
      }

      // then
      actionExecution must throwA[IllegalGameStateException]
      there was atMost(0)(actionManager).reserveAction(any[GameId], any[AnimalType], any[ActionReservation])
    }

  }

}
