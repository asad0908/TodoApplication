package com.seclore.todo.repository.User;

import com.seclore.todo.model.User;

public interface UserRepositoryInterface {
	public boolean createUser(User user);
	public User getUserByEmail(String email);
	public User getUserById(int userId);
}
