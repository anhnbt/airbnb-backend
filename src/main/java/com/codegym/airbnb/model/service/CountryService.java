package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.City;
import com.codegym.airbnb.model.entities.Country;

import java.util.Optional;

public interface CountryService {
    Iterable<Country> getAll();
    Optional<Country> getOne(int id);
    Country save(Country country);
    Country delete(int id);
}
