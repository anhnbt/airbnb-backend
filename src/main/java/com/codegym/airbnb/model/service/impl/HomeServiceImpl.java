package com.codegym.airbnb.model.service.impl;

import com.codegym.airbnb.model.entities.Home;
import com.codegym.airbnb.model.repository.HomeRepository;
import com.codegym.airbnb.model.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Optional<Home> deleteById(Long id) {
        Optional<Home> home = homeRepository.findById(id);
        homeRepository.deleteById(id);
        return home;
    }
}
