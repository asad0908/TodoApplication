package com.seclore.main.service.User;

import com.seclore.main.domain.User;

public interface UserServiceInterface {
	public boolean createUser(User user);
	public User getUserById(int userId);
	public String authenticateUserAndGetToken(User user);
}
