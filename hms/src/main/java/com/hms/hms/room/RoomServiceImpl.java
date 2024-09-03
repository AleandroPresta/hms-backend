package com.hms.hms.room;

import org.springframework.stereotype.Service;
import java.util.List;

import lombok.AllArgsConstructor;

import static com.hms.hms.room.CustomSpecs.typeIn;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = RoomMapper.mapToRoom(roomDto);
        Room savedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(savedRoom);
    }

    @Override
    public Iterable<RoomDto> getAllRooms() {
        return RoomMapper.mapToRoomDtos(roomRepository.findAll());
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setType(roomDto.getType());
        room.setPrice(roomDto.getPrice());
        room.setRating(roomDto.getRating());
        room.setAvailable(roomDto.isAvailable());

        Room updatedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(updatedRoom);
    }

    @Override
    public RoomDto deleteRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        roomRepository.delete(room);
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public Iterable<RoomDto> findRoomsByType(List<Integer> types) {
        return roomRepository.findAll(typeIn(types));
    }

    /* @Override
    public Iterable<RoomDto> findAvailableRooms() {
        return roomRepository.findAvailableRooms();
    }

    @Override
    public Iterable<RoomDto> findRoomsByPriceLessThen(Double price) {
        return roomRepository.findRoomsByPriceLessThen(price);
    }

    @Override
    public Iterable<RoomDto> findRoomsByPriceGreaterThan(Double price) {
        return roomRepository.findRoomsByPriceGreaterThan(price);
    }

    @Override
    public Iterable<RoomDto> findRoomsByRatingLessThen(Double rating) {
        return roomRepository.findRoomsByRatingLessThen(rating);
    }

    @Override
    public Iterable<RoomDto> findRoomsByRatingGreaterThan(Double rating) {
        return roomRepository.findRoomsByRatingGreaterThan(rating);
    } */
    
}
