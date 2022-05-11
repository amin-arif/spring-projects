package com.arif.springsecuritywithjwt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arif.springsecuritywithjwt.model.User;
import com.arif.springsecuritywithjwt.service.UserService;

//import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
}
