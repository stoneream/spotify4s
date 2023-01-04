ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.stoneream"
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

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

ThisBuild / publishMavenStyle := true
ThisBuild / publish / skip := true
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / publishTo := Some(
  "GitHub Package Registry" at "https://maven.pkg.github.com/stoneream/spotify4s"
)
ThisBuild / credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "stoneream",
  sys.env.getOrElse("GITHUB_TOKEN", "")
)

lazy val core = (project in file("core")).settings(
  name := "spotify4s-core"
)

lazy val circe = (project in file("circe"))
  .settings(
    name := "spotify4s-circe",
    libraryDependencies ++= libraryCirce
  )
  .dependsOn(core)

lazy val sttp = (project in file("sttp"))
  .settings(
    name := "spotify4s-sttp",
    libraryDependencies ++= librarySttp ++ libraryCirce
  )
  .dependsOn(core)
  .dependsOn(circe)

/*

lazy val root = (project in file(".")).settings(
  name := "spotify4s",
  libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-ahc-ws-standalone" % playWSVersion % "provided",
    "com.typesafe.play" %% "play-ws-standalone-json" % playWSVersion % "provided",
    "org.scalatest" %% "scalatest" % "3.2.14"
  ),
  publish / skip := false,
  Test / publishArtifact := false,
  Compile / packageBin / publishArtifact := false,
  Compile / packageDoc / publishArtifact := false,
  Compile / packageSrc / publishArtifact := false,
  crossPaths := false
)
 */

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

ThisBuild / scalacOptions ++= List(
  "-Ywarn-unused",
  "-Yrangepos"
)

scalafmtOnCompile := true
