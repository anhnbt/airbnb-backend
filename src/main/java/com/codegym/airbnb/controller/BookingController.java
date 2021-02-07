package com.codegym.airbnb.controller;

import com.codegym.airbnb.exception.BookingNotFoundException;
import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.model.BookingStatus;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public Iterable<Booking> all() {
        return bookingService.findAll();
    }

    @GetMapping("{id}")
    public Booking one(@PathVariable("id") Long id) {
        return bookingService.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Booking save(@RequestBody Booking booking) {
        booking.setStatus(BookingStatus.IN_PROGRESS);
        return bookingService.save(booking);
    }

    @PutMapping("{id}/cancel")
    public Response cancel(@PathVariable("id") Long id,
        @RequestParam("localDateTime")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        Booking booking = bookingService.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
        Response response = new Response();
        booking.setCancelReservationTime(localDateTime);
        booking.setStatus(BookingStatus.CANCELLED);
        Booking newBooking = bookingService.save(booking);
        response.setData(newBooking);
        response.setMessage("success");
        response.setStatus(HttpStatus.OK);
        return response;
//        {{ date | date : format : timezone }}
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        LocalDateTime t = timeStamp.toLocalDateTime();
    }

}
