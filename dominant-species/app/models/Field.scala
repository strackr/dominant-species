package models

case class Field(val position: Position, val terrain: TerrainType,
    val elements: Map[ElementType, Int], val species: Map[AnimalType, Int]) {

}