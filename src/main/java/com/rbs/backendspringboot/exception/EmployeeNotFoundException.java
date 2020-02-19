package com.rbs.backendspringboot.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7177752789874334515L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	

}
