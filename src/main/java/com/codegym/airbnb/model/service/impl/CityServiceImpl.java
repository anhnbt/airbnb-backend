package com.codegym.airbnb.model.service.impl;

import com.codegym.airbnb.model.entities.City;
import com.codegym.airbnb.model.repository.CityRepository;
import com.codegym.airbnb.model.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getOne(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City delete(int id) {
        City city = cityRepository.findById(id).get();
        cityRepository.deleteById(id);
        return city;
    }
}
