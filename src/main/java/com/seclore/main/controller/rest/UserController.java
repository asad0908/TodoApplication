package com.seclore.main.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/")
	ResponseEntity<String> createUser() {

		return new ResponseEntity<String>("User Created", HttpStatus.OK);
	}

	@PostMapping("/login")
	ResponseEntity<String> loginUser() {

		return new ResponseEntity<String>("User login", HttpStatus.OK);
	}

}