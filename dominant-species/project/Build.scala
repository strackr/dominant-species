import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "dominant-species"
  val appVersion = "1.0-SNAPSHOT"

  // project dependencies
  val appDependencies = Seq(
      jdbc,
      anorm,
      "org.scalatest" %% "scalatest" % "1.9.1" % "test")

  // project settings
  val main = play.Project(appName, appVersion, appDependencies).settings()

}
