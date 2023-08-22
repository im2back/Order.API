package com.github.im2back.Order.Api.infra.teste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String msg = "Resource not found.";	
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error = new StandardError(status.value(), msg, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
		
	}
}
