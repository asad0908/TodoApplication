package com.seclore.todoapplication.service.User;

import com.seclore.todoapplication.model.user.LoginUserDTO;
import com.seclore.todoapplication.model.user.SignUpUserDTO;
import com.seclore.todoapplication.model.user.User;

public interface UserServiceInterface {
	public boolean createUser(SignUpUserDTO user);
	public User getUserById(int userId);
	public String authenticateUserAndGetToken(LoginUserDTO user);
}
