package org.devchavez.events.api;

import java.util.List;

import org.devchavez.events.api.model.SearchCriteria;
import org.devchavez.events.api.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventApiImpl implements EventsApi {

	@Override
	public ResponseEntity<Void> createEvent(Event event) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
	
	@Override
    public ResponseEntity<List<Event>> searchEvent(SearchCriteria searchCriteria) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
