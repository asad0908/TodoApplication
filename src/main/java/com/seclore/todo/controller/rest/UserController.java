package com.seclore.todo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.todo.model.user.User;
import com.seclore.todo.service.User.UserServiceInterface;


/**
 * The UserController class is responsible for handling HTTP requests related to user management.
 * It provides endpoints for creating users and authenticating users.
 *
 * @RestController Indicates that this class is a controller for handling RESTful HTTP requests.
 * @RequestMapping("/api/user") Specifies the base URL path for mapping this controller's endpoints.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserServiceInterface userService;

	/**
     * Create a new user with the provided user information.
     *
     * @param user The User object containing user information{name: string, mobile: string, email: string, password: string} to be created.
     * @return ResponseEntity with a success message if user creation is successful (HTTP 201 Created),
     *         or an error message if user creation fails (HTTP 400 Bad Request).
     */
	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> createUser(@RequestBody User user) {
		boolean success = userService.createUser(user);
		if(success) return new ResponseEntity<String>("User Created!", HttpStatus.CREATED);
		return new ResponseEntity<String>("Failed to create user!", HttpStatus.BAD_REQUEST);
	}

	/**
     * Authenticate a user with the provided user information and generates an authentication token.
     *
     * @param user The User object containing user information{email: string, password: string} to be authenticated.
     * @return ResponseEntity<String> with an authentication token if authentication is successful (HTTP 201 Created),
     *         or an error message if authentication fails (HTTP 400 Bad Request).
     */
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> loginUser(@RequestBody User user) {
		String token = userService.authenticateUserAndGetToken(user);
		if(token==null) 
			return new ResponseEntity<String>("Failed to authenticate user!", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>(token, HttpStatus.CREATED);
		
	}

}