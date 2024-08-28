package com.hms.hms.room;

import java.util.List;

public interface RoomService {
    
    RoomDto createRoom(RoomDto roomDto);
    RoomDto getRoom(Long id);
    List<RoomDto> getRooms();
    RoomDto updateRoom(Long id, RoomDto roomDto);
    void deleteRoom(Long id);

}
