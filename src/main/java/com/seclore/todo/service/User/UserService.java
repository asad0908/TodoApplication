package com.seclore.todo.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.todo.model.User;
import com.seclore.todo.repository.User.UserRepositoryInterface;
import com.seclore.todo.security.JWTUtil;

@Component
public class UserService implements UserServiceInterface {
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	UserRepositoryInterface userRepository;

	@Override
	public boolean createUser(User user) {
		return userRepository.createUser(user);
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

	@Override
	public String authenticateUserAndGetToken(User inputUser) {

		User user = userRepository.getUserByEmail(inputUser.getEmail());
		String inputPassword = inputUser.getPassword();
		if (user == null)
			return null;

		if (user.getPassword().equals(inputPassword) == false)
			return null;

		String userIdString = "" + user.getId();
		String token = jwtUtil.createToken(userIdString);
		return token;
	}

}
