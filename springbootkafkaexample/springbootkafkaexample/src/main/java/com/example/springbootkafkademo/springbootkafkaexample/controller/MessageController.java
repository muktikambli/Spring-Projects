package com.example.springbootkafkademo.springbootkafkaexample.controller;

import com.example.springbootkafkademo.springbootkafkaexample.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=Hello

    @GetMapping
    public String getMessage()
    {

        return "Get Mapping for /api/v1/kafka worked.";
    }
    @GetMapping("/publish")
    public ResponseEntity<String> publicMessage(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic.");
    }
}
