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
    public Iterable<Home> getAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> getOne(int id) {
        return homeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Home delete(int id) {
        Home home = homeRepository.findById(id).get();
        homeRepository.deleteById(id);
        return home;
    }
}
