package edu.self.random

class RuntimeResolution {
  def method(string: String): String = "Identified String"

  def method(obj: Object): String = "Identified Object"
}

object Main {
  def main(args: Array[String]): Unit = {
    val res = new RuntimeResolution()

    val o: Object = "String"

    println(res.method(o))
  }
}
