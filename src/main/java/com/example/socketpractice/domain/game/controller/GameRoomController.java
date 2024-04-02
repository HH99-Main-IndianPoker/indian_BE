package com.example.socketpractice.domain.game.controller;

import com.example.socketpractice.domain.game.dto.GameRoomDto;
import com.example.socketpractice.domain.game.entity.GameRoom;
import com.example.socketpractice.domain.game.service.GameRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // CORS
@RestController
@RequestMapping("/gameRoom")
public class GameRoomController {

    private GameRoomService gameRoomService;
    public GameRoomController(GameRoomService gameRoomService) {
        this.gameRoomService = gameRoomService;
    }


    @PostMapping("/create")
    public ResponseEntity<GameRoom> createGameRoom(@RequestBody GameRoomDto gameRoomDto) {
        return ResponseEntity.ok(gameRoomService.createGameRoom(gameRoomDto));
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<?> deleteGameRoom(@PathVariable Long roomId) {
        gameRoomService.deleteGameRoom(roomId);
        return ResponseEntity.ok().build();
    }
}
