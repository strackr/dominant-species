package models

import java.lang.Math.abs

case class Position(val x: Int, val y: Int, val z: Int) {

  def getDistance(that: Position): Int = {
    val distX = abs(Position.this.x - that.x)
    val distY = abs(Position.this.y - that.y)
    val distZ = abs(Position.this.z - that.z)
    return List(distX, distY, distZ).max
  }

}
