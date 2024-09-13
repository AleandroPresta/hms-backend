package com.hms.hms.room;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class SearchRoomRepository {

    private final EntityManager em;

    public Integer countAllByQuery(
        List<RoomType> types,
        Double minPrice,
        Double maxPrice,
        Double minRating,
        Double maxRating,
        Boolean isAvailable
    ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Room> root = cq.from(Room.class);

        // Define an empty list of predicates
        List<Predicate> predicates = new ArrayList<>();

        // Add dynamic predicates based on the input parameters
        if (types != null) {
            predicates.add(root.get("type").in(types));
        }

        if (minPrice != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        if (minRating != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("rating"), minRating));
        }

        if (maxRating != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("rating"), maxRating));
        }

        if (isAvailable != null) {
            predicates.add(cb.equal(root.get("isAvailable"), isAvailable));
        }

        // Apply the predicates
        cq.select(cb.count(root)).where(predicates.toArray(new Predicate[0]));
        return Math.toIntExact(em.createQuery(cq).getSingleResult());
    }

    public Iterable<Room> findAllByQuery(
        List<RoomType> types,
        Double minPrice,
        Double maxPrice,
        Double minRating,
        Double maxRating,
        Boolean isAvailable,
        Integer pageNo,
        Integer pageSize,
        String sortBy
    ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> root = cq.from(Room.class);

        // Define an empty list of predicates
        List<Predicate> predicates = new ArrayList<>();

        // Add dynamic predicates based on the input parameters
        if (types != null) {
            predicates.add(root.get("type").in(types));
        }

        if (minPrice != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        if (minRating != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("rating"), minRating));
        }

        if (maxRating != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("rating"), maxRating));
        }

        if (isAvailable != null) {
            predicates.add(cb.equal(root.get("isAvailable"), isAvailable));
        }

        // Add paging and sorting
        if (sortBy != null) {
            cq.orderBy(cb.asc(root.get(sortBy)));
        }

        // Apply paging if pageNo and pageSize are provided
        if (pageNo != null && pageSize != null) {
            int offset = (pageNo - 1) * pageSize;
            return em.createQuery(cq).setFirstResult(offset).setMaxResults(pageSize).getResultList();
        }

        // Return the result without paging
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();

    }
    
}
