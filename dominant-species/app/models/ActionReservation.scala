package models

case class ActionReservation(
    val actionType: ActionType,
    val order: Int = 0) {

}