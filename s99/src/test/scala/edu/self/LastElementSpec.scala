package edu.self

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Random

class LastElementSpec extends AnyFlatSpec with Matchers {
  behavior of "LastElementSpec"

  private def generate(size: Int): List[Int] = (1 to size).map {
    _ => Random.nextInt()
  }.toList

  val listOps = ListOps

  it should "be able to find the last element from a list" in {
    val list = generate(100)

    list.last shouldBe listOps.last(list)
  }

  it should "be able to find the second last element from a list" in {
    val list = generate(100)

    list(list.size - 2) shouldBe listOps.lastButOne(list)
  }

  it should "be able to find the kth element from a list" in {
    val list = generate(100)
    val k = 2
    list(2) shouldBe listOps.kthElement(2, list)
  }
}
