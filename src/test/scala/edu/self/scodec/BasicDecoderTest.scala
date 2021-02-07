package edu.self.scodec

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import scodec.bits._
import scodec.{Attempt, Codec, DecodeResult}

class BasicDecoderTest extends AnyFlatSpec {

  val pointCodec: PointCodec.type = PointCodec
  val personCodec: PersonCodec.type = PersonCodec
  val point: Point = Point(1, 1)
  val shubham: Person = Person("Shubham")
  val empty: BitVector = BitVector.empty
  val value: Codec[Value] = MessageCodec.codec

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

  "PersonCodec" should "be able to decode a hex string to Person model" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = personCodec
      .codec
      .decode(hex"5368756268616d".bits)

    actual shouldBe shubham
    rest shouldBe empty
  }

  it should "be able to decode a hex string and have remainder bits" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = personCodec
      .codec
      .decode(hex"5368756268616d".bits)

    actual shouldBe shubham
    println(rest) //TODO: This is coming out empty.
  }

  "DiscriminatedCodec" should "decode to Foo for 30(hex) => 48(decimal)" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = value.decode(hex"3030".bits)

    actual shouldBe Foo(48)
    rest shouldBe empty
  }

  it should "decide to Bar for 20(hex) => 32(decimal)" in {
    val Attempt.Successful(DecodeResult(actual, rest)) = value.decode(hex"207368756268616d".bits)

    actual shouldBe Bar("shubham")
    rest shouldBe empty
  }
}
