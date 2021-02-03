package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.Room;

import java.util.Optional;

public interface HomeService {

    Iterable<Room> findAll();

    Iterable<Room> findAllCustomQuery();

    Optional<Room> findById(Long id);

    Optional<Room> findByHomeId(Long id);

    Room save(Room room);

    Optional<Room> deleteById(Long id);

}
