package com.seclore.main.repository.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.User;

@Component
public class UserRepository implements UserRepositoryInterface {
	
	private static final String CREATE_USER = "INSERT INTO user(name, mobile, email, password) VALUES (?, ?, ?, ?)";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email=?";
	private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean createUser(User user) {
		Object[] args = {user.getName(), user.getMobile(), user.getEmail(), user.getPassword()};
		int count = jdbcTemplate.update(CREATE_USER, args);
		return count > 0;
	}

	@Override
	public User getUserByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserRowMapper(), email);
	}

	@Override
	public User getUserById(int userId) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserRowMapper(), userId);
	}

}
