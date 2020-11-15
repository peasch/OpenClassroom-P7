package com.peasch.controller;

import com.peasch.controller.security.config.JwtTokenProvider;
import com.peasch.controller.security.service.CustomUserDetailsService;
import com.peasch.model.dto.AuthBody;
import com.peasch.model.dto.UserDto;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService users;
    @Autowired
    private CustomUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public String login(@RequestBody AuthBody data) throws AuthenticationException {
        String userName = data.getUserName();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, data.getPassword())); // Et voilà le point d'entrée
        String token = jwtTokenProvider.createToken(userName, users.findUserByUserName(userName).getRoles()); // Création du token !
        System.out.println(token);
        return token;
    }
    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto user) {
        UserDto userExists = users.findUserByUserName(user.getEmail());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}
