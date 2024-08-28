package com.hms.hms.room;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/room")
public class RoomController {
        
        private final RoomService roomService;
    
        @PostMapping
        public ResponseEntity<RoomDto> createRoom(RoomDto roomDto) {
            RoomDto savedRoom = roomService.createRoom(roomDto);
            return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
        }
    
        @GetMapping("{id}")
        public ResponseEntity<RoomDto> getRoom(Long id) {
            RoomDto room = roomService.getRoom(id);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
    
        @GetMapping("all")
        public List<RoomDto> getRooms() {
            return roomService.getRooms();
        }
    
        @PutMapping("{id}")
        public RoomDto updateRoom(Long id, RoomDto roomDto) {
            return roomService.updateRoom(id, roomDto);
        }
    
        @DeleteMapping("{id}")
        public void deleteRoom(Long id) {
            roomService.deleteRoom(id);
        }
}
