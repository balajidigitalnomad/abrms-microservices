package com.app.user.kafka.consumer;

import com.app.user.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {

    @KafkaListener(
            topics ="user-events",
            groupId = "abrms-group"
    )
    public void consume(UserCreatedEvent event){
        log.info("==================================");
        log.info("UserCreated Event Received");
        log.info("User Id : {}", event.getUserId());
        log.info("User FirstName : {} ", event.getFirstName());
        log.info("User LastName : {} ", event.getLastName());
        log.info("User Email : {} ", event.getEmail());
        log.info("==================================");
    }
}
