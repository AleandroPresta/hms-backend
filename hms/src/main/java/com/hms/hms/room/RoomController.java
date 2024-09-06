package com.hms.hms.room;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(origins = "http://localhost:4200") // Allow cross-origin requests from Angular
public class RoomController {
    
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
        RoomDto savedRoom = roomService.createRoom(roomDto);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Long id) {
        RoomDto room = roomService.getRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<Iterable<RoomDto>> getAllRooms() {
        Iterable<RoomDto> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        RoomDto updatedRoom = roomService.updateRoom(id, roomDto);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<RoomDto> deleteRoom(@PathVariable Long id) {
        RoomDto deletedRoom = roomService.deleteRoomById(id);
        return new ResponseEntity<RoomDto>(deletedRoom, HttpStatus.OK);
    }

    @GetMapping("search")
    public String searchRooms(
        @RequestParam(required = false) List<RoomType> types,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double minRating,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) Double maxRating
    ) {
        String params= "";
        if (types != null) {
            params = params + "types=" + types.toString();
        }

        if (minPrice != null) {
            params = params + ", minPrice=" + minPrice;
        }

        if (minRating != null) {
            params = params + ", minRating=" + minRating;
        }
        return params;
    }
    
}
