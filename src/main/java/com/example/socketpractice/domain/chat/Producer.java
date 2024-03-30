package com.example.socketpractice.domain.chat;

import com.example.socketpractice.domain.chat.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    public Producer(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void sendMessage(MessageDto message) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), message.getRoutingKey(), message);
        log.info("메세지 발신 성공");
    }
}
