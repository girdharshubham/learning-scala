package edu.self.queue

import com.rabbitmq.client.ConnectionFactory

import scala.util.{Failure, Success, Try}

object RabbitSend {
  val queueName = "rabbit-hole"

  def connection[A <: AutoCloseable, B](resource: A)(op: A => B): B =
    Try(op(resource)) match {
      case Success(value) =>

        value
      case Failure(exception) =>
        resource.close()
        throw exception
    }

  @throws(classOf[Exception])
  def main(args: Array[String]): Unit = {
    val factory = new ConnectionFactory()

    factory
      .setHost("localhost")
    factory
      .setUsername("admin")
    factory.setPassword("ludington12345")

    connection(factory.newConnection()) { connection =>
      val channel = connection.createChannel()
      channel.queueDeclare(queueName, false, false, false, collection.JavaConverters.mapAsJavaMap(Map.empty))
      channel.basicPublish("", queueName, null, "Hello from the other side!".getBytes)
    }

  }
}
