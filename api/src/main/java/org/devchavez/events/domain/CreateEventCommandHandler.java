package org.devchavez.events.domain;

import org.devchavez.events.domain.support.CommandQueryHandler;
import org.devchavez.events.domain.support.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler for CreateEvent command
 */
@Component
public class CreateEventCommandHandler implements CommandQueryHandler<CreateEventCommand, CreateEventEvent> {

	private final EventRepository repo;

	@Autowired
	public CreateEventCommandHandler(EventRepository repo) {
		this.repo = repo;
	}

	@Override
	public CreateEventEvent handle(CreateEventCommand cmd) {
		this.validate(cmd);
		
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
	
	/**
	 * Validation logic goes in here
	 */
	private void validate(CreateEventCommand cmd) {
		if (cmd.getComponent() == null) {
			throw new ValidationException("Component field is mandatory");
		} else if (cmd.getEmail() == null) {
			throw new ValidationException("Email field is mandatory");
		} else if (cmd.getCreatedAt() == null) {
			throw new ValidationException("CreatedAt field is mandatory");
		} else if (cmd.getEnvironment() == null) {
			throw new ValidationException("Environment field is mandatory");
		}
	}
}
