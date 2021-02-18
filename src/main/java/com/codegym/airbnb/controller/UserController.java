package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Booking;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.model.UserModel;
import com.codegym.airbnb.repositories.RoomPaging;
import com.codegym.airbnb.repositories.BookingRepository;
import com.codegym.airbnb.services.HomeService;
import com.codegym.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private RoomPaging roomPaging;

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
    public Response findByNameAndPassword(@RequestBody UserModel user){
        res.setData(userService.findByNameAndPassword(user.getName(), user.getPassword()).get());
        res.setStatus(HttpStatus.OK);
        res.setMessage("SUCCESS");
        return res;
    }

    @GetMapping("/{id}/rooms")
    public Response getRooms(@PathVariable long id,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "4") int size){
        List<Room> roomList = new ArrayList<>();
        PageRequest paging = PageRequest.of(page, size);
        Page<Room> pageRooms;

        pageRooms = roomPaging.findAllByUserId(id, paging);

        for (Room room : homeService.findAll()) {
            if(room.getUser().getId() == id) {
                roomList.add(room);
            }
        }
        res.setData(pageRooms);
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
