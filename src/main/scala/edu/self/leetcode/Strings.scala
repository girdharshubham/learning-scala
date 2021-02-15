package edu.self.leetcode
import scala.collection.immutable
import scala.collection.immutable.HashMap

object Strings {

  def checkInclusion(str: String*): Boolean = {
    str(1)
      .sorted
      .contains(str(0)
        .sorted)
  }

  def isUnique(string: String): Boolean = true

}
