package com.hms.hms.room;

import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);
    Iterable<RoomDto> getAllRooms(
        Integer pageNo,
        Integer pageSize,
        String sortBy
    );
    RoomDto getRoomById(Long id);
    RoomDto updateRoom(Long id, RoomDto roomDto);
    RoomDto deleteRoomById(Long id);
    Iterable<RoomDto> searchRooms(
        List<RoomType> types,
        Double minPrice,
        Double maxPrice,
        Double minRating,
        Double maxRating,
        Boolean isAvailable,
        Integer pageNo,
        Integer pageSize,
        String sortBy
    );
    
}
