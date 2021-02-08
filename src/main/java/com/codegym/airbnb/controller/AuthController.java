package com.codegym.airbnb.controller;

import com.codegym.airbnb.security.JwtUtil;
import com.codegym.airbnb.model.*;
import com.codegym.airbnb.services.RoleService;
import com.codegym.airbnb.services.UserService;
import com.codegym.airbnb.services.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserModel user) {
        if(userService.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserModel newUser = new UserModel();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        Set<Role> roles = new HashSet<>();
        user.getRoles().forEach(role -> {
            if (role.getName().equals("admin")) {
                Role adminRole = roleService.findByName("ROLE_ADMIN").get();
                roles.add(adminRole);
            } else {
                Role userRole = roleService.findByName("ROLE_USER").get();
                roles.add(userRole);
            }
        });
        newUser.setRoles(roles);
        userService.save(newUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/api/v1/users/login")
    public Response createAuthenticationToken(@RequestBody LoginForm loginForm) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        } catch (BadCredentialsException e) {
            return new Response(null, "Wrong user or password", HttpStatus.FORBIDDEN);
        }
        // Trả về jwt cho người dùng.
        String jwt = jwtUtil.generateToken(loginForm.getUsername());
        Optional<UserModel> user = userService.findByUserName(loginForm.getUsername());
        UserDetails userDetails = userService.loadUserByUsername(loginForm.getUsername());
        return new Response(new JwtResponse(jwt, user.get().getId(), user.get().getUsername(), userDetails.getAuthorities()), "success", HttpStatus.OK);
    }
}
