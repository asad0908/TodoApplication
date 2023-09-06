package com.seclore.main.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.User;
import com.seclore.main.repository.User.UserRepositoryInterface;

@Component
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepositoryInterface userRepository;

	@Override
	public boolean createUser(User user) {
		return userRepository.createUser(user);
	}

	@Override
	public boolean validateUser(String email, String password) {
		User user = userRepository.getUserByEmail(email);
		if(user != null) return user.getPassword() == password;
		return false;
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

}
