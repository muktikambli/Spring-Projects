package com.example.springbootkafkademo.springbootkafkaexample.kafka;

import com.example.springbootkafkademo.springbootkafkaexample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserJsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger("UserJsonKafkaProducer.class");

    KafkaTemplate<String, User> kafkaTemplate;

    public UserJsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserMessage(User userData)
    {
        Message<User> userMessage = MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC,"UserTopic")
                .build();

        kafkaTemplate.send(userMessage);
        LOGGER.info("User object sent : " + userData.toString());
    }
}
