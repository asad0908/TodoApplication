package com.seclore.main.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.main.domain.Todo;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@GetMapping("")
	ResponseEntity<List<Todo>> getAllTodoByUserId() {

		return new ResponseEntity<List<Todo>>( HttpStatus.OK);
	}

	@PostMapping("")
	ResponseEntity<Boolean> createTodo() {

		return new ResponseEntity<Boolean>( HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Todo> getTodoById() {

		return new ResponseEntity<Todo>( HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Boolean> updateTodoById() {

		return new ResponseEntity<Boolean>( HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Boolean> deleteTodoById() {

		return new ResponseEntity<Boolean>( HttpStatus.OK);
	}

}
