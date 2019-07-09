package org.devchavez.events.domain.support;

public interface CommandQueryHandler<IN, OUT> {
	OUT handle(IN input);
}
