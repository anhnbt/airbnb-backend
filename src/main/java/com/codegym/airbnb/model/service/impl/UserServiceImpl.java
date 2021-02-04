package com.codegym.airbnb.model.service.impl;

import com.codegym.airbnb.model.entities.User;
import com.codegym.airbnb.model.repository.UserRepository;
import com.codegym.airbnb.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}
