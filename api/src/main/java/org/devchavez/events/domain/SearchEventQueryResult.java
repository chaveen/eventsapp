package org.devchavez.events.domain;

import java.util.List;

public class SearchEventQueryResult {
	private final List<Event> results;

	public SearchEventQueryResult(List<Event> results) {
		this.results = results;
	}

	public List<Event> getResults() {
		return results;
	}
}
