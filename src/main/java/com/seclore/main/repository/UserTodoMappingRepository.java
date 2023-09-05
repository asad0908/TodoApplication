package com.seclore.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Todo;
import com.seclore.main.domain.TodoRowMapper;

@Component
public class UserTodoMappingRepository implements UserTodoMappingRepositoryInterface {
	
	private static final String GET_ALL_TODOS_BY_USERID = "SELECT t.* from todo t, usertodomapping u WHERE t.id = u.todo_id and u.user_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Todo> getAllTodosByUserId(int userId) {
		return jdbcTemplate.query(GET_ALL_TODOS_BY_USERID, new TodoRowMapper(), userId);
	}

}
