package models.actions.board

import org.specs2.mock.Mockito
import org.specs2.mutable.SpecificationWithJUnit
import models.Game
import models.Mammal
import models.actions.ConfirmActionHandler
import models.actions.SelectAdaptationHandler
import models.Animal
import models.ElementType
import models.Grass

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
      classOf[SelectAdaptationHandler].isAssignableFrom(confirmRequest.forward) should beTrue
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

}