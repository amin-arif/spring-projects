package com.arif.springsecuritywithjwt.service;

import java.util.List;

import com.arif.springsecuritywithjwt.model.Role;
import com.arif.springsecuritywithjwt.model.User;

public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getAllUsers();
}
