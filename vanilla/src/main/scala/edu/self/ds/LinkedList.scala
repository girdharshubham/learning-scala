package edu.self.ds

import scala.annotation.tailrec

sealed trait LinkedList[A] {
  val value: A
  var next: Option[LinkedList[A]]

  def count: Int
  def last: LinkedList[A]
  def insert(node: LinkedList[A]): Unit
}

case class Node[A](value: A, override var next: Option[LinkedList[A]]) extends LinkedList[A] {

  def last: LinkedList[A] = last(Some(this))
  def count: Int = count(Some(this))

  @tailrec
  private def count(node: Option[LinkedList[A]], total: Int = 0): Int = node match {
    case Some(value) if value.next.isEmpty => total + 1
    case Some(value) if value.next.isDefined => count(value.next, total + 1)
  }

  @tailrec
  private def last(node: Option[LinkedList[A]]): LinkedList[A] = node match {
    case Some(value) if value.next.isEmpty => value
    case Some(value) if value.next.isDefined => last(value.next)
  }

  override def insert(node: LinkedList[A]): Unit = {
    val last: LinkedList[A] = this.last
    last.next = Some(node)
  }
}

object LinkedList {
  def main(args: Array[String]): Unit = {
    val nodeOne = Node(1, None)
    val nodeTwo = Node(2, None)
    val nodeThree = Node(3, None)

    println(nodeOne.count)

    println(nodeOne)
    nodeOne.insert(nodeTwo)
    println(nodeOne)
    nodeOne.insert(nodeThree)
    println(nodeOne)

    println(nodeOne.count)
  }
}
