package com.example.demosetupproject.controller;

import com.example.demosetupproject.payload.AuthenticationRequest;
import com.example.demosetupproject.payload.AuthenticationResponse;
import com.example.demosetupproject.repository.UserRepository;
import com.example.demosetupproject.service.CustomUserDetailsService;
import com.example.demosetupproject.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
//        String jwt;
//        Integer jwtExpirationMs = 3600 *1000;
//        String jwtSecret = "suchASecret";
        try {
            authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password));
//            jwt=Jwts.builder().setSubject((username)).setIssuedAt(new Date())
//                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
//                    .compact();
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }
        final UserDetails userDetails = customUserDetailsService
        .loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}