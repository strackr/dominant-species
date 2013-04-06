package models

import java.lang.Math.abs

class Field(val row: Int, val col: Int) {

  def isAdjacent(that: Field): Boolean = {
    val withinRange1 = (abs(this.row - that.row) <= 1) && (abs(this.col - that.col) <= 1)
    val theSame = (this.row == that.row) && (this.col == that.col)
    val upperRight = (this.row == that.row - 1) && (this.col == that.col + 1)
    val lowerDown = (this.row == that.row + 1) && (this.col == that.col - 1)
    return withinRange1 && !theSame && !upperRight && !lowerDown
  }

  override def toString = s"Field($row, $col)"

}
