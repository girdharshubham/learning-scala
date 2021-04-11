import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val fOne = Future {
  Thread.sleep(10000)
  println("Meh!")
  10
}

val fTwo = Future {
  Thread.sleep(10000)
  println("Big Meh!")
  10
}

val res = for {
  x <- fOne
  y <- fTwo
} yield x + y


//println(res)
//Future
//  .successful(12)
//  .map(x => Future.successful(x))



Await.result(res, 20 seconds)