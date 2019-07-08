package org.devchavez.events.api;

import java.util.List;

import org.devchavez.events.api.model.Event;
import org.devchavez.events.api.model.SearchCriteria;
import org.devchavez.events.domain.CreateEventCommand;
import org.devchavez.events.domain.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventApiImpl implements EventsApi {

	private final Events events;

	@Autowired
	public EventApiImpl(Events events) {
		this.events = events;
	}
	
	@Override
	public ResponseEntity<Void> createEvent(Event event) {
		CreateEventCommand cmd = new CreateEventCommand(event.getCreatedAt(), 
				event.getEmail(), 
				event.getEnvironment(), 
				event.getComponent(), 
				event.getMessage(), 
				event.getData());
		
		this.events.handle(cmd);
		
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@Override
    public ResponseEntity<List<Event>> searchEvent(SearchCriteria searchCriteria) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
