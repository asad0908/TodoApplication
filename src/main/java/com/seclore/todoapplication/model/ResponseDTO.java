package com.seclore.todoapplication.model;

import java.time.LocalDateTime;

public class ResponseDTO {
	private String timestamp;
	private String message;
	
	public ResponseDTO() {
	}

	public ResponseDTO(String message) {
		super();
		this.timestamp = LocalDateTime.now().toString();
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseDTO [timestamp=" + timestamp + ", message=" + message + "]";
	}
	
	
}
