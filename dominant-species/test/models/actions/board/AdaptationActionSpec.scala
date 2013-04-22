package models.actions.board

import org.specs2.mock.Mockito
import org.specs2.mutable.SpecificationWithJUnit
import models.Game
import models.Mammal
import models.actions.ConfirmActionHandler
import models.actions.SelectElementHandler
import models.Animal
import models.ElementType
import models.Grass
import models.services.AnimalManager
import models.services.BoardElementManager
import models.GameId

class AdaptationActionSpec extends SpecificationWithJUnit with Mockito {

  "adaptation action handler" should {

    "request element selection when animal can adopt" in {
      // given
      val initiativeHandler = new AdaptationActionHandler

      val animal = mock[Animal]
      animal.elementsNumber returns 5
      animal.elementsCapacity returns 6
      val animalType = Mammal
      val game = mock[Game]
      game.animals returns Map(Mammal -> animal)

      // when
      val request = initiativeHandler.execute(game, animalType)

      // then
      val confirmRequest = request.get
      classOf[SelectElementHandler].isAssignableFrom(confirmRequest.forward) should beTrue
    }

    "finish action when animal cannot adopt" in {
      // given
      val initiativeHandler = new AdaptationActionHandler

      val animal = mock[Animal]
      animal.elementsNumber returns 6
      animal.elementsCapacity returns 6
      val animalType = Mammal
      val game = mock[Game]
      game.animals returns Map(Mammal -> animal)

      // when
      val request = initiativeHandler.execute(game, animalType)

      // then
      request.isDefined must beFalse
    }

  }

  "select adaptation action handler" should {

    "perform adaptation when correct element selected" in {
      // given
      val animalManager = mock[AnimalManager]
      val boardElementManager = mock[BoardElementManager]
      val selectAdaptationHandler = new SelectAdaptationActionHandler(
        animalManager, boardElementManager)

      val animal = mock[Animal]
      animal.elementsNumber returns 5
      animal.elementsCapacity returns 6
      val animalType = Mammal
      val gameId = GameId(123L)
      val game = mock[Game]
      game.id returns gameId
      game.animals returns Map(Mammal -> animal)
      game.adaptationElements returns Map(Grass -> 1)
      val adaptationChoice = Grass

      // when
      selectAdaptationHandler.execute(game, animalType, adaptationChoice)

      // then
      there was animalManager.addElement(gameId, animalType, adaptationChoice)
      there was boardElementManager.removeAdaptationElement(gameId, adaptationChoice)
    }

  }

}