package edu.self.leetcode

object Strings {

  def checkInclusion(str: String*): Boolean = {
    str(1)
      .sorted
      .contains(str(0)
        .sorted)
  }

  def isUnique(string: String): Boolean = true

}
