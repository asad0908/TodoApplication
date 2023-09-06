package com.seclore.main.repository.User;

import com.seclore.main.domain.User;

public interface UserRepositoryInterface {
	public boolean createUser(User user);
	public User getUserByEmail(String email);
	public User getUserById(int userId);
}
