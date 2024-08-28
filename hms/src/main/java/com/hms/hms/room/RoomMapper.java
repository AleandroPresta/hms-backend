package com.hms.hms.room;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RoomMapper {

    public static RoomDto mapToRoomDto(Room room) {
        return new RoomDto(
            room.getId(),
            room.getType(),
            room.getPrice(),
            room.getRating(),
            room.isAvailable()
        );
    }

    public static Room mapToRoom(RoomDto roomDto) {
        return new Room(
            roomDto.getId(),
            roomDto.getType(),
            roomDto.getPrice(),
            roomDto.getRating(),
            roomDto.isAvailable()
        );
    }

    public static Iterable<RoomDto> mapToRoomDtos(Iterable<Room> rooms) {
        return StreamSupport.stream(rooms.spliterator(), false)
                .map(RoomMapper::mapToRoomDto)
                .collect(Collectors.toList());
    }
    
}
