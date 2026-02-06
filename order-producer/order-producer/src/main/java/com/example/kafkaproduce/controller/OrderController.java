package com.example.kafkaproduce.controller;

import com.example.kafkaproduce.model.Order;
import com.example.kafkaproduce.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String createOrder(@RequestBody Order order){
        orderProducer.sendOrder(order);
        return "Order sent to kafka successfully" ;

    }

}
