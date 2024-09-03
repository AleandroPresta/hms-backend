package com.hms.hms.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoomRepository extends JpaRepository<Room, Long> , JpaSpecificationExecutor<RoomDto> {

    Iterable<Room> findRoomsByTypeAndPrice(RoomType type, double price);

}
