package com.codigo.smartstore.webapi.exceptions;

public class EmployeeNotFoundException
		extends
		RuntimeException {

	public EmployeeNotFoundException(final Long id) {

		super("Could not find employee " + id);
	}
}