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

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/room")
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

    @GetMapping("/filter/type")
    public ResponseEntity<Iterable<RoomDto>> findRoomsByType(
        @RequestParam(value = "types") List<String> types
        ) {
        Iterable<RoomDto> rooms = roomService.findRoomsByType(types);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/filter/price")
    public ResponseEntity<Iterable<RoomDto>> findRoomsByPriceLessThen(
        @RequestParam(value = "price") @Min(value = 0) Double price,
        @RequestParam(value = "operator") @Pattern(regexp = "^(gt|lt)$") String operator) {
            if (operator.equals("gt")) { // >
                return new ResponseEntity<>(roomService.findRoomsByPriceGreaterThan(price), HttpStatus.OK);
            }
            // <
            return new ResponseEntity<>(roomService.findRoomsByPriceLessThen(price), HttpStatus.OK);
    }

    @GetMapping("/filter/rating")
    public ResponseEntity<Iterable<RoomDto>> findRoomsByRatingGreaterThan(
        @RequestParam(value = "rating") @Min(value = 0) @Max(value = 5) Double rating,
        @RequestParam(value = "operator") @Pattern(regexp = "^(gt|lt)$") String operator) {
            if (operator.equals("gt")) { // >
                return new ResponseEntity<>(roomService.findRoomsByRatingGreaterThan(rating), HttpStatus.OK);
            }
            // <
            return new ResponseEntity<>(roomService.findRoomsByRatingLessThen(rating), HttpStatus.OK);
    }

    @GetMapping("/filter/available")
    public ResponseEntity<Iterable<RoomDto>> findAvailableRooms() {
        Iterable<RoomDto> rooms = roomService.findAvailableRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
