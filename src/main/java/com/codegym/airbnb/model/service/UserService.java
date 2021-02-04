package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByNameAndPassword(String name, String password);
}
