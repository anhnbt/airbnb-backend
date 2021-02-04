package com.codegym.airbnb.services.impl;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.repositories.BookingRepository;
import com.codegym.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
}
