package com.okan.awssqsdemo.producer;

import com.google.gson.Gson;
import com.okan.awssqsdemo.dto.ExampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SQSProducer {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.destination.name}")
    private String destinationName;

    public SQSProducer(final QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        final ExampleDTO exampleDTO = new ExampleDTO("example message from spring boot");
        log.info("Sending message to SQS -> " + exampleDTO);
        queueMessagingTemplate.convertAndSend(destinationName, new Gson().toJson(exampleDTO));
    }
}
