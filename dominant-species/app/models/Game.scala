package models

case class Game(
  val id: GameId,
  val actions: Map[ActionReservation, AnimalType],
  val elementPositions: Set[Position],
  val terrainPositions: Set[Position],
  val availableActions: Set[ActionReservation])
