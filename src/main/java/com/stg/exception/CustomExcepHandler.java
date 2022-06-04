package com.stg.exception;

public class CustomExcepHandler extends RuntimeException {
	private String message;

	
	
	public CustomExcepHandler() {
		super();
	}

	public CustomExcepHandler(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
}
