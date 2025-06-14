import sbt._

object Dependencies {
  lazy val logging: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "net.logstash.logback" % "logstash-logback-encoder" % "8.1"
  )

  lazy val database: Seq[ModuleID] = Seq(
    scalikejdbc
  ).flatten

  lazy val server: Seq[ModuleID] = Seq(
    tapir,
    circe,
    argon2,
    mariadbJavaClient,
    scalikejdbc,
    scalikejdbcPlayInitializer
  ).flatten

  lazy val endpoint: Seq[ModuleID] = Seq(
    tapir,
    circe
  ).flatten

  lazy val gendoc: Seq[ModuleID] = Seq(
    scopt,
    betterFiles,
    tapirOpenAPISpec
  ).flatten

  val tapirVersion = "1.11.25"
  lazy val tapir: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-play-server" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % tapirVersion
  )

  lazy val circeVersion = "0.14.13"
  lazy val circe: Seq[ModuleID] = Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion
  )

  lazy val tapirOpenAPISpec: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % tapirVersion,
    "com.softwaremill.sttp.apispec" %% "openapi-circe-yaml" % "0.11.9"
  )

  lazy val scopt: Seq[ModuleID] = Seq(
    "com.github.scopt" %% "scopt" % "4.1.0"
  )

  lazy val betterFiles: Seq[ModuleID] = Seq(
    "com.github.pathikrit" %% "better-files" % "3.9.2"
  )

  lazy val argon2: Seq[ModuleID] = Seq(
    "de.mkammerer" % "argon2-jvm" % "2.12"
  )

  lazy val mariadbJavaClient: Seq[ModuleID] = Seq(
    "org.mariadb.jdbc" % "mariadb-java-client" % "3.5.3"
  )

  lazy val scalikejdbcVersion = "4.3.2"
  lazy val scalikejdbc: Seq[ModuleID] = Seq(
    "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion,
    "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % scalikejdbcVersion,
    "org.scalikejdbc" %% "scalikejdbc-config" % scalikejdbcVersion
  )

  lazy val scalikejdbcPlayInitializer: Seq[ModuleID] = Seq(
    "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "3.0.1-scalikejdbc-4.3"
  )
}
