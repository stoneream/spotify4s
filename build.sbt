ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.stoneream"
ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value)

val playWSVersion = "2.1.10"

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

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

scalacOptions ++= List(
  "-Ywarn-unused",
  "-Yrangepos"
)

scalafmtOnCompile := true
