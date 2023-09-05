package com.seclore.main.service;

import com.seclore.main.domain.User;

public interface UserServiceInterface {
	public boolean createUser(User user);
	public boolean validateUser(String username, String password);
	public User getUserById(int userId);
}
