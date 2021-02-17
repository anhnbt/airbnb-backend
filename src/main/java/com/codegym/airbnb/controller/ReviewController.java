package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Review;
import com.codegym.airbnb.services.BookingService;
import com.codegym.airbnb.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/review")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private BookingService bookingService;
    Response res = new Response();

    @GetMapping
    public Response findAll(){
        res.setData(reviewService.findAll());
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        res.setData(reviewService.findById(id).get());
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @PostMapping
    public Response save(@RequestBody Review review, @PathVariable Long id){
        Booking booking = bookingService.findById(id).get();
        review.setBooking(booking);
        review.setActive(true);
        review.setCreatedDate(LocalDateTime.now());
        review.setModifiedDate(LocalDateTime.now());
        res.setData(reviewService.save(review));
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

}
