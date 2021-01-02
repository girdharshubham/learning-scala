package edu.self.week1

import java.util.NoSuchElementException

import scala.annotation.tailrec

class WarmUp {

  /**
   * stitch: Tail Recursively reverse the list
   * */
  @tailrec
  final def stitch[A](one: List[A], two: List[A], res: List[A] = Nil): List[A] = (one, two) match {
    case (Nil, Nil) => res
    case (head :: tail, two) => stitch(tail, two, head +: res)
    case (`one`, head :: tail) => stitch(one, tail, head +: res)
  }

  /** Reverse a list
   * */
  def reverse[A](one: List[A]): List[A] = one.foldLeft(List.empty[A]) {
    case (acc, elem) => elem +: acc
  }

  /**
   * Last element of a List
   * */
  @tailrec
  final def last[A](list: List[A]): A = list match {
    case head :: Nil => head
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }

  /**
   * Find the last but one element of a list.
   * */
  @tailrec
  final def oneBeforeLast[A](list: List[A]): A = list match {
    case head :: _ :: Nil => head
    case _ :: tail => oneBeforeLast(tail)
    case _ => throw new NoSuchElementException()
  }
}
