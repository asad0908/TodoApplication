package com.seclore.todo.repository.Todo;


import com.seclore.todo.model.Todo;

public interface TodoRepositoryInterface {
	public boolean createTodo(Todo todo);
	public boolean editTodo(Todo todo);
	public boolean deleteTodo(int todoId);
	public Todo getTodoById(int todoId);
	public int getLastInsertedTodoId();
}
