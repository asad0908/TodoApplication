package com.seclore.main.repository.Todo;


import com.seclore.main.domain.Todo;

public interface TodoRepositoryInterface {
	public boolean createTodo(Todo todo);
	public boolean editTodo(Todo todo);
	public boolean deleteTodo(int todoId);
	public Todo getTodoById(int todoId);
	public int getLastInsertedTodoId();
}
