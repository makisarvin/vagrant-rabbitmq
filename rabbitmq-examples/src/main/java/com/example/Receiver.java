package com.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * Created by arvange on 14/10/2014.
 */
public class Receiver {

  public static final String QUEUE_NAME = "hello";

  public static void main(String[] args) throws IOException, InterruptedException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    //declare queue to listen to
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println("[*] Waiting for messages. To exit press CTRL-C");

    //listen for messages from the queue

    QueueingConsumer consumer = new QueueingConsumer(channel);
    channel.basicConsume(QUEUE_NAME, true, consumer);

    int count = 0;
    while(count < 2) {
      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
      String message = new String(delivery.getBody());
      System.out.println(" [x] Received '" + message + "'");
      count++;
    }

    channel.close();
    connection.close();

  }
}
