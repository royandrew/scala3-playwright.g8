import sbt._

object Dependencies {
  lazy val scalaTestVersion = "3.2.14"
  lazy val playwrightVersion = "1.28.1"


  lazy val scalaTest = List("org.scalatest" %% "scalatest" % scalaTestVersion % Test,
    "org.scalatest" %% "scalatest-flatspec" % scalaTestVersion % Test,
    "org.scalatest" %% "scalatest-shouldmatchers" % scalaTestVersion % Test
  )

  lazy val playwright = "com.microsoft.playwright" % "playwright" % playwrightVersion % Test
}
