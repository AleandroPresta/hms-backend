package com.hms.hms.room;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import lombok.RequiredArgsConstructor;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRoomRepository {

    private final EntityManager em;

    public List<Room> findAllBySimpleQuery(
        List<RoomType> types,
        Double price,
        Double rating
    ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Room> cq = cb.createQuery(Room.class);

        Root<Room> root = cq.from(Room.class);

        Predicate p1 = cb.in(root.get("type")).value(types);
        Predicate p2 = cb.equal(root.get("price"), price);
        Predicate p3 = cb.equal(root.get("rating"), rating);

        cq.where(
            cb.or(p1, p2, p3)
        );

        TypedQuery<Room> query = em.createQuery(cq);

        return query.getResultList();
    }
    
}
