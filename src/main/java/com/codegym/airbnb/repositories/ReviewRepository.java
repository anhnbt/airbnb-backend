package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
@Query(value = "select * from airbnb_db.reviews left join airbnb_db.bookings on reviews.booking_id = bookings.id left join airbnb_db.rooms on bookings.room_id = rooms.id left join airbnb_db.users on bookings.user_id = users.id where bookings.room_id = ?1 order by reviews.created_date desc", nativeQuery = true)
    Iterable<Review> findByRoomIdQuery(Long id);
}
