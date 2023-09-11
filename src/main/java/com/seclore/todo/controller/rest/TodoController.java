package com.seclore.todo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seclore.todo.model.Todo;
import com.seclore.todo.service.Todo.TodoServiceInterface;


/**
 * The TodoController class is responsible for handling HTTP requests related to managing TODOs.
 * It provides endpoints for retrieving all TODOs, creating a new TODO, retrieving a TODO by ID,
 * updating a TODO by ID, and deleting a TODO by ID.
 * It requires user's bearer token to be passed in the authorization headers.
 *
 * @RestController Indicates that this class is a controller for handling RESTful HTTP requests.
 * @RequestMapping("/api/todo") Specifies the base URL path for mapping this controller's endpoints.
 */
@RestController
@RequestMapping("/api/todo")
public class TodoController {
	
	@Autowired
	private TodoServiceInterface todoService;

    /**
     * Retrieve all TODOs associated with a specific user.
     * The userId is extracted from the token and passed in through request attribute
     *
     * @param userId The user ID for whom to retrieve TODOs.
     * @return ResponseEntity containing a list of TODOs if successful (HTTP 200 OK),
     *         or an error response if retrieval fails (HTTP 500 Internal Server Error).
     */
	@GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Todo>> getAllTodoByUserId(@RequestAttribute("userId") int userId) {
		List<Todo> todoList = todoService.getTodoListByUserId(userId);
		return new ResponseEntity<List<Todo>>(todoList,  HttpStatus.OK);
	}

	/**
     * Create a new TODO for a specific user.
     *
     * @param todo   The Todo object containing TODO information to be created.
     * @param userId The user ID for whom to create the TODO; The userId is 
     * 		   extracted from the token and passed in through request attribute
     * @return ResponseEntity with a success message if TODO creation is successful (HTTP 201 Created),
     *         or an error message if creation fails (HTTP 304 Not Modified).
     */
	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> createTodo(@RequestBody Todo todo, @RequestAttribute("userId") int userId) {
		boolean success = todoService.createTodo(todo, userId);
		if(success)
			return new ResponseEntity<String>("Created a new todo!", HttpStatus.CREATED);
		return new ResponseEntity<String>("Failed to create todo!", HttpStatus.NOT_MODIFIED);
	}

	/**
     * Retrieve a TODO by its unique ID.
     *
     * @param todoId The unique ID of the TODO to retrieve.
     * @return ResponseEntity containing the TODO if found (HTTP 200 OK),
     *         or an error response if retrieval fails (HTTP 500 Internal Server Error).
     */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Todo> getTodoById(@PathVariable(name = "id") int todoId) {
		Todo todo = todoService.getTodoById(todoId);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	/**
     * Update a TODO by its unique ID.
     *
     * @param todo The Todo object containing updated TODO information{title:string, description: string, status:{"In Progress", "Completed", "Pending"}}.
     * @param id   The unique ID of the TODO to update.
     * @return ResponseEntity with a success message if TODO update is successful (HTTP 200 OK),
     *         or an error message if update fails (HTTP 304 Not Modified).
     */
	@PutMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> updateTodoById(@RequestBody Todo todo, @PathVariable int id) {
		todo.setId(id);
		boolean success = todoService.editTodo(todo);
		if(success)
			return new ResponseEntity<String>("Edited todo!", HttpStatus.OK);
		return new ResponseEntity<String>("Failed to edit todo!", HttpStatus.NOT_MODIFIED);
	}

	/**
     * Delete a TODO by its unique ID.
     *
     * @param todoId The unique ID of the TODO to delete.
     * @return ResponseEntity with a success message if TODO deletion is successful (HTTP 200 OK),
     *         or an error message if deletion fails (HTTP 304 Not Modified).
     */
	@DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> deleteTodoById(@PathVariable(name = "id") int todoId) {
		boolean success = todoService.deleteTodo(todoId);
		if(success)
			return new ResponseEntity<String>("Deleted todo!", HttpStatus.OK);
		return new ResponseEntity<String>("Failed to delete todo!", HttpStatus.NOT_MODIFIED);
	}

}
