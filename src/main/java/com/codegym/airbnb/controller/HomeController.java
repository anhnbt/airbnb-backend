package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Response home() {
        Response response = new Response("Hello", "success", HttpStatus.OK);
        return response;
    }

}
