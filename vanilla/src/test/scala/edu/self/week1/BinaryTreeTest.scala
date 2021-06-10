package edu.self.week1

import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers.{a, convertToAnyShouldWrapper}

class BinaryTreeTest extends AsyncFlatSpec {

  "BinaryTreeTest" should "be able to create a Node" in {
    val r = Node(10)
    r.left shouldBe a[End.type]
    r.right shouldBe a[End.type]
    r.value shouldBe 10
  }

  it should "be able to create a binary tree with two children" in {
    val r = Node(10, Node(5), Node(15))

    r.value shouldBe 10
    r.left.asInstanceOf[Node[_]].value shouldBe 5
    r.right.asInstanceOf[Node[_]].value shouldBe 15
  }

}
