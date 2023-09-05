package com.seclore.main.service;

import java.util.List;

import com.seclore.main.domain.Todo;

public interface TodoServiceInterface {
	public boolean createTodo(Todo todo);
	public boolean editTodo(Todo todo);
	public boolean deleteTodo(int todoId);
	public List<Todo> getTodoListByUserId(int userId);
	public Todo getTodoById(int todoId);
}
