package models

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses
import models.actions.board.InitiativeActionSpec
import models.actions.board.AdaptationActionSpec

@RunWith(classOf[Suite])
@SuiteClasses(Array(
  classOf[AnimalSpec],
  classOf[PositionFactorySpec],
  classOf[PositionSpec],
  classOf[InitiativeActionSpec],
  classOf[AdaptationActionSpec]))
class ModelSuite {

}