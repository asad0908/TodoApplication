package com.seclore.todo.service.User;

import com.seclore.todo.model.user.User;
import com.seclore.todo.model.user.UserDTO;

public interface UserServiceInterface {
	public boolean createUser(UserDTO user);
	public User getUserById(int userId);
	public String authenticateUserAndGetToken(User user);
}
