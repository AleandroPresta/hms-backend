package com.hms.hms.room;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = RoomMapper.toEntity(roomDto);
        room = roomRepository.save(room);
        return RoomMapper.toDto(room);
    }

    @Override
    public RoomDto getRoom(long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        return RoomMapper.toDto(room);
    }

    @Override
    public List<RoomDto> getRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(RoomMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RoomDto updateRoom(long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setRoomType(roomDto.getRoomType());
        room.setPrice(roomDto.getPrice());
        room.setRating(roomDto.getRating());
        room = roomRepository.save(room);
        return RoomMapper.toDto(room);
    }

    @Override
    public void deleteRoom(long id) {
        roomRepository.deleteById(id);
    }
    
}
