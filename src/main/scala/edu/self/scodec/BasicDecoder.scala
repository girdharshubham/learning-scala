package edu.self.scodec

import scodec._
import scodec.codecs._

import java.nio.charset._

case class Point(x: Int, y: Int)

object PointCodec {
  val codec: Codec[Point] =
    (("X" | uint(1)) ::
      ("Y" | uint(1))).as[Point]
}

case class Person(name: String)

object PersonCodec {
  implicit val utf8: Charset = StandardCharsets.UTF_8

  val codec: Codec[Person] =
    (("Name" | fixedSizeBytes(7, ascii)).as[Person])
}

sealed trait Value

case class Foo(foo: Int) extends Value

object Foo {
  val codec: Codec[Foo] =
    (("foo" | uint8L)).as[Foo]
}

case class Bar(bar: String) extends Value

object Bar {
  val codec: Codec[Bar] =
    (("bar" | ascii)).as[Bar]
}

object MessageCodec {
  val codec: Codec[Value] =
    codecs.discriminated[Value].by(uint8L)
      .typecase(48, "Foo" | Foo.codec)
      .typecase(32, "Bar" | Bar.codec)
}