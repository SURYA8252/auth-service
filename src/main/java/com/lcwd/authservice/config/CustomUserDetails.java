package com.lcwd.authservice.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lcwd.authservice.entities.UserCredentials;

public class CustomUserDetails implements UserDetails{

	/**
	 * 
	 */
	
	private String username;
	private String password;
	
	
	public CustomUserDetails(UserCredentials userCredentials) {
		username = userCredentials.getName();
		password = userCredentials.getPassword();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
