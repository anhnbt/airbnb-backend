package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.model.User;
import com.codegym.airbnb.repositories.BookingRepository;
import com.codegym.airbnb.services.BookingService;
import com.codegym.airbnb.services.HomeService;
import com.codegym.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private BookingRepository bookingService;
    private Response res = new Response();

    @GetMapping
    public Response getAll(){
        res.setData(userService.findAll());
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable long id){
        res.setData(userService.findById(id));
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @PostMapping()
    public Response findByNameAndPassword(@RequestBody User user){
        res.setData(userService.findByNameAndPassword(user.getName(), user.getPassword()).get());
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @GetMapping("/{id}/rooms")
    public Response getRooms(@PathVariable long id){
        List<Room> roomList = new ArrayList<>();
        for (Room room : homeService.findAll()) {
            if(room.getUser().getId() == id) {
                roomList.add(room);
            }
        }
        res.setData(roomList);
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @GetMapping("/{id}/bookings")
    public Response getBookings(@PathVariable long id){
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : bookingService.findAll()) {
            if(booking.getUser().getId() == id) {
                bookings.add(booking);
            }
        }
        res.setData(bookings);
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }
}
