package com.hms.hms.room;

public class RoomMapper {

    public static RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setRoomType(room.getType());
        roomDto.setPrice(room.getPrice());
        roomDto.setRating(room.getRating());
        return roomDto;
    }

    public static Room toEntity(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setType(roomDto.getRoomType());
        room.setPrice(roomDto.getPrice());
        room.setRating(roomDto.getRating());
        return room;
    }
    
}
