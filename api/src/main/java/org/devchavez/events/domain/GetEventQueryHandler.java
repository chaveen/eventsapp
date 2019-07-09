package org.devchavez.events.domain;

import java.util.Optional;

import org.devchavez.events.domain.support.CommandQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hanlder for GetEvent Query
 */
@Component
public class GetEventQueryHandler implements CommandQueryHandler<GetEventQuery, GetEventQueryResult> {

	private final EventRepository repo;

	@Autowired
	public GetEventQueryHandler(EventRepository repo) {
		this.repo = repo;
	}

	@Override
	public GetEventQueryResult handle(GetEventQuery query) {
		Optional<Event> oEvent = this.repo.get(query.getEventId());

		GetEventQueryResult result = new GetEventQueryResult(oEvent);

		return result;
	}

}
