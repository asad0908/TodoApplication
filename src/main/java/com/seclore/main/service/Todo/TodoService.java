package com.seclore.main.service.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Todo;
import com.seclore.main.repository.Todo.TodoRepositoryInterface;
import com.seclore.main.repository.UserTodoMapping.UserTodoMappingRepositoryInterface;

@Component
public class TodoService implements TodoServiceInterface {

	@Autowired
	TodoRepositoryInterface todoRepository;
	
	@Autowired
	UserTodoMappingRepositoryInterface userTodoMappingRepository;
	
	@Override
	public boolean createTodo(Todo todo) {
		return todoRepository.createTodo(todo);
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
		return userTodoMappingRepository.getAllTodosByUserId(userId);
	}

	@Override
	public Todo getTodoById(int todoId) {
		return todoRepository.getTodoById(todoId);
	}

}