package com.seclore.todoapplication.repository.User;

import com.seclore.todoapplication.model.user.User;

public interface UserRepositoryInterface {
	public boolean createUser(User user);
	public User getUserByEmail(String email);
	public User getUserById(int userId);
}
