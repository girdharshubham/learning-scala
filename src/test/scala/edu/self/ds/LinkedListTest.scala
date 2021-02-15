package edu.self.ds

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LinkedListTest extends AnyFlatSpec with Matchers {

  "LinkedListTest" should "be able to get the size of a linkedlist of length 3" in {
    val c1 = Node(0, Nil)
    val c2 = Node(1, c1)
    val c3 = Node(2, c2)

    c3.size shouldBe 3
    c3.length shouldBe 3
    c3 shouldBe Node(2, Node(1, Node(0, Nil)))
  }

  it should "be able to create a linkedlist of size 1" in {
    val c1 = Node(1, Nil)

    c1.size shouldBe 1
    c1.length shouldBe 1
    c1 shouldBe Node(1, Nil)
  }
}
