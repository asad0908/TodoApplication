package com.seclore.main.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.main.domain.User;
import com.seclore.main.service.User.UserServiceInterface;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserServiceInterface userService;

	@PostMapping("")
	ResponseEntity<String> createUser(@RequestBody User user) {
		boolean success = userService.createUser(user);
		if(success) return new ResponseEntity<String>("User Created!", HttpStatus.CREATED);
		return new ResponseEntity<String>("Failed to create user!", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	ResponseEntity<String> loginUser(@RequestBody User user) {
		String token = userService.authenticateUserAndGetToken(user);
		// TODO return token
//		if() return new ResponseEntity<String>("User Created!", HttpStatus.CREATED);
		return new ResponseEntity<String>("Failed to create user!", HttpStatus.BAD_REQUEST);
	}

}