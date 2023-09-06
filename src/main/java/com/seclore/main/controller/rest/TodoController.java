package com.seclore.main.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.main.domain.Todo;
import com.seclore.main.service.Todo.TodoServiceInterface;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
	
	@Autowired
	private TodoServiceInterface todoService;

	@GetMapping("")
	ResponseEntity<List<Todo>> getAllTodoByUserId(@RequestBody int userId) {
		List<Todo> todoList = todoService.getTodoListByUserId(userId);
		return new ResponseEntity<List<Todo>>(todoList,  HttpStatus.OK);
	}

	@PostMapping("")
	ResponseEntity<Boolean> createTodo(@RequestBody Todo todo) {
		boolean success = todoService.createTodo(todo);
		return new ResponseEntity<Boolean>(success, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	ResponseEntity<Todo> getTodoById(@RequestBody int todoId) {
		Todo todo = todoService.getTodoById(todoId);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Boolean> updateTodoById(@RequestBody Todo todo) {
		boolean success = todoService.editTodo(todo);
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Boolean> deleteTodoById(@RequestBody int todoId) {
		boolean success = todoService.deleteTodo(todoId);
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}

}
