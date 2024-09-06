package com.hms.hms.room;

import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class CustomSpecs {
    public static Specification<Room> typeIn(List<RoomType> types) {
        return (root, query, cb) -> root.get("type").in(types);
    }

    public static Specification<Room> priceMoreThen(Double minPrice) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Room> priceLessThen(Double maxPrice) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Room> priceBetween(Double minPrice, Double maxPrice) {
        return (root, query, cb) -> cb.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Room> ratingMoreThen(Double minRating) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("rating"), minRating);
    }

    public static Specification<Room> ratingLessThen(Double maxRating) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("rating"), maxRating);
    }

    public static Specification<Room> ratingBetween(Double minRating, Double maxRating) {
        return (root, query, cb) -> cb.between(root.get("rating"), minRating, maxRating);
    }
}
