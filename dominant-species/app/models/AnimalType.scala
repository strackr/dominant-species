package models

sealed trait AnimalType {

  val startingElements: Map[ElementType, Int]
  val foodChainOrder: Int

  val regressionResistant = false
  val prolific = false
  val belligerent = false
  val migrationDistance = 1
  val endangeredSpeciesLimit = 0

}

object Mammal extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Meat -> 2)
  override val foodChainOrder = 0

  override val endangeredSpeciesLimit = 1

}

object Reptile extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Sun -> 2)
  override val foodChainOrder = 1

  override val regressionResistant = true

}

object Bird extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Seed -> 2)
  override val foodChainOrder = 2

  override val migrationDistance = 2

}

object Amphibian extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Water -> 3)
  override val foodChainOrder = 3

}

object Arachnid extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Grub -> 2)
  override val foodChainOrder = 4

  override val belligerent = true

}

object Insect extends AnimalType {

  override val startingElements: Map[ElementType, Int] = Map(Grass -> 2)
  override val foodChainOrder = 5

  override val prolific = true

}

