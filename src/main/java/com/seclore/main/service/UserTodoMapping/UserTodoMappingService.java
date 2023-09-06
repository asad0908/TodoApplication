package com.seclore.main.service.UserTodoMapping;

import org.springframework.beans.factory.annotation.Autowired;

import com.seclore.main.repository.UserTodoMapping.UserTodoMappingRepositoryInterface;

public class UserTodoMappingService implements UserTodoMappingServiceInterface {
	
	@Autowired
	UserTodoMappingRepositoryInterface userTodoMappingRepository;

	@Override
	public boolean checkUserTodoMapping(int userId, int todoId) {
		return userTodoMappingRepository.checkUserTodoMapping(userId, todoId);
	}

}
