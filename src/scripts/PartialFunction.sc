val partialFunctionAnonClass = new PartialFunction[(Int, Int), Int] {
  override def apply(x: (Int, Int)): Int = x._1 * x._2

  override def isDefinedAt(x: (Int, Int)): Boolean = x._1 < x._2
}

partialFunctionAnonClass isDefinedAt(1, 2)
partialFunctionAnonClass isDefinedAt(2, 1)

partialFunctionAnonClass(1, 2)

val anotherPartialFunction: PartialFunction[(Int, Int), Int] = {
  case (x: Int, y: Int) if x < y => x * y
}

anotherPartialFunction.isDefinedAt(1, 2)
anotherPartialFunction.isDefinedAt(2, 1)


//anotherPartialFunction(2, 1) This will give a MatchError
