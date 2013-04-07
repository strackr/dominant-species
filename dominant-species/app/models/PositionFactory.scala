package models

class PositionFactory(spread: Int) {

  def createPosition(x: Int, y: Int) = {
    new Position(x, y, spread - x - y);
  }

}