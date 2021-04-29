package edu.self

import java.net.URL
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.control.NonFatal

object Main {

  def runner[T](body: => T)(implicit ec: ExecutionContext): Future[T] = {
    val promise = Promise[T]
    try {
      promise.success(body).future
    } catch {
      case NonFatal(e) => promise.failure(e).future
    }
  }

  def main(args: Array[String]): Unit = {
    //    implicit val ec = ExecutionContext.Implicits.global
    //
    //
    //    println(Thread.activeCount())
    //    Thread.sleep(Integer.MAX_VALUE)

    val url = "https://shubhamgirdhar.com"

    val connection = new URL(url)
      .openConnection().asInstanceOf[HttpsURLConnection]

    connection.connect()

    val res = connection
      .getServerCertificates()(0).asInstanceOf[X509Certificate]

    println(s"${url}: ${res.getNotBefore} | ${res.getNotAfter}")
  }
}
