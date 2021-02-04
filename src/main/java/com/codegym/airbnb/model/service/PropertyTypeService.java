package com.codegym.airbnb.model.service;

import com.codegym.airbnb.model.entities.Country;
import com.codegym.airbnb.model.entities.PropertyType;

import java.util.Optional;

public interface PropertyTypeService {
    Iterable<PropertyType> getAll();
    Optional<PropertyType> getOne(Long id);
    PropertyType save(PropertyType propertyType);
    PropertyType delete(Long id);
}
