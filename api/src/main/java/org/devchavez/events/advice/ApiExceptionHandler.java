package org.devchavez.events.advice;

import org.devchavez.events.domain.support.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<String> unexpectedException(final ValidationException ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
