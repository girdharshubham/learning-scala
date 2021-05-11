package edu.self

import java.util.NoSuchElementException
import scala.annotation.tailrec

object LastElement {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case head :: Nil => head
    case _ :: tail => last(tail)
  }
}
