package edu.self.week1

import scala.annotation.tailrec

class Day1 {

  /**
   * 3 => 0,1
   * 2 => 1,1
   * 1 => 1,2
   * 0 => 2
   * */
  def fib(n: Int): Int = {
    @tailrec
    def go(remaining: Int = 0, first: Int, state: Int = 0): Int = remaining match {
      case 0 => state
      case n => go(remaining - 1, state, first + state)
    }

    go(n, 0, 1)
  }
}
