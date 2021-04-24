import Dependencies._

name := "learning-scala"

version := "0.1"

scalaVersion := "2.12.12"

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
    leetcode
  )

lazy val leetcode = (project in file("leetcode"))
  .settings(
    libraryDependencies ++= Seq.empty
  )

lazy val shapeless = (project in file("shapeless"))
  .settings(
    libraryDependencies ++= Seq(
      libShapeless
    )
  )

coverageMinimum := 80
coverageFailOnMinimum := false
