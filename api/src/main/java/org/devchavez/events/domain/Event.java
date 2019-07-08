package org.devchavez.events.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Event {
	private UUID id;
	private OffsetDateTime createdAt;
	private String email;
	private String environment;
	private String component;
	private String message;
	private String data;

	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(updatable = false, nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(updatable = false, nullable = false)
	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(updatable = false, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(updatable = false, nullable = false)
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Column(updatable = false, nullable = false)
	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	@Column(updatable = false, nullable = false)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(updatable = false)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
