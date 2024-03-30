package com.example.socketpractice.domain.chat.entity;

import com.example.socketpractice.domain.user.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ChatRoom chatRoom;
    @ManyToOne
    private User user;
    private String message;
    private MessageType type;
    private String sender;
    private String roomId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime regData;


    @Builder
    public ChatMessage(String chatRoom, String user, String message) {
        this.roomId = chatRoom;
        this.sender = user;
        this.message = message;
    }

    public void enterMessage(String message) {
        this.message = message;
        this.regData = LocalDateTime.now();
    }

    public enum MessageType {
        ENTER, TALK
    }
}
