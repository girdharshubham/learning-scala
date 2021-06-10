package edu.self.queue

import com.rabbitmq.client.{CancelCallback, ConnectionFactory, ConsumerShutdownSignalCallback, DeliverCallback}
import edu.self.queue.RabbitSend.{connection, queueName}

object RabbitRecv {
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

      val deliveryCallback: DeliverCallback = (consumerTag, delivery) => {
        val message = delivery.getBody()
        println(s"Got Message: ${new String(message)}")
      }

      val cancel: CancelCallback = cancel => {}

      channel.basicConsume(queueName, deliveryCallback, cancel)
    }
  }
}
