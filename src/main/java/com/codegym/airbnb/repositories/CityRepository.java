package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<Province, Integer> {
}
