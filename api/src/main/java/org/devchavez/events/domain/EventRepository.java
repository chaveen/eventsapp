package org.devchavez.events.domain;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository extends SimpleJpaRepository<Event, UUID> {

	public EventRepository(Class<Event> domainClass, EntityManager em) {
		super(domainClass, em);
	}
	
	@Override
	public <S extends Event> S save(S event) {
		return event;
	}
}
