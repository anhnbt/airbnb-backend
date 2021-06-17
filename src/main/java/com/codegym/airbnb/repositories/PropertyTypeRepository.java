package com.codegym.airbnb.repositories;

import com.codegym.airbnb.entities.PropertyType;
import org.springframework.data.repository.CrudRepository;

public interface PropertyTypeRepository extends CrudRepository<PropertyType, Long> {
}
