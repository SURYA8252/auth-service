package com.lcwd.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.authservice.dto.AuthRequest;
import com.lcwd.authservice.entities.UserCredentials;
import com.lcwd.authservice.service.AuthService;

@RestController
@RequestMapping("/authecation")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
	private AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials user) {
    	return authService.saveUser(user);
    }
    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
    	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
		   return authService.generateToken(authRequest.getUsername());	
		} else {
			throw new UsernameNotFoundException("user not found !!");
		}
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
    	authService.validateToken(token);
    	return "Token is valid !!";
    }
}
