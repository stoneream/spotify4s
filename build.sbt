ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.2"
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

lazy val publishSetting = Seq(
  publish / skip := false,
  Test / publishArtifact := false,
  Compile / packageBin / publishArtifact := false,
  Compile / packageDoc / publishArtifact := false,
  Compile / packageSrc / publishArtifact := false,
  crossPaths := false
)

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

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

ThisBuild / scalacOptions ++= List(
  "-Ywarn-unused",
  "-Yrangepos"
)

scalafmtOnCompile := true
