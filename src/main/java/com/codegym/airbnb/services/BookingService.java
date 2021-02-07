package com.codegym.airbnb.services;

import com.codegym.airbnb.model.Booking;

import java.util.Optional;

public interface BookingService  {

    Iterable<Booking> findAll();

    Booking save(Booking booking);

    Optional<Booking> findById(Long id);
}
