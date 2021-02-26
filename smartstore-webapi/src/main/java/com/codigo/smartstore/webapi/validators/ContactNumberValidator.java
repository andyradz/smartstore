package com.codigo.smartstore.webapi.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator
	implements ConstraintValidator<ContactNumberConstraint, String> {

	@Override
	public void initialize(final ContactNumberConstraint contactNumber) {

	}

	@Override
	public boolean isValid(final String contactField, final ConstraintValidatorContext cxt) {

		return (contactField != null) && contactField.matches("[0-9]+")
				&& (contactField.length() > 8)
				&& (contactField.length() < 14);
	}
}
