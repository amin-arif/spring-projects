package com.arif.springsecuritywithjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arif.springsecuritywithjwt.model.Role;
import com.arif.springsecuritywithjwt.model.User;
import com.arif.springsecuritywithjwt.repository.RoleRepository;
import com.arif.springsecuritywithjwt.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;
	private final RoleRepository roleRepo;

	public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String email, String roleName) { // add role to specific user
		User user = userRepo.findByEmail(email);
		Role role = roleRepo.findByName(roleName);
		
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
