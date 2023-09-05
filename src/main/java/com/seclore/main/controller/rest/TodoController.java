package com.seclore.main.controller.rest;

import java.util.List;

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

	@GetMapping("/todo")
	ResponseEntity<List<Todo>> getAllTodoByUserId() {

		return null;
	}

	@PostMapping("/todo")
	ResponseEntity<List<Todo>> createTodo() {

		return null;
	}

	@GetMapping("/todo/{id}")
	ResponseEntity<List<Todo>> getTodoById() {

		return null;
	}

	@PutMapping("/todo/{id}")
	ResponseEntity<List<Todo>> updateTodoById() {

		return null;
	}

	@DeleteMapping("/todo/{id}")
	ResponseEntity<List<Todo>> deleteTodoById() {

		return null;
	}

}
