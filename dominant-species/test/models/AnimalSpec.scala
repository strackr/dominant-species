package models

import org.specs2.mutable.Specification

class AnimalSpec extends Specification {

  type ElementMap = Map[ElementType, Int]

  "animal" should {

    "have have correct domination value for given elements" >> {
      val settings = List[(ElementMap, ElementMap, Int)](
        (Map(Grass -> 1), Map(), 0),
        (Map(Grub -> 1), Map(Grass -> 1), 0),
        (Map(Grass -> 3, Grub -> 2), Map(Grass -> 1, Grub -> 2), 7),
        (Map(Grub -> 1, Meat -> 2, Seed -> 3), Map(Grass -> 1, Grub -> 2, Meat -> 3), 8))

      settings foreach {
        case (animalElems, fieldElems, correctDominance) =>
          s"domination for animal having $animalElems against $fieldElems is equal to $correctDominance" >> {
            val animal = new Animal(null, animalElems, 0, 0)

            val dominance = animal.getDominanceValue(fieldElems)

            dominance must beEqualTo(correctDominance)
          }
      }
    }

  }

}
