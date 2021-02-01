package com.codigo.smartstore.webapi.exceptions;

public class EmployeeNotFoundException
		extends
		RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -4638824455670080951L;

	public EmployeeNotFoundException(final Long id) {

		super("Could not find employee " + id);
	}
}