package com.codegym.airbnb.model.repository;

import com.codegym.airbnb.model.entities.PropertyType;
import org.springframework.data.repository.CrudRepository;

public interface PropertyTypeRepository extends CrudRepository<PropertyType, Long> {
}
