package com.okan.awssqsdemo.consumer;

import com.google.gson.Gson;
import com.okan.awssqsdemo.dto.ExampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SQSConsumer {
    @SqsListener(value = "${cloud.aws.destination.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(final String message) {
        log.info("Receiving message from SQS -> " + new Gson().fromJson(message, ExampleDTO.class));
    }
}
