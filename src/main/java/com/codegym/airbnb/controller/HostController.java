package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.services.HomeService;
import com.codegym.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("api/host")
public class HostController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Response createPost(@RequestBody Room room,
                               Principal principal) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        String uN = principal.getName();
        Response res = new Response();
        room.setUser(userService.findByUserName(userName).get());
        room.setCreatedDate(LocalDateTime.now());
        room.setModifiedDate(LocalDateTime.now());
        res.setData(homeService.save(room));
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }

    @PutMapping("{id}/status")
    public void changeStatus(@PathVariable int id) {
        for (Room room : homeService.findAll()) {
            if (room.getId() == id) {
                room.setStatus(!room.isStatus());
                homeService.save(room);
                break;
            }
        }
    }
}
