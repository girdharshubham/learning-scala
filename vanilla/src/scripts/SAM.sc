trait Sam {
  def getSome(string: String): String
}

object Sam {
  def apply(string: String): Unit = {
    val samObj: Sam = (string: String) =>
      s"""
         |${string}, Join us?!
         |""".stripMargin

    println(
      s"""
         |${samObj.getSome(string)}
         |""".stripMargin
    )
  }
}


Sam("Hello?!")