package org.devchavez.events.domain.support;

/**
 * Represents a Domail level validation exception
 *
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -2103791135905210453L;

	public ValidationException(String message) {
		super(message);
	}
}
