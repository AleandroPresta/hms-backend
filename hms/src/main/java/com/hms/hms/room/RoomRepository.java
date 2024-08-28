package com.hms.hms.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) FROM Room r WHERE r.type = :type")
    Iterable<RoomDto> findRoomsByType(@Param("type") String type);
    
}