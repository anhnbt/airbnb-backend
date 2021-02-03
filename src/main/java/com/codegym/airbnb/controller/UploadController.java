package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.RoomImage;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.storage.StorageException;
import com.codegym.airbnb.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private StorageService storageService;

    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("upload")
    public Response uploadFileToFolder(@RequestParam("file") MultipartFile file) {
        RoomImage roomImage = new RoomImage();
        try {
            storageService.store(file);
            logger.info("ANHNBT: " + file.getOriginalFilename());
            roomImage.setImageUrl(file.getOriginalFilename());
        } catch (StorageException e) {
            roomImage.setImageUrl("150.png");
            logger.warn("ANHNBT-EXCEPTION: ", e);
        }
        Room room = new Room();
        room.setId(1L);
//        bookingImage.setHome(room);
        return new Response(roomImage, "success", HttpStatus.OK);
    }
}
