package com.tarcio2020.salesSystem.services.exceptions;

public class DatabaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseException (String msg) {
		super(msg);
	}
}
