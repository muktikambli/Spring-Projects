package com.example.springbootkafkademo.springbootkafkaexample.controller;

import com.example.springbootkafkademo.springbootkafkaexample.kafka.UserJsonKafkaProducer;
import com.example.springbootkafkademo.springbootkafkaexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonKafkaMessageController {

    @Autowired
    private UserJsonKafkaProducer userJsonKafkaProducer ;

    public JsonKafkaMessageController(UserJsonKafkaProducer userJsonKafkaProducer) {
        this.userJsonKafkaProducer = userJsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishUserMessage(@RequestBody User userMessage)
    {
        userJsonKafkaProducer.sendUserMessage(userMessage);
        return ResponseEntity.ok("User Json message sent to kafka topic.");
    }
}
