package models

sealed trait ActionType {

  val actionNumber: Int

}

object InitiativeAction extends ActionType {

  override val actionNumber = 1

}

object AdaptationAction extends ActionType {

  override val actionNumber = 3

}

object RegressionAction extends ActionType {

  override val actionNumber = 2

}

object AbundanceAction extends ActionType {

  override val actionNumber = 2

}

object WastelandAction extends ActionType {

  override val actionNumber = 1

}

object DepletionAction extends ActionType {

  override val actionNumber = 1

}

object GlaciationAction extends ActionType {

  override val actionNumber = 4

}

object SpeciationAction extends ActionType {

  override val actionNumber = 6

}

object WanderlustAction extends ActionType {

  override val actionNumber = 3

}

object MigrationAction extends ActionType {

  override val actionNumber = 6

}

object CompetitionAction extends ActionType {

  override val actionNumber = 7

}

object DominationAction extends ActionType {

  override val actionNumber = 3

}