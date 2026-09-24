import sbt._

object Dependencies {
  lazy val scalaTestVersion = "3.2.20"
  lazy val playwrightVersion = "1.63.0"


  lazy val scalaTest = List("org.scalatest" %% "scalatest" % scalaTestVersion % Test,
    "org.scalatest" %% "scalatest-flatspec" % scalaTestVersion % Test,
    "org.scalatest" %% "scalatest-shouldmatchers" % scalaTestVersion % Test
  )

  lazy val playwright = "com.microsoft.playwright" % "playwright" % playwrightVersion % Test
}
