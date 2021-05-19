package edu.self

import edu.self.`enum`._

trait Speaker {
  def speak(): String
}

case class Dog(name: String) extends Speaker {
  override def speak(): String =
    """
      |I speak, hooman!
      |""".stripMargin
}

@main def Main() = {
  println {
    Dog("Leo")
      .speak()
  }

  println {
    s"${Size.Small.} + ${Size.Medium} + ${Size.Large}"
  }
}
