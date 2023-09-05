package com.seclore.main.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@PostMapping("/")
	ResponseEntity<String> createUser() {

		return null;
	}

	@PostMapping("/login")
	ResponseEntity<String> loginUser() {

		return null;
	}

}