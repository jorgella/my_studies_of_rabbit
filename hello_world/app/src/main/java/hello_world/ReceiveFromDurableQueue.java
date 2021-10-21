package hello_world;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiveFromDurableQueue {

  private static final Logger log = LoggerFactory.getLogger(ReceiveFromDurableQueue.class);
  private static final String QUEUE_NAME = "hello_world.durable";

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("rabbitmq.local");

    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    // channel.queueDeclare(QUEUE_NAME, true, false, false, null);

    log.info(" [*] Waiting for messages. To exit press CTRL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
      var message = new String(delivery.getBody(), "UTF-8");
      log.info(" [x] Received '{}'", message);
    };

    channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
  }

}
