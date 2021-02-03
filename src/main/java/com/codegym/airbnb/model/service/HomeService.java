package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.Home;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface HomeService {

    Iterable<Home> findAll();

    Optional<Home> findById(Long id);

    Home save(Home home);

    Optional<Home> deleteById(Long id);

}
