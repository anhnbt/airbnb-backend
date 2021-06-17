package com.codegym.airbnb.services;

import com.codegym.airbnb.entities.RoomImage;

import java.util.Optional;

public interface RoomImageService {
    Iterable<RoomImage> getAll();
    Optional<RoomImage> getOne(Long id);
    RoomImage save(RoomImage roomImage);
    RoomImage delete(Long id);
}
