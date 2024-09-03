package com.hms.hms.room;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public class CustomSpecs {

    public static Specification<RoomDto> typeIn(List<RoomType> types) {
        return (root, query, cb) -> root.get("type").in(types);
    }
    
    public static Specification<RoomDto> priceLessThan(Double price) {
        return (root, query, cb) -> cb.lessThan(root.get("price"), price);
    }
}
