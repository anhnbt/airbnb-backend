package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.Province;

import java.util.Optional;

public interface CityService {
    Iterable<Province> getAll();
    Optional<Province> getOne(int id);
    Province save(Province province);
    Province delete(int id);
}
