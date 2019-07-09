package org.devchavez.events.domain;

import java.util.List;

import org.devchavez.events.domain.support.CommandQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler for SearchEvent Query
 *
 */
@Component
public class SearchEventQueryHandler implements CommandQueryHandler<SearchEventQuery, SearchEventQueryResult> {

	private final EventRepository repo;

	@Autowired
	public SearchEventQueryHandler(EventRepository repo) {
		this.repo = repo;
	}

	@Override
	public SearchEventQueryResult handle(SearchEventQuery query) {
		List<Event> result = this.repo.search(query.getCreatedDate(), 
				query.getEmail(),
				query.getEnvironment(), 
				query.getComponent(), 
				query.getMessage());
		
		return new SearchEventQueryResult(result);
	}

}
