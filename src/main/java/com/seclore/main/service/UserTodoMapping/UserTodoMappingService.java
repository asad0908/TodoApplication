package com.seclore.main.service.UserTodoMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.repository.UserTodoMapping.UserTodoMappingRepositoryInterface;

@Component
public class UserTodoMappingService implements UserTodoMappingServiceInterface {
	
	@Autowired
	UserTodoMappingRepositoryInterface userTodoMappingRepository;

	@Override
	public boolean checkUserTodoMapping(String userId, String todoId) {
		return userTodoMappingRepository.checkUserTodoMapping(userId, todoId);
	}

	@Override
	public boolean createUserTodoMapping(int userId, int todoId) {
		return userTodoMappingRepository.createUserTodoMapping(userId, todoId);
	}

}
