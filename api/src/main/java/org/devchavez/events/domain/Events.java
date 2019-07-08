package org.devchavez.events.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Events {

	private final EventRepository repo;

	@Autowired
	public Events(EventRepository repo) {
		this.repo = repo;
	}
	
	public void handle(CreateEventCommand cmd) {
		if (cmd.getComponent() == null) {
			
		}
		
		Event event = new Event(null, 
				cmd.getCreatedAt(), 
				cmd.getEmail(), 
				cmd.getEnvironment(), 
				cmd.getComponent(), 
				cmd.getMessage(),
				cmd.getData());
		
		this.repo.create(event);
	}
}
