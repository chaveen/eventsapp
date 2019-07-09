package org.devchavez.events.domain;

import java.util.Optional;

public class GetEventQueryResult {
	private final Optional<Event> result;
	
	public GetEventQueryResult(Optional<Event> event) {
		this.result = event;
	}

	public Optional<Event> getResult() {
		return result;
	}
}
