package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.entities.Home;
import com.codegym.airbnb.model.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/homes")
@CrossOrigin("*")
public class HomeController {

    @Autowired
    private HomeService homeService;

    Response res = new Response();

    @GetMapping
    public Response home() {
        res.setData(homeService.getAll());
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }


    @PostMapping
    public Response createPost(@RequestBody Home home) {
        res.setData(homeService.save(home));
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }

}
