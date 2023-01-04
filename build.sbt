// project setting

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.3-SNAPSHOT"
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

// project info

ThisBuild / organization := "com.github.stoneream"
ThisBuild / homepage := Some(url("https://github.com/stoneream/spotify4s"))
ThisBuild / licenses := List("Apache License 2.0" -> url("https://github.com/stoneream/spotify4s/blob/main/LICENCE.md"))
ThisBuild / developers := List(
  Developer(
    "stoneream",
    "Ishikawa Ryuto",
    "ishikawa-r@protonmail.com",
    url("https://github.com/stoneream")
  )
)

// publish

ThisBuild / publish / skip := true
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

lazy val publishSetting = Seq(
  publish / skip := false,
  Test / publishArtifact := false,
  Compile / packageBin / publishArtifact := false,
  Compile / packageDoc / publishArtifact := false,
  Compile / packageSrc / publishArtifact := false,
  crossPaths := false,
  publishMavenStyle := true
)

// library dependencies

val circeVersion = "0.14.3"
val libraryCirce = Seq(
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-generic-extras" % circeVersion,
  "io.circe" %% "circe-literal" % circeVersion
)
val sttpVersion = "3.8.6"
val librarySttp = Seq(
  "com.softwaremill.sttp.client3" %% "core" % sttpVersion,
  "com.softwaremill.sttp.client3" %% "circe" % sttpVersion
)

// project

lazy val core = (project in file("core")).settings(
  name := "spotify4s-core",
  publishSetting
)

lazy val circe = (project in file("circe"))
  .settings(
    name := "spotify4s-circe",
    libraryDependencies ++= libraryCirce,
    publishSetting
  )
  .dependsOn(core)

lazy val sttp = (project in file("sttp"))
  .settings(
    name := "spotify4s-sttp",
    libraryDependencies ++= librarySttp ++ libraryCirce,
    publishSetting
  )
  .dependsOn(core)
  .dependsOn(circe)

// compile, format

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

ThisBuild / scalacOptions ++= List(
  "-Ywarn-unused",
  "-Yrangepos"
)

scalafmtOnCompile := true
