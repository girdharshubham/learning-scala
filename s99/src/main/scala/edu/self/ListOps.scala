package edu.self

import scala.annotation.tailrec

object ListOps {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case head :: Nil => head
    case _ :: tail => last(tail)
  }

  @tailrec
  def lastButOne[A](list: List[A]): A = list match {
    case _ :: tail :: rest :: Nil => tail
    case _ :: tail => lastButOne(tail)
  }

  @tailrec
  def kthElement[A](k: Int, list: List[A]): A = (k, list) match {
    case (0, head :: _) => head
    case (n, head :: tail) => kthElement(n - 1, tail)
  }
}
