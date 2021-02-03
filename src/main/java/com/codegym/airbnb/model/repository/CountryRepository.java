package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
