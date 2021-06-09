import Dependencies._

name := "learning-scala"

version := "0.1"

scalaVersion := "2.12.13"

enablePlugins(GraalVMNativeImagePlugin)
graalVMNativeImageOptions ++= Seq(
  "--no-fallback",
  "--allow-incomplete-classpath"
)

libraryDependencies ++= Seq(
  scalaTest,
  scodecCore,
  scodecBits,
  logback,
  typesafeLogging,
  rabbit
)

lazy val root = (project in file("."))
  .aggregate(
    dsalgo,
    shapeless
  )

lazy val dsalgo = (project in file("dsalgo"))
  .settings(
    libraryDependencies ++= Seq.empty
  )

lazy val shapeless = (project in file("shapeless"))
  .settings(
    libraryDependencies ++= Seq(
      libShapeless
    )
  )

lazy val `akka-http` = (project in file("akka-http"))
  .settings(
    libraryDependencies ++= Seq(
      akkaHttp,
      akkaStreams
    )
  )

lazy val s99 = (project in file("s99"))
  .settings(
    scalaVersion := "2.12.13",
    libraryDependencies ++= Seq(
      scalaTest
    )
  )

lazy val scala3 = (project in file("scala3"))
  .settings(
    scalaVersion := "3.0.0"
  )

lazy val zio = (project in file("zio"))
  .settings(
    scalaVersion := "2.12.13",
    libraryDependencies ++= Seq(
      libZio
    )
  )

coverageMinimum := 80
coverageFailOnMinimum := false
