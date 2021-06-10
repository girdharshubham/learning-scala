class TypeCheck {
  def method(obj: Object): Int = 1

  def method(string: String): Int = 2
}

val obj: Object = "Mock-String"
//val obj = "Mock-String"

new TypeCheck().method(obj)