package com.seclore.todo.repository.Todo;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.todo.model.todo.Todo;

public class TodoRowMapper implements RowMapper<Todo> {

	@Override
	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String description = rs.getString("description");
		String status = rs.getString("status");
		boolean deleted = rs.getBoolean("deleted");
		return new Todo(id, title, description, status, deleted);
	}

}
