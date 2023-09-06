package com.seclore.main.repository.UserTodoMapping;

import java.util.List;

import com.seclore.main.domain.Todo;

public interface UserTodoMappingRepositoryInterface {
	public List<Todo> getAllTodosByUserId(int userId);
	public boolean checkUserTodoMapping(String userId, String todoId);
}
