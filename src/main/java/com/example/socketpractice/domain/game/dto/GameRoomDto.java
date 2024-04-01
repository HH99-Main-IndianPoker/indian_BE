package com.example.socketpractice.domain.game.dto;

import lombok.Getter;

@Getter
public class GameRoomDto {
    private String roomName;

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
