package edu.self.week2

import scala.annotation.tailrec

class Day1 {

  /**
   * 2, List(1,2,3,4)
   * 1 => go(1, List(2,3,4))
   * 2 => go(0, List(3,4))
   * 3 => 3
   * */
  def nth[A](k: Int, list: List[A]): A = {
    @tailrec
    def go(k: Int, list: List[A]): A = (k, list) match {
      case (0, head :: _) => head
      case (k, _ :: tail) => go(k - 1, tail)
      case _ => throw new NoSuchElementException()
    }

    go(k, list)
  }
}
