package com.example.springbootkafkademo.springbootkafkaexample.kafka;

import com.example.springbootkafkademo.springbootkafkaexample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserJsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserJsonKafkaProducer.class");

    @KafkaListener(topics = "UserTopic", groupId = "myGroup")
    public void consumeUserMessage(User userMessage)
    {
        LOGGER.info("Message received -> " + userMessage.toString());
    }
}
