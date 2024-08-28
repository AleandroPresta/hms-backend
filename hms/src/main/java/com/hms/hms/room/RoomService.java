package com.hms.hms.room;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto);
    Iterable<RoomDto> getAllRooms();
    RoomDto getRoomById(Long id);
    RoomDto updateRoom(Long id, RoomDto roomDto);
    RoomDto deleteRoomById(Long id);

    // Find
    Iterable<RoomDto> findRoomsByType(String type);
    // Iterable<RoomDto> findRoomsByPriceLessThen(Double price);
    // Iterable<RoomDto> findRoomsByPriceGreaterThan(Double price);
    // Iterable<RoomDto> findRoomsByRatingLessThen(Double rating);
    // Iterable<RoomDto> findRoomsByRatingGreaterThan(Double rating);
    // Iterable<RoomDto> findAvailableRooms();
    
}
