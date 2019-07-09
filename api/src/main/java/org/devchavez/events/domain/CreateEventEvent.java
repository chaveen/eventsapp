package org.devchavez.events.domain;

import java.util.UUID;

public class CreateEventEvent {
	private final UUID eventId;
	
	public CreateEventEvent(UUID eventId) {
		this.eventId = eventId;
	}

	public UUID getEventId() {
		return eventId;
	}
}
