package models

sealed trait Terrain {

  val speciationSpeed: Int

  val dominationScore: List[Int]

}

object Sea extends Terrain {

  val speciationSpeed = 4

  val dominationScore = List(9, 5, 3, 2)

}

object Wetland extends Terrain {

  val speciationSpeed = 4

  val dominationScore = List(8, 4, 2, 1)

}

object Savanah extends Terrain {

  val speciationSpeed = 3

  val dominationScore = List(7, 4, 2)

}

object Jungle extends Terrain {

  val speciationSpeed = 3

  val dominationScore = List(6, 3, 2)

}

object Forest extends Terrain {

  val speciationSpeed = 3

  val dominationScore = List(5, 3, 2)

}

object Desert extends Terrain {

  val speciationSpeed = 2

  val dominationScore = List(4, 2)

}

object Mountain extends Terrain {

  val speciationSpeed = 2

  val dominationScore = List(3, 2)

}

object Tundra extends Terrain {

  val speciationSpeed = 1

  val dominationScore = List(1)

}
