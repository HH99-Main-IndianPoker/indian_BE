package com.example.socketpractice.domain.chat.dto;

import lombok.Getter;

@Getter
public class MessageDto {


    private String routingKey;
    private final String sender;
    private String channelId;
    private final String data;

    public MessageDto(String routingKey, String sender, String data) {
        this.routingKey = routingKey;
        this.sender = sender;
        this.data = data;
    }



}
