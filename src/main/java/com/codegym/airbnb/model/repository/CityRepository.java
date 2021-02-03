package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {
}
