package models

import org.specs2.mutable.Specification

class PositionSpec extends Specification {

  "position" should {

    "be equal to the same position" in {
      val original = new Position(4, 3, 5)
      val identical = new Position(4, 3, 5)

      val equal = original equals identical

      equal must beTrue
    }

    "be in correct distance from surrounding positions" >> {
      val centerPosition = new Position(4, 3, 5)
      val positions = List(
        new Position(4, 3, 5) -> 0,
        new Position(3, 3, 6) -> 1,
        new Position(3, 4, 5) -> 1,
        new Position(4, 2, 6) -> 1,
        new Position(4, 4, 4) -> 1,
        new Position(5, 2, 5) -> 1,
        new Position(5, 3, 4) -> 1,
        new Position(2, 3, 7) -> 2,
        new Position(2, 3, 7) -> 2,
        new Position(2, 5, 5) -> 2,
        new Position(3, 2, 7) -> 2,
        new Position(3, 5, 4) -> 2,
        new Position(4, 1, 7) -> 2,
        new Position(4, 5, 3) -> 2,
        new Position(5, 1, 6) -> 2,
        new Position(5, 4, 3) -> 2,
        new Position(6, 1, 5) -> 2,
        new Position(6, 2, 4) -> 2,
        new Position(6, 3, 3) -> 2)

      positions foreach {
        case ((position, distance)) =>
          (s"distance from $centerPosition to $position is equal to $distance") >> {
            val evaluatedDistance = centerPosition.getDistance(position)

            evaluatedDistance must beEqualTo(distance)
          }
      }
    }

  }

}
