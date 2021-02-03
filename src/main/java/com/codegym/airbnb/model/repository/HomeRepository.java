package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home, Integer> {
}
