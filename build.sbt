ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.stoneream"

val playWSVersion = "2.1.10"

lazy val root = (project in file(".")).settings(
  name := "spotify4s",
//  semanticdbEnabled := true,
//  semanticdbVersion := scalafixSemanticdb.revision,
  libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-ahc-ws-standalone" % playWSVersion % "provided",
    "com.typesafe.play" %% "play-ws-standalone-json" % playWSVersion % "provided",
    "org.scalatest" %% "scalatest" % "3.2.8"
  )
)

//scalacOptions ++= List(
//  "-Ywarn-unused",
//  "-Yrangepos"
//)

scalafmtOnCompile := true
