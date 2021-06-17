package com.codegym.airbnb.services;

import com.codegym.airbnb.entities.Role;
import com.codegym.airbnb.entities.UserModel;
import com.codegym.airbnb.repositories.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MessageSource messageSource;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, MessageSource messageSource, RoleService roleService) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
        this.roleService = roleService;
    }

    @Override
    public Iterable<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserModel> findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserModel> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserModel save(UserModel user) throws Exception {
        if (this.existsByUsername(user.getUsername())) {
            throw new RuntimeException(messageSource.getMessage("validators.username.exists", new Object[] {user.getUsername()}, Locale.getDefault()));
        }
        user.setName(user.getUsername());
        Set<Role> roles = new HashSet<>();
        user.getRoles().forEach(role -> {
            if (role.getName().equals("admin")) {
                Optional<Role> adminRole = roleService.findByName("ROLE_ADMIN");
                adminRole.ifPresent(roles::add);
            } else {
                Optional<Role> userRole = roleService.findByName("ROLE_USER");
                userRole.ifPresent(roles::add);
            }
        });
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }
}
