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

    public Iterable<Room> findAllBySimpleQuery(
        List<RoomType> types,
        Double price,
        Double rating
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

        if (price != null) {
            predicates.add(cb.equal(root.get("price"), price));
        }

        if (rating != null) {
            predicates.add(cb.equal(root.get("rating"), rating));
        }

        // Add all predicates to the query
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();

    }
    
}
