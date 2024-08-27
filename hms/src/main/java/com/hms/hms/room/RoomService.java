package com.hms.hms.room;

import java.util.List;

public interface RoomService {
    
    RoomDto createRoom(RoomDto roomDto);
    RoomDto getRoom(long id);
    List<RoomDto> getRooms();
    RoomDto updateRoom(long id, RoomDto roomDto);
    void deleteRoom(long id);

}
