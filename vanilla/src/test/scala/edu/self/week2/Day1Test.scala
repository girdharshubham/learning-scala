package edu.self.week2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class Day1Test extends AnyFlatSpec {

  val instance = new Day1()
  val list: List[Int] = (0 to 5).toList

  def magicSumMethod(f: Int => Int)(a: Int, b: Int): Int =
    f(a) + f(b) // Ah! See?! Maths! Killing it again.!

  val magicSumFunction: (Int => Int) => Int => Int => Int = (f: Int => Int) => (x: Int) => (y: Int) => f(x) + f(y)

  (1 until list.size).map { position =>
    it should s"be able to get the ${position} element right" in {
      instance.nth(position, list) shouldBe list(position)
    }
  }

  it should "be able to implement currying" in {
    magicSumFunction(identity)(1)(1) shouldBe 2
    magicSumFunction(_ + 1)(1)(1) shouldBe 4
  }
}
