package org.devchavez.events.domain;

import java.time.LocalDate;

public class SearchEventQuery {
	private LocalDate createdDate;
	private String email;
	private String environment;
	private String component;
	private String message;
	
	public SearchEventQuery(LocalDate createdDate, String email, String environment, String component,
			String message) {
		
		this.createdDate = createdDate;
		this.email = email;
		this.environment = environment;
		this.component = component;
		this.message = message;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public String getEmail() {
		return email;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getComponent() {
		return component;
	}

	public String getMessage() {
		return message;
	}
}
