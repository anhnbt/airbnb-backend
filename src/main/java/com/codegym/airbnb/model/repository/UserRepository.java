package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long > {
    Optional<User> findByNameAndPassword(String name, String password);
}
