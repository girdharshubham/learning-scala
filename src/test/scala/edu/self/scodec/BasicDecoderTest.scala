package edu.self.scodec

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import scodec.bits._
import scodec.{Attempt, DecodeResult}

class BasicDecoderTest extends AnyFlatSpec {

  val pointCodec: PointCodec.type = PointCodec
  val point: Point = Point(1, 1)
  val empty: BitVector = BitVector.empty

  "PointDecoder" should "decode binary data (1,1) to a Point(1,1)" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = pointCodec
      .codec
      .decode(bin"11")

    actual shouldBe point
    rest shouldBe empty
  }

  it should "be able to decode up to the limit and then pass on data to the rest" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = pointCodec
      .codec
      .decode(bin"11111")

    actual shouldBe point
    rest shouldBe bin"111"
  }
}
