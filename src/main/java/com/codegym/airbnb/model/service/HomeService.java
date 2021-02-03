package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.Home;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface HomeService {
    Iterable<Home> getAll();
    Optional<Home> getOne(int id);
    Home save(Home home);
    Home delete(int id);

}
