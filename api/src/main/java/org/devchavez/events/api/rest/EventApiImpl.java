package org.devchavez.events.api.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.devchavez.events.api.rest.model.Event;
import org.devchavez.events.api.rest.model.EventReference;
import org.devchavez.events.api.rest.model.SearchCriteria;
import org.devchavez.events.domain.CreateEventCommand;
import org.devchavez.events.domain.CreateEventEvent;
import org.devchavez.events.domain.Events;
import org.devchavez.events.domain.GetEventQuery;
import org.devchavez.events.domain.GetEventQueryResult;
import org.devchavez.events.domain.SearchEventQuery;
import org.devchavez.events.domain.SearchEventQueryResult;
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
	public ResponseEntity<EventReference> createEvent(Event event) {
		CreateEventCommand cmd = new CreateEventCommand(event.getCreatedAt(), 
				event.getEmail(), 
				event.getEnvironment(), 
				event.getComponent(), 
				event.getMessage(), 
				event.getData());
		
		CreateEventEvent qResult = this.events.handle(cmd);
		
		EventReference result = new EventReference();
		result.setId(qResult.getEventId());
		
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
	
	@Override
	public ResponseEntity<Event> getEvent(UUID id) {
        GetEventQuery query = new GetEventQuery(id);
        
        GetEventQueryResult qResult = this.events.handle(query);
        
        Optional<Event> result = qResult.getResult().map(this::toAEvent);
        
        if (result.isPresent()) {
        	return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@Override
    public ResponseEntity<List<Event>> searchEvent(SearchCriteria searchCriteria) {
		SearchEventQuery query = new SearchEventQuery(searchCriteria.getCreatedDate(), 
				searchCriteria.getEmail(), 
				searchCriteria.getEnvironment(), 
				searchCriteria.getComponent(), 
				searchCriteria.getMessage());
		
		SearchEventQueryResult qResult = this.events.handle(query);
		
		List<Event> aEvents = qResult.getResults().stream().map(this::toAEvent).collect(Collectors.toList());
		
        return new ResponseEntity<>(aEvents, HttpStatus.OK);
    }
	
	private Event toAEvent(org.devchavez.events.domain.Event dEvent) {
		Event aEvent = new Event();
		
		aEvent.setId(dEvent.getId());
		aEvent.setComponent(dEvent.getComponent());
		aEvent.setCreatedAt(dEvent.getCreatedAt());
		aEvent.setData(dEvent.getData());
		aEvent.setEmail(dEvent.getEmail());
		aEvent.setEnvironment(dEvent.getEnvironment());
		aEvent.setMessage(dEvent.getMessage());
		
		return aEvent;
	}
}
