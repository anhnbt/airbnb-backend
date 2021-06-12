package com.codegym.airbnb.service;

import com.codegym.airbnb.model.Country;

import java.util.Optional;

public interface CountryService {
    Iterable<Country> getAll();
    Optional<Country> getOne(int id);
    Country save(Country country);
    Country delete(int id);
}
