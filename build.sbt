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

coverageMinimum := 80
coverageFailOnMinimum := false
