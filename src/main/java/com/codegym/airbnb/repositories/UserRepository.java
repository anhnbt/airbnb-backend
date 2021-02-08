package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long > {
    Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByEmail(String email);
}
