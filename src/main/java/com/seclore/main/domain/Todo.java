package com.seclore.main.domain;

public class Todo {
	private int id;
	private String title, desc, status;
	boolean deleted;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(int id, String title, String desc, String status, boolean deleted) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.status = status;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getIsDeleted() {
		return deleted;
	}

	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", desc=" + desc + ", status=" + status + ", deleted=" + deleted
				+ "]";
	}
}
