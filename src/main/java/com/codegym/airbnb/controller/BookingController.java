package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping("{id}")
    public Response cancelReservationTime(@PathVariable("id") Long id,
        @RequestParam("localDateTime")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        Optional<Booking> booking = bookingService.findById(id);
        Response response = new Response();
        response.setData(booking.orElse(null));
        if (booking.isPresent() && localDateTime != null) {
            booking.get().setCancelReservationTime(localDateTime);
            bookingService.save(booking.get());
            response.setMessage("success");
            response.setStatus(HttpStatus.OK);
        } else {
            response.setMessage("No booking available");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return response;
//        {{ date | date : format : timezone }}
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        LocalDateTime t = timeStamp.toLocalDateTime();
    }

}
