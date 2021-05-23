package edu.self

import zio.console._
import zio.{ExitCode, URIO, ZIO}

object Main extends zio.App {

  override def run(args: List[String]): URIO[Console, ExitCode] = {
    val success: ExitCode = ExitCode(0)
    val failure: ExitCode = ExitCode(1)

    val r: URIO[Console, ExitCode] = putStrLn("Hello!").fold(
      failure = _ => success,
      success = _ => failure
    )

    r
  }
}
