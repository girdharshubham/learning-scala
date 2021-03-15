package edu.self.leetcode

import scala.io.StdIn

object TwoSum {
  implicit def stringArrayToInteger(strArr: Array[String]): Array[Int] = strArr.map(_.toInt)

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    {
      for {
        i <- nums.indices
        j <- i + 1 until nums.length
        if nums(i) + nums(j) == target

      } yield Array(i, j)
    }.flatten.toArray
  }

  def main(args: Array[String]): Unit = {
    val nums: Array[String] = StdIn.readLine().split(" ")
    val target = StdIn.readInt()
    println(twoSum(nums, target).mkString("[", ",", "]"))
  }
}
