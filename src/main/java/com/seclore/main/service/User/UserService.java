package com.seclore.main.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.User;
import com.seclore.main.repository.User.UserRepositoryInterface;
import com.seclore.main.security.UserTodoAuthenticationProvider;

@Component
public class UserService implements UserServiceInterface {
	@Autowired
	private UserTodoAuthenticationProvider authenticationProvider;
	
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

	@Override
	public String authenticateUserAndGetToken(User inputUser) {
		//TODO improve this
		boolean validateUser = validateUser(inputUser.getEmail(), inputUser.getPassword());
		if(validateUser == false) return null;
		User u = getUserById(inputUser.getId());
		String userIdString = "" + u.getId();
		String token = authenticationProvider.createToken(userIdString);
		return token;
	}

}
