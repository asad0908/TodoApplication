package com.seclore.main.service.Todo;

import java.util.List;

import com.seclore.main.domain.Todo;

public interface TodoServiceInterface {
	public boolean createTodo(Todo todo, int userId);
	public boolean editTodo(Todo todo);
	public boolean deleteTodo(int todoId);
	public List<Todo> getTodoListByUserId(int userId);
	public Todo getTodoById(int todoId);
}
