package models

class BoardBuilder {

  def createInitialBoard = {
    val fields = createInitialFields
    new Board(fields)
  }
  
  private def createInitialFields = {
    val rowColumnMapping = Map(
      0 -> (0 to 2),
      1 -> (0 to 4),
      2 -> (0 to 5),
      3 -> (0 to 6),
      4 -> (1 to 6),
      5 -> (2 to 6),
      6 -> (4 to 6))
    rowColumnMapping flatMap {
      case ((row, range)) => { range map (new Field(row, _)) }
    } toSet
  }

}
