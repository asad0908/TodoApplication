package com.seclore.main.repository.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.main.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String mobile = rs.getString("mobile");
		String email = rs.getString("email");
		String password = rs.getString("password");
		return new User(id, name, mobile, email, password);
	}
	
}
