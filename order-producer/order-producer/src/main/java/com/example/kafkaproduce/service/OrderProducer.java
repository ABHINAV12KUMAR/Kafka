package com.example.kafkaproduce.service;

import com.example.kafkaproduce.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public void sendOrder(Order order){
        try {
            String topic="order-topic";
            String message = objectMapper.writeValueAsString(order);
            kafkaTemplate.send(topic,message);
            System.out.println("send order"+ message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
