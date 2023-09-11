package com.seclore.todo.service.Todo;

import java.util.List;

import com.seclore.todo.model.Todo;

public interface TodoServiceInterface {
	public boolean createTodo(Todo todo, int userId);
	public boolean editTodo(Todo todo);
	public boolean deleteTodo(int todoId);
	public List<Todo> getTodoListByUserId(int userId);
	public Todo getTodoById(int todoId);
}
