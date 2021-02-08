package com.codegym.airbnb.services;

import com.codegym.airbnb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByUserName(String username);
    boolean existsByUsername(String username);
    User save(User user);
}
