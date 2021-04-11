package edu.self

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class DateParserSpec extends AnyFlatSpecLike with Matchers {

  val dateParser: DateParser = DateParser()

  "DateParser" should "be able to extract time from a string" in {
    val expected: Long = 1196676930L
    dateParser
      .extractDate("2007-12-03T10:15:30.00Z") shouldBe expected
  }


}
