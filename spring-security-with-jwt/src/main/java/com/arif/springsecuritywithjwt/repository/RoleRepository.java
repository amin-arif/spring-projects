package com.arif.springsecuritywithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arif.springsecuritywithjwt.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
