package com.seclore.todo.service.User;

import com.seclore.todo.model.user.User;

public interface UserServiceInterface {
	public boolean createUser(User user);
	public User getUserById(int userId);
	public String authenticateUserAndGetToken(User user);
}
