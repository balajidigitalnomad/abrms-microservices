package com.app.user.kafka.producer;


import com.app.user.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserKafkaProducer {

    @Value("${app.kafka.topics.user-events}")
    private String TOPIC;

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    public void publishUserCreatedEvent(UserCreatedEvent event) {
        log.info("Publishing user created event to kafka topic: {}", event);

        kafkaTemplate.send(TOPIC, event);

        log.info("User Event published Successfully");

    }
}
