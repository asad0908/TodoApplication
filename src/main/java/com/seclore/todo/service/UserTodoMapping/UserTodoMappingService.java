package com.seclore.todo.service.UserTodoMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.todo.repository.UserTodoMapping.UserTodoMappingRepositoryInterface;

@Component
public class UserTodoMappingService implements UserTodoMappingServiceInterface {
	
	@Autowired
	UserTodoMappingRepositoryInterface userTodoMappingRepository;

	@Override
	public boolean checkUserTodoMapping(String userId, String todoId) {
		return userTodoMappingRepository.checkUserTodoMapping(userId, todoId);
	}

}
