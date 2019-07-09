package org.devchavez.events.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Event Command/Query handler. Delegates Event related Commands and
 * Queries to appropriate singular Command/Query handlers
 *
 */
@Service
public class Events {

	private final CreateEventCommandHandler createEventHandler;
	private final SearchEventQueryHandler searchEventQueryHandler;
	private final GetEventQueryHandler getEventQueryHandler;

	/*
	 * FIXME: Need to find type enforced delegator method, But 
	 * the initial thought of having
	 * 
	 * public class Event implements CommandQueryHandler<CreateEventCommandHandler, CreateEventCommandEvent>,
	 * 		CommandQueryHandler<GetEventQuery, GetEventQueryResult>,
	 * 		CommandQueryHandler<SearchEventQuery, SearchEventQueryResult> {} 
	 * 
	 * didn't work because of a short coming of Java Compiler
	 */
	@Autowired
	public Events(CreateEventCommandHandler createEventHandler,
			SearchEventQueryHandler searchEventQueryHandler,
			GetEventQueryHandler getEventQueryHandler) {
		this.createEventHandler = createEventHandler;
		this.searchEventQueryHandler = searchEventQueryHandler;
		this.getEventQueryHandler = getEventQueryHandler;
	}
	
	public CreateEventEvent handle(CreateEventCommand cmd) {
		return this.createEventHandler.handle(cmd);
	}
	
	public GetEventQueryResult handle(GetEventQuery query) {
		return this.getEventQueryHandler.handle(query);
	}
	
	public SearchEventQueryResult handle(SearchEventQuery query) {
		return this.searchEventQueryHandler.handle(query);
	}
	
}
