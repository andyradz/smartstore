package com.codigo.smartstore.webapi.domain;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Length;

@Embeddable

public class SurnameType {

	@Length(
		min = 0,
		max = 100)
	private String surName;

	/**
	 * Podstawowy konstruktor obiektu klasy <code>SurnameType</code>
	 */
	public SurnameType() {

	}

}