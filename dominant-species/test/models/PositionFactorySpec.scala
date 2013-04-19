package models

import org.specs2.mutable.SpecificationWithJUnit

class PositionFactorySpec extends SpecificationWithJUnit {

  "position factory" should {

    "create position with correct z coordinate" in {
      val spread = 20
      val factory = new PositionFactory(spread)

      val created = factory.createPosition(3, 6)

      val expected = new Position(3, 6, 11)
      created must equalTo(expected)
    }

  }

}
