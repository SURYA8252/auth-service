package com.lcwd.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.authservice.entities.UserCredentials;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer>{
	Optional<UserCredentials> findByName(String username);
}
