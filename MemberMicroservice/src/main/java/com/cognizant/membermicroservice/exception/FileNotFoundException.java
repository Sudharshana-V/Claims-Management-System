package com.cognizant.membermicroservice.exception;

public class FileNotFoundException extends RuntimeException{
	
	public FileNotFoundException(String message) {
		super(message);
	}

	public FileNotFoundException() {
		super();
	}
}
