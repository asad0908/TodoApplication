package com.seclore.main.repository.UserTodoMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Todo;
import com.seclore.main.repository.Todo.TodoRowMapper;

@Component
public class UserTodoMappingRepository implements UserTodoMappingRepositoryInterface {
	
	private static final String GET_ALL_TODOS_BY_USERID = "SELECT t.* FROM todo t, usertodomapping u WHERE t.id = u.todo_id and u.user_id=? and t.deleted = false";
	private static final String GET_USER_TODO_MAPPING_COUNT = "SELECT count(*) FROM usertodomapping where user_id=? AND todo_id=?";
	private static final String CREATE_USER_TODO_MAPPING = "INSERT INTO usertodomapping(user_id, todo_id) VALUES (?, ?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Todo> getAllTodosByUserId(int userId) {
		return jdbcTemplate.query(GET_ALL_TODOS_BY_USERID, new TodoRowMapper(), userId);
	}

	@Override
	public boolean checkUserTodoMapping(String userId, String todoId) {
		Object[] args = {userId, todoId};
		int count = jdbcTemplate.queryForObject(GET_USER_TODO_MAPPING_COUNT, Integer.class, args);
		return count > 0;
	}

	@Override
	public boolean createUserTodoMapping(int userId, int todoId) {
		Object[] args = {userId, todoId};
		int count = jdbcTemplate.update(CREATE_USER_TODO_MAPPING, args);
		return count > 0;
	}

}
