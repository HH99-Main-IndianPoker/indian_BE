package com.example.socketpractice.domain.chat;

import com.example.socketpractice.domain.chat.dto.MessageDto;
import com.example.socketpractice.domain.chat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "#{queue.name}")
@Slf4j
public class Consumer {

    @RabbitHandler
    public void receiveMessage(final MessageDto message) {

        log.info("메세지 수신 성공! " + message.getSender() + ": " + message.getData());
    }
}
