package com.hms.hms.room;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);
    Iterable<RoomDto> getAllRooms();
    RoomDto getRoomById(Long id);
    RoomDto updateRoom(Long id, RoomDto roomDto);
    RoomDto deleteRoomById(Long id);


    
}
