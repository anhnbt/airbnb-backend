package com.codegym.airbnb.service;

import com.codegym.airbnb.model.PropertyType;

import java.util.Optional;

public interface PropertyTypeService {
    Iterable<PropertyType> getAll();
    Optional<PropertyType> getOne(Long id);
    PropertyType save(PropertyType propertyType);
    PropertyType delete(Long id);
}
