import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.util.control.NonFatal

def runByPromise[T](block: => T)(implicit ec: ExecutionContext): Future[T] = {
  val p = Promise[T]
  try {
    p.success(block)
  } catch {
    case NonFatal(e) => p.failure(e)
  }

  p.future
}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

Await.result(runByPromise(new ArithmeticException()), 2 seconds)