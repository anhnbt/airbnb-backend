package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.ImageUpload;
import com.codegym.airbnb.model.Response;
import com.codegym.airbnb.model.RoomImage;
import com.codegym.airbnb.model.Room;
import com.codegym.airbnb.storage.StorageException;
import com.codegym.airbnb.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private StorageService storageService;

    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("upload2")
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

    @PostMapping(value = "upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Response uploadImages(@RequestParam("image") String image, @RequestParam("imageSource") MultipartFile[] files) {
        System.out.println("File length: " + files.length);
        try {
            for (MultipartFile file : files) {
                logger.info("ANHNBT: " + file.getOriginalFilename());
                storageService.store(file);
//                roomImage.setImageUrl(file.getOriginalFilename());
            }
        } catch (StorageException e) {
//            roomImage.setImageUrl("150.png");
            logger.warn("ANHNBT-EXCEPTION: ", e);
        }
        return new Response(image, "success", HttpStatus.OK);
    }
}
