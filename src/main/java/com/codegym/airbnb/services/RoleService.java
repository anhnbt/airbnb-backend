package com.codegym.airbnb.services;

import com.codegym.airbnb.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
    Role save(Role role);
    Iterable<Role> findAll();
}
