package com.seclore.main.repository;

import java.util.List;

import com.seclore.main.domain.Todo;

public interface UserTodoMappingRepositoryInterface {
	public List<Todo> getAllTodosByUserId(int userId);
}
