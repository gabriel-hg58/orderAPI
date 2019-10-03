package com.orderAPI;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.orderAPI"})
@SpringBootApplication
@EnableRabbit
public class OrderApiApplication {

    @Value("DeliveryQueue")
    private String deliveryQueue;

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//            MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(deliveryQueue);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(DeliveryQueueReceiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

    @Bean
    public Queue queue() {
        return new Queue(deliveryQueue, true);
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApiApplication.class, args);
    }
}
