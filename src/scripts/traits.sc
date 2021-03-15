def print[A <: {
  def toString(): String
}](obj: A) = println(obj.toString())

class OPInteger(val value: Int) extends AnyRef {
  override def toString: String =
    s"""OP INTEGER ${value}"""
}

print(new OPInteger(12))

class Animal {
  def speak: String = "I'm an animal"
}

trait Dog {
  def speak: String = "I'm a dog!"
}

trait Cat {
  def speak: String = "I'm a cat!"
}

class Pet extends Animal with Dog with Cat {
  override def speak: String = super.speak
}

new Pet().speak

trait A {
  self =>
  def speak(): String
}

