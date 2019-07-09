package org.devchavez.events.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Event {
	private UUID id;
	private OffsetDateTime createdAt;
	private String email;
	private String environment;
	private String component;
	private String message;
	private String data;
	
	public Event(UUID id, 
			OffsetDateTime createdAt, 
			String email, 
			String environment, 
			String component, 
			String message,
			String data) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.email = email;
		this.environment = environment;
		this.component = component;
		this.message = message;
		this.data = data;
	}

	public UUID getId() {
		return id;
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
