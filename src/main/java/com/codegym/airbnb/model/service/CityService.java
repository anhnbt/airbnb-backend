package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.City;
import com.codegym.airbnb.model.entities.Home;

import java.util.Optional;

public interface CityService {
    Iterable<City> getAll();
    Optional<City> getOne(int id);
    City save(City city);
    City delete(int id);
}
