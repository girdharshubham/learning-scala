def print[A <: {
  def toString(): String
}](obj: A) = println(obj.toString())

class OPInteger(val value: Int) extends AnyRef {
  override def toString: String =
    s"""OP INTEGER ${value}"""
}

print(new OPInteger(12))