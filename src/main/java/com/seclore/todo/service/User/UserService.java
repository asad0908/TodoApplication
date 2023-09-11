package com.seclore.todo.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.seclore.todo.model.user.User;
import com.seclore.todo.model.user.UserDTO;
import com.seclore.todo.repository.User.UserRepositoryInterface;
import com.seclore.todo.security.JWTUtil;

@Component
public class UserService implements UserServiceInterface {
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserRepositoryInterface userRepository;

	@Override
	public boolean createUser(UserDTO userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setMobile(userDto.getMobile());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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

		System.out.println(inputPassword);
		System.out.println(user.getPassword());
		
		if(passwordEncoder.matches(inputPassword, user.getPassword()) == false) {
			return null;
		}


		String userIdString = "" + user.getId();
		String token = jwtUtil.createToken(userIdString);
		return token;
	}

}
