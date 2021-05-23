package edu.self.hackerrank

import scala.io.StdIn

object Solution {
  implicit def stringToInt(arr: Array[String]): Array[Int] = arr
    .map(_.toInt)

  def count(houseStart: Int, houseEnd: Int, appleTree: Int, orangeTree: Int, apples: Array[Int], oranges: Array[Int]): Unit = {
    val applesNearHouse = apples
      .map(_ + appleTree)
      .count(apple => apple >= houseStart && apple <= houseEnd)

    val orangesNearHouse = oranges
      .map(_ + orangeTree)
      .count(orange => orange >= houseStart && orange <= houseEnd)

    println(applesNearHouse)
    println(orangesNearHouse)
  }

  def validateNumber(arr: Array[Int], size: Int): Boolean = arr.length == size

  def main(args: Array[String]): Unit = {
    val Array(start, end): Array[Int] = StdIn
      .readLine()
      .split(" ")

    val Array(appleTree, orangeTree): Array[Int] = StdIn
      .readLine()
      .split(" ")

    val Array(numApples, numOranges): Array[Int] = StdIn
      .readLine()
      .split(" ")

    val apples: Array[Int] = StdIn
      .readLine()
      .split(" ")

    val oranges: Array[Int] = StdIn
      .readLine()
      .split(" ")

    if (validateNumber(apples, numApples) && validateNumber(oranges, numOranges)) {
      count(
        start,
        end,
        appleTree,
        orangeTree,
        apples,
        oranges
      )
    } else {
      sys.exit()
    }
  }
}