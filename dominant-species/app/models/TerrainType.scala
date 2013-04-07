package models

sealed trait TerrainType {

  val populationIncrease: Int
  val dominationScore: List[Int]

}

object Sea extends TerrainType {

  override val populationIncrease = 4
  override val dominationScore = List(9, 5, 3, 2)

}

object Wetland extends TerrainType {

  override val populationIncrease = 4
  override val dominationScore = List(8, 4, 2, 1)

}

object Savanah extends TerrainType {

  override val populationIncrease = 3
  override val dominationScore = List(7, 4, 2)

}

object Jungle extends TerrainType {

  override val populationIncrease = 3
  override val dominationScore = List(6, 3, 2)

}

object Forest extends TerrainType {

  override val populationIncrease = 3
  override val dominationScore = List(5, 3, 2)

}

object Desert extends TerrainType {

  override val populationIncrease = 2
  override val dominationScore = List(4, 2)

}

object Mountain extends TerrainType {

  override val populationIncrease = 2
  override val dominationScore = List(3, 2)

}

object Tundra extends TerrainType {

  override val populationIncrease = 1
  override val dominationScore = List(1)

}
