package com.codegym.airbnb.service;

import com.codegym.airbnb.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
    Role save(Role role);
    Iterable<Role> findAll();
}
