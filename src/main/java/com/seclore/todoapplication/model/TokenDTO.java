package com.seclore.todoapplication.model;

import java.time.LocalDateTime;

public class TokenDTO {
	private String timestamp, token, expiry;

	TokenDTO() {
	}

	public TokenDTO(String token) {
		super();
		LocalDateTime now = LocalDateTime.now();
		this.timestamp = now.toString();
		this.token = token;
		this.expiry = now.plusHours(1).toString();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "TokenDTO [timestamp=" + timestamp + ", token=" + token + ", expiry=" + expiry + "]";
	}

}
