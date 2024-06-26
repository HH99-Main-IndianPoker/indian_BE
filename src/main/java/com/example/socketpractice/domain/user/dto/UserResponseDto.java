package com.example.socketpractice.domain.user.dto;

import com.example.socketpractice.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserResponseDto {

    public record CheckUserEmailResponseDto(Boolean isExist) {
    }

    public record CheckUserNicknameResponseDto(Boolean isExist) {
    }

    public record GetUserResponseDto(
            Long id,
            String email,
            String nickname,
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime createdAt
    ) {
        public GetUserResponseDto(User user) {
            this(
                    user.getId(),
                    user.getEmail(),
                    user.getNickname(),
                    user.getCreatedAt()
            );
        }
    }

    public record EmailSendResponseDto(String emailCode) {
    }

    public record EmailAuthResponseDto(Boolean success) {
    }
}
