package com.example.socketpractice.domain.chat.entity;

import com.example.socketpractice.domain.user.entity.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter

public class ChatMessage {
    private String content;
    private String sender;

    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
