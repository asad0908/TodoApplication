package com.seclore.main.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.main.domain.Todo;
import com.seclore.main.service.Todo.TodoServiceInterface;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
	
	@Autowired
	private TodoServiceInterface todoService;

	@GetMapping("")
	ResponseEntity<List<Todo>> getAllTodoByUserId(@RequestParam int userId) {
		List<Todo> todoList = todoService.getTodoListByUserId(userId);
		return new ResponseEntity<List<Todo>>(todoList,  HttpStatus.OK);
	}

	@PostMapping("")
	ResponseEntity<Boolean> createTodo(@RequestBody Todo todo) {
		boolean success = todoService.createTodo(todo);
		return new ResponseEntity<Boolean>(success, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	ResponseEntity<Todo> getTodoById(@PathVariable(name = "id") int todoId) {
		Todo todo = todoService.getTodoById(todoId);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Boolean> updateTodoById(@RequestBody Todo todo, @PathVariable int id) {
		todo.setId(id);
		boolean success = todoService.editTodo(todo);
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Boolean> deleteTodoById(@PathVariable(name = "id") int todoId) {
		boolean success = todoService.deleteTodo(todoId);
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}

}
