package models

class Animal(val animalType: AnimalType, val elements: Map[ElementType, Int],
    val genePoolSize: Int, val actionNumber: Int) {

  val elementsCapacity = 6

  def elementsNumber = elements.values.sum

  def canAdapt = elementsNumber < elementsCapacity

  def getDominanceValue(fieldElements: Map[ElementType, Int]) = {
    elements.foldLeft(0) {
      case (acc, (elem, count)) => {
        acc + count * fieldElements.getOrElse(elem, 0)
      }
    }
  }

}