package com.stg.exception;

import java.io.IOException;

public class CustomIOException extends IOException {
	private String message;

	public CustomIOException() {
		super();
	}

	public CustomIOException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
