package com.stg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomExcepHandler.class)
	public ResponseEntity<String> handleHere(CustomExcepHandler customExcepHandler){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customExcepHandler.getMessage());
	}
	
	@ExceptionHandler(CustomIOException.class)
	public ResponseEntity<String> handleHere(CustomIOException customIOException){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customIOException.getMessage());
	}
}
