package org.devchavez.events.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

	public Event create(Event event) {
		PEvent pEvent = this.toPEvent(event);
		
		this.repo.save(pEvent);
		
		event = this.toEvent(pEvent);
		
		return event;
	}
	
	public Optional<Event> get(UUID id) {
		Optional<PEvent> oEvent = this.repo.findById(id);
		
		return oEvent.map(this::toEvent);
	}
	
	public List<Event> search(LocalDate createdDate, 
			String email, 
			String environment, 
			String component,
			String message) {
		
		List<PEvent> pEvents = this.repo.search(Optional.ofNullable(createdDate).map(LocalDate::toString).orElse(null), 
				email, 
				environment, 
				component,
				message);
		
		return pEvents.stream().map(this::toEvent).collect(Collectors.toList());
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
	
	private Event toEvent(PEvent pEvent) {
		Event event = new Event(pEvent.getId(), 
				pEvent.getCreatedAt(), 
				pEvent.getEmail(), 
				pEvent.getEnvironment(), 
				pEvent.getComponent(), 
				pEvent.getMessage(), 
				pEvent.getData());
		
		return event;
	}
}
