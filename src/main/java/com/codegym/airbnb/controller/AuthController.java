package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.UserModel;
import com.codegym.airbnb.request.LoginForm;
import com.codegym.airbnb.request.LoginGoogle;
import com.codegym.airbnb.response.JwtResponse;
import com.codegym.airbnb.response.Response;
import com.codegym.airbnb.security.JwtUtil;
import com.codegym.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.StringTokenizer;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("register")
    public Response register(@RequestBody UserModel user) {
        try {
            UserModel userModel = userService.save(user);
            return new Response(userModel, messageSource.getMessage("message.inserted", new Object[]{user.getUsername()}, Locale.getDefault()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new Response(null, e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("login")
    public Response createAuthenticationToken(@RequestBody LoginForm loginForm) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
            // Trả về jwt cho người dùng.
            String jwt = jwtUtil.generateToken(loginForm.getUsername());
            Optional<UserModel> user = userService.findByUserName(loginForm.getUsername());
            if (user.isPresent()) {
                user.get().setToken(jwt);
//                UserDetails userDetails = userService.loadUserByUsername(loginForm.getUsername());
                return new Response(user.get(), "succeeded", HttpStatus.OK);
            } else {
                return new Response(null, loginForm.getUsername() + " record not found in the database.", HttpStatus.NOT_FOUND);
            }
        } catch (BadCredentialsException e) {
            return new Response(null, "Incorrect username and password", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("login-with-google")
    public Response loginWithGoogle(@RequestBody LoginGoogle loginGoogle) {
        try {
            Optional<UserModel> userModel = userService.findByEmail(loginGoogle.getEmail());
            // Trả về jwt cho người dùng.
            if (!userModel.isPresent()) {
                UserModel user = new UserModel();
                user.setName(loginGoogle.getName());
                user.setUsername(extractUsername(loginGoogle.getEmail()));
                user.setPassword(generatingRandomPassword());
                user.setEmail(loginGoogle.getEmail());
                user.setCreatedDate(LocalDateTime.now());
                user.setModifiedDate(LocalDateTime.now());
                user.setActive(true);
                UserModel newUser = userService.save(user);
                System.out.println(newUser.toString());
                String jwt = jwtUtil.generateToken(newUser.getUsername());
                UserDetails userDetails = userService.loadUserByUsername(newUser.getUsername());
                return new Response(new JwtResponse(jwt, newUser.getId(), newUser.getUsername(), userDetails.getAuthorities()), "success", HttpStatus.OK);
            }
            String jwt = jwtUtil.generateToken(userModel.get().getUsername());
            UserDetails userDetails = userService.loadUserByUsername(userModel.get().getUsername());
            return new Response(new JwtResponse(jwt, userModel.get().getId(), userModel.get().getUsername(), userDetails.getAuthorities()), "success", HttpStatus.OK);
        } catch (Exception e) {
            return new Response(null, e.getMessage(), HttpStatus.OK);
        }
    }

    private String extractUsername(String email) {
        StringTokenizer st = new StringTokenizer(email, "@");
        return st.nextToken();
    }

    private String generatingRandomPassword() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
        return generatedString;
    }
}
