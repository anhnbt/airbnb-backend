package com.codegym.airbnb.services;

import com.codegym.airbnb.entities.Country;
import com.codegym.airbnb.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getOne(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country delete(int id) {
        Country country = countryRepository.findById(id).get();
        countryRepository.deleteById(id);
        return country;
    }
}
