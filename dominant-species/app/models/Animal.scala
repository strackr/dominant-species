package models

class Animal(val animalType: AnimalType, val elements: Map[ElementType, Int],
  val genePoolSize: Int, val actionNumber: Int) {

  def getDominanceValue(fieldElements: Map[ElementType, Int]) = {
    elements.foldLeft(0) {
      case (acc, (elem, count)) => {
        acc + count * fieldElements.getOrElse(elem, 0)
      }
    }
  }

}