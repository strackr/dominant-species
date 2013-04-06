package models

import org.specs2.mutable.Specification

class BoardBuilderSpec extends Specification {

  "board builder" should {
    
    "create board with nonempty field list" in {
      val builder = new BoardBuilder

      val board = builder.createInitialBoard

      board.fields must not be empty
    }
    
  }

}
