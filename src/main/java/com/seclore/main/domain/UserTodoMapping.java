package com.seclore.main.domain;

import java.util.List;

public class UserTodoMapping {
	User user;
	List<Todo> todoList;
	
	public UserTodoMapping() {
		// TODO Auto-generated constructor stub
	}

	public UserTodoMapping(User user, List<Todo> todoList) {
		super();
		this.user = user;
		this.todoList = todoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}

	@Override
	public String toString() {
		return "UserTodoMapping [user=" + user + ", todoList=" + todoList + "]";
	}
}
