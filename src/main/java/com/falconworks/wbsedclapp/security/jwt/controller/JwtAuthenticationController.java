package com.falconworks.wbsedclapp.security.jwt.controller;

import com.falconworks.wbsedclapp.security.jwt.beans.AuthenticationRequest;
import com.falconworks.wbsedclapp.security.jwt.beans.AuthenticationResponse;
import com.falconworks.wbsedclapp.security.jwt.services.JwtUserDetailsServiceImpl;
import com.falconworks.wbsedclapp.security.jwt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    private JwtUserDetailsServiceImpl userDerailsService;

    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JWTUtil jwtUtil, JwtUserDetailsServiceImpl userDerailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDerailsService = userDerailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDerailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exc) {
            throw new Exception("User "+username+" is locked", exc);
        } catch (BadCredentialsException exc) {
            throw new Exception("Username and Password combination is invalid", exc);
        }
    }
}
