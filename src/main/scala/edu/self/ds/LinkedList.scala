package edu.self.ds

trait LinkedList[+A] {
  def value: A

  def next: LinkedList[A]

  def foreach(f: A => Unit)
}

case object Nil extends LinkedList[Nothing] {
  override def value: Nothing = throw new NoSuchElementException("head of an empty list")

  override def next: LinkedList[Nothing] = throw new UnsupportedOperationException("tail of an empty list")

  override def foreach(f: Nothing => Unit): Unit = ()
}

case class Node[A](value: A, next: LinkedList[A]) extends LinkedList[A] {
  override def foreach(f: A => Unit): Unit = next match {
    case Nil => f(value)
      ()
    case elem => f(value)
      elem.foreach(f)
  }

  def size: Int = {
    var length = 0
    var current: LinkedList[A] = this
    while (current != Nil) {
      length += 1
      current = current.next
    }
    length
  }

  def length: Int = goLength(list = this)

  def goLength(length: Int = 0, list: LinkedList[A]): Int = list.next match {
    case Nil => length + 1
    case _ => goLength(length + 1, list.next)
  }
}