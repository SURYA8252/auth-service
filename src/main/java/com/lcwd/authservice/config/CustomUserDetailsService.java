package com.lcwd.authservice.config;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lcwd.authservice.entities.UserCredentials;
import com.lcwd.authservice.repository.UserCredentialRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserCredentialRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredentials> byName = this.userCredentialRepository.findByName(username);
		return byName.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with name " +username));
	}

}
