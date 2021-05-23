import sbt._

object Dependencies {
  private val scalaTestVersion = "3.2.2"
  private val ScodecVersion = "1.11.7"
  private val ScodecBitsVersion = "1.1.22"
  private val TypesafeLoggingVersion = "3.9.2"
  private val ShapelessVersion = "2.3.3"
  private val AkkaVersion = "2.6.8"
  private val AkkaHttpVersion = "10.2.4"
  private val ZioVersion = "1.0.8"

  val akkaStreams = "com.typesafe.akka" %% "akka-stream" % AkkaVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
  lazy val libShapeless = "com.chuusai" %% "shapeless" % ShapelessVersion
  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  lazy val scodecCore = "org.scodec" %% "scodec-core" % ScodecVersion
  lazy val scodecBits = "org.scodec" %% "scodec-bits" % ScodecBitsVersion
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val typesafeLogging = "com.typesafe.scala-logging" %% "scala-logging" % TypesafeLoggingVersion
  lazy val rabbit = "com.rabbitmq" % "amqp-client" % "5.11.0"

  lazy val libZio = "dev.zio" %% "zio" % ZioVersion
  lazy val zioStreams = "dev.zio" %% "zio-streams" % ZioVersion
}
