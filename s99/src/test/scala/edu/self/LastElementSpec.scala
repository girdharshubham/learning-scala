package edu.self

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Random

class LastElementSpec extends AnyFlatSpec with Matchers {
  behavior of "LastElementSpec"

  private def generate(size: Int): List[Int] = (1 to size).map {
    _ => Random.nextInt()
  }.toList

  val lastElement = LastElement

  it should "be able to find the last element from a list" in {
    val list = generate(100)

    list.last shouldBe lastElement.last(list)
  }
}
