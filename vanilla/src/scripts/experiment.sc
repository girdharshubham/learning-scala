class ParentT {
  def speak(): String =
    s"""
       |I speak with the authority of a parent.! valBleh!
       |""".stripMargin

  def break(): String = """This is good enough"""
}

class ChildT extends ParentT {
  override val speak: String = {
    val randomMessage = (someString: String) =>
      s"""|I speak like a child! Double Bleh! ${someString}|""".stripMargin
    randomMessage("")
  }

  override val break: String = """This is not good enough"""
}


var shubhamsParents: ParentT = new ParentT()
shubhamsParents.speak()
shubhamsParents = new ChildT
shubhamsParents.speak()

def runner(obj: ParentT)(f: ParentT => Unit): Unit = f(obj)

runner(new ParentT)(x => println(x.speak()))
runner(new ChildT)(x => println(x.speak))

val func = (x: String) => println(x)
def meth(x: String)(y: String) = println(x + y)

new ParentT