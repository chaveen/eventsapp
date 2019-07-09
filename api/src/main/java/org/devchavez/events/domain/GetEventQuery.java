package org.devchavez.events.domain;

import java.util.UUID;

public class GetEventQuery {
	private final UUID eventId;

	public GetEventQuery(UUID eventId) {
		this.eventId = eventId;
	}

	public UUID getEventId() {
		return eventId;
	}
}
