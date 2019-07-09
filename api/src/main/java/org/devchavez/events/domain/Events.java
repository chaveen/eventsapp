package org.devchavez.events.domain;

import java.util.List;
import java.util.Optional;

import org.devchavez.events.domain.support.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Events {

	private final EventRepository repo;

	@Autowired
	public Events(EventRepository repo) {
		this.repo = repo;
	}
	
	public CreateEventEvent handle(CreateEventCommand cmd) {
		if (cmd.getComponent() == null) {
			throw new ValidationException("Component field is mandatory");
		}
		
		Event event = new Event(null, 
				cmd.getCreatedAt(), 
				cmd.getEmail(), 
				cmd.getEnvironment(), 
				cmd.getComponent(), 
				cmd.getMessage(),
				cmd.getData());
		
		event = this.repo.create(event);
		
		CreateEventEvent result = new CreateEventEvent(event.getId());
		
		return result;
	}
	
	public GetEventQueryResult handle(GetEventQuery query) {
		Optional<Event> oEvent = this.repo.get(query.getEventId());
		
		GetEventQueryResult result = new GetEventQueryResult(oEvent);
		
		return result;
	}
	
	public SearchEventQueryResult handle(SearchEventQuery query) {
		List<Event> result = this.repo.search(query.getCreatedDate(), 
				query.getEmail(),
				query.getEnvironment(), 
				query.getComponent(), 
				query.getMessage());
		
		return new SearchEventQueryResult(result);
	}
}
