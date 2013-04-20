package models

case class Game(
  val id: GameId,
  val animals: Map[AnimalType, Animal],
  val actions: Map[ActionReservation, AnimalType],
  val availableActions: Set[ActionReservation],
  val adaptationElements: Map[ElementType, Int],
  val elementPositions: Set[Position],
  val terrainPositions: Set[Position])
