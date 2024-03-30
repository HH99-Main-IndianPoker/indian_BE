package com.example.socketpractice.domain.chat.controller;

import com.example.socketpractice.domain.chat.Producer;
import com.example.socketpractice.domain.chat.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    private final Producer producer;
    private final SimpMessageSendingOperations messageSendingOperations;

    public MessageController(Producer producer, SimpMessageSendingOperations messageSendingOperations) {
        this.producer = producer;
        this.messageSendingOperations = messageSendingOperations;
    }

    @PostMapping("/chat")
    public void sendMessage(@RequestBody MessageDto message) {
        producer.sendMessage(message);
    }

    @MessageMapping("/hello")
    public void newUser(@Payload MessageDto message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        messageSendingOperations.convertAndSend("/topic/"+message.getChannelId(),message);
    }
}
