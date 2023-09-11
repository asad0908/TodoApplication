package com.seclore.todoapplication.model.todo;

public class TodoDTO {
	private String title, description, status;

	public TodoDTO() {
	}

	public TodoDTO(String title, String description, String status) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TodoDTO [title=" + title + ", description=" + description + ", status=" + status + "]";
	}

}
