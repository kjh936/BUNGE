package com.bunge.chat.controller;

import com.bunge.chat.constant.KafkaTopic;
import com.bunge.chat.domain.Message;
import com.bunge.chat.service.KafkaConsumerService;
import com.bunge.chat.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducerService producerService;
    private final KafkaConsumerService consumerService;

    @MessageMapping("/message")
    public void publishMessage(Message message, Principal principal) throws JsonProcessingException {
        log.info("message={}", message);
        if (principal == null) {
            return;
        }

        message.setMemberId(principal.getName());
        producerService.sendMessage(KafkaTopic.TEMP, message);
    }

    @KafkaListener(topics = KafkaTopic.TEMP)
    public void consumeMessage(String message, Acknowledgment ack) throws JsonProcessingException {
        consumerService.handleMessage(message, ack);
    }
}
