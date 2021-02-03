package com.codegym.airbnb.model.service.impl;

import com.codegym.airbnb.model.entities.Province;
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
    public Iterable<Province> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<Province> getOne(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public Province save(Province province) {
        return cityRepository.save(province);
    }

    @Override
    public Province delete(int id) {
        Province province = cityRepository.findById(id).get();
        cityRepository.deleteById(id);
        return province;
    }
}
