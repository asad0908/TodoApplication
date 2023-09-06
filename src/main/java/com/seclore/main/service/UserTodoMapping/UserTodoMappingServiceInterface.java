package com.seclore.main.service.UserTodoMapping;

public interface UserTodoMappingServiceInterface {
	public boolean checkUserTodoMapping(String userId, String todoId);
	public boolean createUserTodoMapping(int userId, int todoId);
}
