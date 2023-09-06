package com.seclore.main.service.User;

import com.seclore.main.domain.User;

public interface UserServiceInterface {
	public boolean createUser(User user);
	public boolean validateUser(String email, String password);
	public User getUserById(int userId);
}
