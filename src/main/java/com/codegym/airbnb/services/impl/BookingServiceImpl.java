package com.codegym.airbnb.services.impl;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.repositories.BookingRepository;
import com.codegym.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Iterable<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Optional<Booking> findByRoomIdAndUserId(Long id, Long id_user) {
        return bookingRepository.findByRoomIdAndUserId(id, id_user);
    }
}
