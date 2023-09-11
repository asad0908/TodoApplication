package com.seclore.todoapplication.repository.UserTodoMapping;

import java.util.List;

import com.seclore.todoapplication.model.todo.Todo;

public interface UserTodoMappingRepositoryInterface {
	public List<Todo> getAllTodosByUserId(int userId);
	public boolean checkUserTodoMapping(String userId, String todoId);
	public boolean createUserTodoMapping(int userId, int todoId);
}
