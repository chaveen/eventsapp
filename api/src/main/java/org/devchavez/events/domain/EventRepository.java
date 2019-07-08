package org.devchavez.events.domain;

import org.devchavez.events.persistence.PEvent;
import org.devchavez.events.persistence.PEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventRepository {

	private final PEventRepository repo;

	@Autowired
	public EventRepository(PEventRepository repo) {
		this.repo = repo;
	}

	public void create(Event event) {
		PEvent pEvent = this.toPEvent(event);
		
		this.repo.save(pEvent);
	}
	
	private PEvent toPEvent(Event event) {
		PEvent pEvent = new PEvent();
		
		pEvent.setId(event.getId());
		pEvent.setComponent(event.getComponent());
		pEvent.setCreatedAt(event.getCreatedAt());
		pEvent.setData(event.getData());
		pEvent.setEmail(event.getEmail());
		pEvent.setEnvironment(event.getEnvironment());
		pEvent.setMessage(event.getMessage());
		
		return pEvent;
	}
}
