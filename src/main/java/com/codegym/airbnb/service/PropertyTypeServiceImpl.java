package com.codegym.airbnb.service;

import com.codegym.airbnb.model.PropertyType;
import com.codegym.airbnb.repository.PropertyTypeRepository;
import com.codegym.airbnb.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Override
    public Iterable<PropertyType> getAll() {
        return propertyTypeRepository.findAll();
    }

    @Override
    public Optional<PropertyType> getOne(Long id) {
        return propertyTypeRepository.findById(id);
    }

    @Override
    public PropertyType save(PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    @Override
    public PropertyType delete(Long id) {
        PropertyType propertyType = propertyTypeRepository.findById(id).get();
        propertyTypeRepository.deleteById(id);
        return propertyType;
    }
}
