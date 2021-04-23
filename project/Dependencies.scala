import sbt._

object Dependencies {
  val scalaTestVersion = "3.2.2"
  val ScodecVersion = "1.11.7"
  val ScodecBitsVersion = "1.1.22"
  val TypesafeLoggingVersion = "3.9.2"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  lazy val scodecCore = "org.scodec" %% "scodec-core" % ScodecVersion
  lazy val scodecBits = "org.scodec" %% "scodec-bits" % ScodecBitsVersion
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val typesafeLogging = "com.typesafe.scala-logging" %% "scala-logging" % TypesafeLoggingVersion
  lazy val rabbit = "com.rabbitmq" % "amqp-client" % "5.11.0"
}
