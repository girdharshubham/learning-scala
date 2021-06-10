package edu.self.week1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class Day1Test extends AnyFlatSpec {
  val instance = new Day1()


  "Day1Test" should "be able to get the 1st fibonacci number right" in {
    instance.fib(1) shouldBe 1
  }

  it should "be able to get the 2nd fibonacci number right" in {
    instance.fib(2) shouldBe 2
  }

  it should "be able to get the 3rd fibonacci number right" in {
    instance.fib(3) shouldBe 3
  }

  it should "be able to get the 4th fibonacci number right" in {
   instance.fib(4) shouldBe 5
  }

  it should "be able to get the 5th fibonacci number right" in {
    instance.fib(5) shouldBe 8
  }
}
