package com.hms.hms.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
         "FROM Room r WHERE r.type IN :types")
   Iterable<RoomDto> findRoomsByType(@Param("types") List<Integer> types);

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
      "FROM Room r WHERE r.isAvailable = true")
   Iterable<RoomDto> findAvailableRooms();

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
      "FROM Room r WHERE r.price <= :price")
   Iterable<RoomDto> findRoomsByPriceLessThen(@Param("price") Double price);

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
      "FROM Room r WHERE r.price >= :price")
   Iterable<RoomDto> findRoomsByPriceGreaterThan(@Param("price") Double price);

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
      "FROM Room r WHERE r.rating >= :rating")
   Iterable<RoomDto> findRoomsByRatingGreaterThan(@Param("rating") Double rating);

   @Query("SELECT new com.hms.hms.room.RoomDto(r.id, r.type, r.price, r.rating, r.isAvailable) " +
      "FROM Room r WHERE r.rating <= :rating")
   Iterable<RoomDto> findRoomsByRatingLessThen(@Param("rating") Double rating);
}
