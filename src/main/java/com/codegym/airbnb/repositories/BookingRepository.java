package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    Optional<Booking> findByRoomIdAndUserId(Long id, Long id_user);
}
