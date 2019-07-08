package org.devchavez.events.domain;

import java.time.OffsetDateTime;

public class CreateEventCommand {
	private OffsetDateTime createdAt;
	private String email;
	private String environment;
	private String component;
	private String message;
	private String data;
	
	public CreateEventCommand(OffsetDateTime createdAt, String email, String environment, String component,
			String message, String data) {
	
		this.createdAt = createdAt;
		this.email = email;
		this.environment = environment;
		this.component = component;
		this.message = message;
		this.data = data;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
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

	public String getData() {
		return data;
	}
}
