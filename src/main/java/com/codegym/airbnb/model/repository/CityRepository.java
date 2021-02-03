package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.Province;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<Province, Integer> {
}
