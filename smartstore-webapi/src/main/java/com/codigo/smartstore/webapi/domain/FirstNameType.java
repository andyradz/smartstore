package com.codigo.smartstore.webapi.domain;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class FirstNameType {

	@Length(
		min = 0,
		max = 50)
	private String firstName;

	public FirstNameType() {

	}
}
