package models

sealed trait ActionType {

  val actionNumber: Int

}

object InitiativeAction extends ActionType {

  override val actionNumber = 1

}

object AbundanceAction extends ActionType {

  override val actionNumber = 3

}