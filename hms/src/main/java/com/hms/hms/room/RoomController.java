package com.hms.hms.room;

import java.util.List;

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
        public RoomDto createRoom(RoomDto roomDto) {
            return roomService.createRoom(roomDto);
        }
    
        @GetMapping("{id}")
        public RoomDto getRoom(long id) {
            return roomService.getRoom(id);
        }
    
        @GetMapping("all")
        public List<RoomDto> getRooms() {
            return roomService.getRooms();
        }
    
        @PutMapping("{id}")
        public RoomDto updateRoom(long id, RoomDto roomDto) {
            return roomService.updateRoom(id, roomDto);
        }
    
        @DeleteMapping("{id}")
        public void deleteRoom(long id) {
            roomService.deleteRoom(id);
        }
}
