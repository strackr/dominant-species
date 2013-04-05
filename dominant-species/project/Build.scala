import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "dominant-species"
  val appVersion = "1.0-SNAPSHOT"

  // Add your project dependencies here,
  val appDependencies = Seq(jdbc, anorm)

  // Add your own project settings here
  val main = play.Project(appName, appVersion, appDependencies).settings()

}
