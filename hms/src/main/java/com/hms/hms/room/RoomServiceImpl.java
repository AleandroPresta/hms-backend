package com.hms.hms.room;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;
    private SearchRoomRepository searchRoomRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = RoomMapper.mapToRoom(roomDto);
        Room savedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(savedRoom);
    }

    @Override
    public Iterable<RoomDto> getAllRooms(
        Integer pageNo,
        Integer pageSize,
        String sortBy
    ) {
        // Paging and sorting
        // Edge cases
        sortBy = sortBy == null ? "id" : sortBy;
        pageNo = pageNo == null ? 0 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return RoomMapper.mapToRoomDtos(roomRepository.findAll(pageable));
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setType(roomDto.getType());
        room.setPrice(roomDto.getPrice());
        room.setRating(roomDto.getRating());
        room.setAvailable(roomDto.isAvailable());

        Room updatedRoom = roomRepository.save(room);
        return RoomMapper.mapToRoomDto(updatedRoom);
    }

    @Override
    public RoomDto deleteRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        roomRepository.delete(room);
        return RoomMapper.mapToRoomDto(room);
    }

    @Override
    public Iterable<RoomDto> searchRooms(
        List<RoomType> types, 
        Double minPrice, 
        Double maxPrice, 
        Double minRating, 
        Double maxRating,
        Boolean isAvailable,
        Integer pageNo,
        Integer pageSize,
        String sortBy) {
        return RoomMapper.mapToRoomDtos(
            searchRoomRepository
            .findAllByQuery(types, minPrice, maxPrice, minRating, maxRating, isAvailable, pageNo, pageSize, sortBy)
            );
    }
    
}
