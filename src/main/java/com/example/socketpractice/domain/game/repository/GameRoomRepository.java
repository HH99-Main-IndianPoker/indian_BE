package com.example.socketpractice.domain.game.repository;

import com.example.socketpractice.domain.game.entity.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoomRepository extends JpaRepository<GameRoom, Long> {
}
