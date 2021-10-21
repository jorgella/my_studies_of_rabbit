package hello_world;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender {

  private static final Logger log = LoggerFactory.getLogger(Sender.class);
  private static final String QUEUE_NAME = "hello_world";

  public static void main(String... args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("rabbitmq.local");

    try (
        Connection connection = factory.newConnection(); 
        Channel channel = connection.createChannel()) {
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      var message = "hello World";
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      log.info("[x] Sent '{}'", message);
    }
  }

}
