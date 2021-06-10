import scala.language.dynamics

class Dy extends Dynamic {
  def selectDynamic(name: String): String = name * 2
  def updateDynamic(name: String): Unit = {

  }
}

val dynamicObject = new Dy

dynamicObject.selectDynamic("name")
dynamicObject.name