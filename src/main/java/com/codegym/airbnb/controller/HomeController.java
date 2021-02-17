package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin("*")
public class HomeController {

    @Autowired
    private HomeService homeService;

    // Cho nay anh Duy viet
    @GetMapping
    public Response home() {
        Response res = new Response();
        res.setData(homeService.findAll());
        // Fix lai trả về dữ liệu có phân trang.
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }

    @GetMapping("{id}")
    public Response findById(@PathVariable("id") Long id) {
        Response res = new Response();
        Optional<Room> home = homeService.findById(id);
        res.setData(home.orElseGet(() -> null));
        if (home.isPresent()) {
            res.setMessage("SUCCESS");
            res.setStatus(HttpStatus.OK);
        } else {
            res.setMessage("No rooms available");
            res.setStatus(HttpStatus.NOT_FOUND);
        }
        return res;
    }

    @GetMapping("/city/{id}")
    public Response findByCityId(@PathVariable("id") int id) {
        Response res = new Response();
        ArrayList<Room> home = (ArrayList<Room>) homeService.findAllByCityId(id);
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        res.setData(home);
        return res;
    }

    @PostMapping
    public Response createPost(@RequestBody Room room) {
        Response res = new Response();
        res.setData(homeService.save(room));
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }

    @PutMapping("{id}/status")
    public void changeStatus(@PathVariable int id) {
        for (Room room : homeService.findAll()) {
            if(room.getId() == id) {
                room.setStatus(!room.isStatus());
                homeService.save(room);
                break;
            }
        }
    }
}
