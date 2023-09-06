package com.seclore.main.repository.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seclore.main.domain.Todo;


@Component
public class TodoRepository implements TodoRepositoryInterface {
	
	private static final String CREATE_TODO = "INSERT INTO todo(title, description, status, deleted) VALUES (?, ?, ?, ?)";
	private static final String EDIT_TODO = "UPDATE todo SET title=?, description=?, status=?, deleted=? WHERE id=?";
	private static final String DELETE_TODO = "update todo SET deleted=true WHERE id=?";
	private static final String GET_TODO_BY_ID = "SELECT * FROM todo WHERE id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean createTodo(Todo todo) {
		Object[] args = {todo.getTitle(), todo.getDesc(), todo.getStatus(), todo.getIsDeleted()};
		int count = jdbcTemplate.update(CREATE_TODO, args);
		return count > 0;
	}

	@Override
	public boolean editTodo(Todo todo) {
		Object[] args = {todo.getTitle(), todo.getDesc(), todo.getStatus(), todo.getIsDeleted()};
		int count = jdbcTemplate.update(EDIT_TODO, args);
		return count > 0;
	}

	@Override
	public boolean deleteTodo(int todoId) {
		int count = jdbcTemplate.update(DELETE_TODO, todoId);
		return count > 0;
	}

	@Override
	public Todo getTodoById(int todoId) {
		return jdbcTemplate.queryForObject(GET_TODO_BY_ID, new TodoRowMapper(), todoId);
	}

}
