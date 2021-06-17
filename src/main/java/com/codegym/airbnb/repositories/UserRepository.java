package com.codegym.airbnb.repositories;

import com.codegym.airbnb.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByNameAndPassword(String name, String password);

    Optional<UserInfo> findByEmail(String email);

    Optional<UserInfo> findByUsername(String username);

    boolean existsByUsername(String username);

}
