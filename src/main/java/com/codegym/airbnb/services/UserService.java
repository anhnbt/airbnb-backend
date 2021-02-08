package com.codegym.airbnb.services;

import com.codegym.airbnb.model.User;
import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByEmail(String email);

    User save(User user);

}
