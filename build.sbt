import scala.collection.Seq

lazy val baseSettings: Project => Project =
  _.settings(
    name := "boiler-play",
    version := "1.0-SNAPSHOT",
    organization := "io.github.stoneream",
    scalaVersion := "3.6.4",
    scalafmtOnCompile := true,
    scalacOptions ++= Seq(
      "-Yretain-trees",
      "-Wunused:all"
    ),
    semanticdbEnabled := true
  )

lazy val root = (project in file("."))
  .configure(baseSettings)
  .aggregate(server, logging, gendoc, database)

lazy val endpoint = (project in file("endpoint"))
  .configure(baseSettings)
  .settings(
    name := "endpoint",
    libraryDependencies ++= Dependencies.endpoint
  )

lazy val gendoc = (project in file("gendoc"))
  .configure(baseSettings)
  .settings(
    name := "gendoc",
    libraryDependencies ++= Dependencies.gendoc
  )
  .dependsOn(endpoint % "compile->compile; test->test")

lazy val database = (project in file("database"))
  .configure(baseSettings)
  .settings(
    name := "database",
    libraryDependencies ++= Dependencies.database
  )
  .enablePlugins(ScalikejdbcPlugin)

lazy val server = (project in file("server"))
  .configure(baseSettings)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
    name := "server",
    libraryDependencies += guice,
    libraryDependencies ++= Dependencies.server,
    dependencyOverrides ++= Seq(
      // Fix for : com.fasterxml.jackson.databind.JsonMappingException: Scala module 2.14.3 requires Jackson Databind version >= 2.14.0 and < 2.15.0 - Found jackson-databind version 2.18.3
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.0"
    )
  )
  .dependsOn(logging % "compile->compile; test->test")
  .dependsOn(endpoint % "compile->compile; test->test")

lazy val logging = (project in file("logging"))
  .configure(baseSettings)
  .settings(
    name := "logging",
    libraryDependencies ++= Dependencies.logging
  )
