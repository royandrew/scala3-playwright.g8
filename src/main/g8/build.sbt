import Dependencies._

val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "$name$",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,

    libraryDependencies ++= scalaTest,
    libraryDependencies += playwright
  )

ThisBuild / scalaVersion := scala3Version
ThisBuild / organization := "$package$"
ThisBuild / organizationName := "$orgname$"

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

Test / logBuffered := false
Test / parallelExecution := false