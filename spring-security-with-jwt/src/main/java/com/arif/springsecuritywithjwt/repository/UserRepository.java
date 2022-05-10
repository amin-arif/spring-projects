package com.arif.springsecuritywithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arif.springsecuritywithjwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
