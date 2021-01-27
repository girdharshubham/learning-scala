package edu.self.scodec

import scodec.Codec
import scodec.codecs._

case class Point(x: Int, y: Int)

object PointCodec {
  val codec: Codec[Point] =
    (("X" | uint(1)) ::
      ("Y" | uint(1))).as[Point]
}
