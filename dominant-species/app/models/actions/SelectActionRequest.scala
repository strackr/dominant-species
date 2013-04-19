package models.actions

import models.ActionReservation

case class SelectActionRequest(
  val availableActions: Set[ActionReservation],
  override val forward: Class[_])
    extends ActivityRequest {

}