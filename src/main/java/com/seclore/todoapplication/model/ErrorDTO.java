package com.seclore.todoapplication.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorDTO {
	private String timestamp, status, error, message;
	
	public ErrorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDTO(HttpStatus status, String message) {
		super();
		this.timestamp = LocalDateTime.now().toString();
		this.status = status.toString();
		this.setError(status.name());
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorDTO [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message=" + message
				+ "]";
	}
	
	
}
