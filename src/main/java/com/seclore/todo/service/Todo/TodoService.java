package com.seclore.todo.service.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.todo.model.todo.Todo;
import com.seclore.todo.repository.Todo.TodoRepositoryInterface;
import com.seclore.todo.repository.UserTodoMapping.UserTodoMappingRepositoryInterface;

@Component
public class TodoService implements TodoServiceInterface {

	@Autowired
	TodoRepositoryInterface todoRepository;
	
	@Autowired
	UserTodoMappingRepositoryInterface userTodoMappingRepository;
	
	@Override
	public boolean createTodo(Todo todo, int userId) {
		boolean todoInserted = todoRepository.createTodo(todo);
		if(!todoInserted) return false;
		int todoId = todoRepository.getLastInsertedTodoId();
		if(todoId <= 0) return false;
		return userTodoMappingRepository.createUserTodoMapping(userId, todoId);
	}

	@Override
	public boolean editTodo(Todo todo) {
		return todoRepository.editTodo(todo);
	}

	@Override
	public boolean deleteTodo(int todoId) {
		return todoRepository.deleteTodo(todoId);
	}

	@Override
	public List<Todo> getTodoListByUserId(int userId) {
		System.out.println("User id: (get user by id): " + userId);
		return userTodoMappingRepository.getAllTodosByUserId(userId);
	}

	@Override
	public Todo getTodoById(int todoId) {
		return todoRepository.getTodoById(todoId);
	}

}
