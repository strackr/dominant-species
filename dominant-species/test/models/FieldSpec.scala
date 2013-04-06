package models

import org.specs2.mutable.Specification

class FieldSpec extends Specification {

  val center = new Field(3, 3)

  "field" should {

    "be adjacent to a neighbouring field" >> {
      val closeSurroundingFields = Set(
        new Field(2, 3), new Field(3, 4), new Field(4, 4),
        new Field(4, 3), new Field(3, 2), new Field(2, 2))

      closeSurroundingFields foreach {
        field =>
          (s"field $center is adjacent to $field") >> {
            val adjacent = center.isAdjacent(field)

            adjacent must beTrue
          }
      }
    }

    "not be adjacent to a distant field" >> {
      val distantSurroundingFields = Set(
        new Field(1, 3), new Field(2, 4), new Field(3, 5), new Field(4, 5),
        new Field(5, 5), new Field(5, 4), new Field(5, 3), new Field(4, 2),
        new Field(3, 1), new Field(2, 1), new Field(1, 1), new Field(1, 2))

      distantSurroundingFields foreach {
        field =>
          (s"field $center is not adjacent to $field") >> {
            val adjacent = center.isAdjacent(field)

            adjacent must beFalse
          }
      }
    }

    "not be adjacent to itself" in {
      val adjacent = center.isAdjacent(center)

      adjacent must beFalse
    }

  }

}
