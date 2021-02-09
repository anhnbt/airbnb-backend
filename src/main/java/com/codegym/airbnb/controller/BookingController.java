package com.codegym.airbnb.controller;

import com.codegym.airbnb.exception.BookingNotFoundException;
import com.codegym.airbnb.exception.RoomNotFoundException;
import com.codegym.airbnb.exception.UserNotFoundException;
import com.codegym.airbnb.model.*;
import com.codegym.airbnb.services.BookingService;
import com.codegym.airbnb.services.HomeService;
import com.codegym.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private HomeService homeService;

    @GetMapping
    public Iterable<Booking> all() {
        return bookingService.findAll();
    }

    @GetMapping("{id}")
    public Booking one(@PathVariable("id") Long id) {
        return bookingService.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @PostMapping(value = "{roomId}/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Booking save(
            @PathVariable("roomId") Long roomId,
            @PathVariable("userId") Long userId,
            @RequestBody Booking booking) {
        UserModel user = userService.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Room room = homeService.findById(userId).orElseThrow(() -> new RoomNotFoundException(roomId));
        booking.setStatus(BookingStatus.IN_PROGRESS);
        booking.setUser(user);
        booking.setRoom(room);
        booking.setCreatedDate(LocalDateTime.now());
        booking.setModifiedDate(LocalDateTime.now());
        return bookingService.save(booking);
    }

    @PutMapping("{id}/cancel")
    public Response cancel(@PathVariable("id") Long id
//        ,@RequestParam("localDateTime")
//        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime
    ) {
        Booking booking = bookingService.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
        Response response = new Response();
        booking.setCancelReservationTime(LocalDateTime.now());
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
