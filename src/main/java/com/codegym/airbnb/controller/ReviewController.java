package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Review;
import com.codegym.airbnb.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/review")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
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
    public Response save(@RequestBody Review review){
        res.setData(reviewService.save(review));
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

}
