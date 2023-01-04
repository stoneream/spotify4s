// scala setting

scalaVersion := "2.13.10"
inThisBuild(
  List(
    scalacOptions ++= List(
      "-Ywarn-unused",
      "-Yrangepos"
    ),
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value),
    scalafmtOnCompile := true
  )
)

// project info

inThisBuild(
  List(
    organization := "io.github.stoneream",
    homepage := Some(url("https://github.com/stoneream/spotify4s")),
    licenses := List(
      "Apache License 2.0" -> url("https://github.com/stoneream/spotify4s/blob/main/LICENCE.md")
    ),
    developers := List(
      Developer(
        "stoneream",
        "Ishikawa Ryuto",
        "ishikawa-r@protonmail.com",
        url("https://github.com/stoneream")
      )
    )
  )
)

// publish settings

sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
publishTo := sonatypePublishToBundle.value

lazy val publishSettings = Seq(
  publish / skip := false,
  Test / publishArtifact := false
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

lazy val root = (project in file(".")).settings(
  name := "spotify4s",
  publish / skip := true
)

lazy val core = (project in file("core")).settings(
  name := "core",
  publishSettings
)

lazy val circe = (project in file("circe"))
  .settings(
    name := "circe",
    libraryDependencies ++= libraryCirce,
    publishSettings
  )
  .dependsOn(core)

lazy val sttp = (project in file("sttp"))
  .settings(
    name := "sttp",
    libraryDependencies ++= librarySttp ++ libraryCirce,
    publishSettings
  )
  .dependsOn(core)
  .dependsOn(circe)
