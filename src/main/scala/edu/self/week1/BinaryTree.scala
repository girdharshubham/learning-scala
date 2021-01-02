package edu.self.week1

sealed trait Tree[+A]

case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

case object End extends Tree[Nothing]

object Node {
  def apply[A](value: A): Node[A] = new Node(value, End, End)
}
