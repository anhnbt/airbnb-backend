package com.codegym.airbnb.services;

import com.codegym.airbnb.entities.RoomImage;
import com.codegym.airbnb.repositories.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomImageImpl implements RoomImageService {
    @Autowired
    private RoomImageRepository roomImageRepository;

    @Override
    public Iterable<RoomImage> getAll() {
        return roomImageRepository.findAll();
    }

    @Override
    public Optional<RoomImage> getOne(Long id) {
        return roomImageRepository.findById(id);
    }

    @Override
    public RoomImage save(RoomImage roomImage) {
        return roomImageRepository.save(roomImage);
    }

    @Override
    public RoomImage delete(Long id) {
        return null;
    }
}
