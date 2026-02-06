package com.example.kafkaconsumer.order_consumer.service;

import com.example.kafkaconsumer.order_consumer.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-consumer-group"
    )
    public void consume(Order order) {
        System.out.println("✅ Received order: " + order);
    }
}
