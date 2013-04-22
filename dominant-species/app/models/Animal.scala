package models

class Animal(val animalType: AnimalType, val elements: Map[ElementType, Int],
    val genePoolSize: Int, val actionNumber: Int) {

  val elementsCapacity = 6

  def getDominanceValue(fieldElements: Map[ElementType, Int]) = {
    elements.foldLeft(0) {
      case (acc, (elem, count)) => {
        acc + count * fieldElements.getOrElse(elem, 0)
      }
    }
  }

  def elementsNumber = {
    elements.foldLeft(0) {
      case (acc, (key, value)) => acc + value
    }
  }

  def canAdapt = {
    elementsNumber < elementsCapacity
  }

}