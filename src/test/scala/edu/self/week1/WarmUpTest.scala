package edu.self.week1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class WarmUpTest extends AnyFlatSpec {
  val warmUp = new WarmUp()

  "WarmUp" should "be able to concatenate two lists in their reverse order" in {
    val one = List(1, 2, 3)
    val two = List(4, 5, 6)

    warmUp.stitch(Nil, two) shouldBe two.reverse
    warmUp.stitch(one, Nil) shouldBe one.reverse
    warmUp.stitch(one, two) shouldBe two.reverse ++ one.reverse
  }

  it should "be able to reverse a list" in {
    val list = List(1, 2, 3, 4, 5, 6)

    warmUp.reverse(list) shouldBe list.reverse
  }

  it should "be able to find the last element of a list" in {
    val list = List(1, 2, 3, 4, 5, 6)

    warmUp.last(list) shouldBe list.last
    intercept[NoSuchElementException] {
      warmUp.last(List.empty[Int])
    }
  }

  it should "be able to find the penultimate element of a list" in {
    val list = List(1, 2, 3, 4, 5, 6, 7)

    warmUp.oneBeforeLast(list) shouldBe list(list.size - 2)
    intercept[NoSuchElementException] {
      warmUp.oneBeforeLast(Nil)
    }
  }
}
