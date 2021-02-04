package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.entities.Room;
import com.codegym.airbnb.model.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin("*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Cho nay anh Duy viet
    @GetMapping
    public Response home() {
        Response res = new Response();
        res.setData(roomService.findAll());
        // Fix lai trả về dữ liệu có phân trang.
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }

    @GetMapping("{id}")
    public Response findById(@PathVariable("id") Long id) {
        Response res = new Response();
        Optional<Room> home = roomService.findByHomeId(id);
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

    @PostMapping
    public Response createPost(@RequestBody Room room) {
        Response res = new Response();
        res.setData(roomService.save(room));
        res.setMessage("SUCCESS");
        res.setStatus(HttpStatus.OK);
        return res;
    }
}
