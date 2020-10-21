package com.codigo.smartstore.webapi.domain;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class MiddleNameType {

	@Length(
		min = 0,
		max = 100)
	private String middleName;
}