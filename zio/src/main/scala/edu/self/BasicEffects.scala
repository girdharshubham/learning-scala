package edu.self

import zio.{IO, UIO, ZIO}

class BasicEffects {
  val success: UIO[Int] = ZIO.succeed(10071995)
  val failure: IO[String, Nothing] = ZIO.fail("Uh-oh!")
}