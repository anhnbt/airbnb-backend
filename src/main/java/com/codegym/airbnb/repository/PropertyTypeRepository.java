package com.codegym.airbnb.repository;

import com.codegym.airbnb.model.PropertyType;
import org.springframework.data.repository.CrudRepository;

public interface PropertyTypeRepository extends CrudRepository<PropertyType, Long> {
}
