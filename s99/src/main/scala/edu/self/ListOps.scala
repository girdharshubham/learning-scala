package edu.self

import scala.annotation.tailrec

object ListOps {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case head :: Nil => head
    case _ :: tail => last(tail)
  }

  def lastButOne[A](list: List[A]): A = list match {
    case _ :: tail :: rest :: Nil => tail
    case _ :: tail => lastButOne(tail)
  }
}
