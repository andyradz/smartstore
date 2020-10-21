package com.codigo.smartstore.webapi.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Immutable;

@Embeddable

@Immutable
public class AgeType {

	@Min(0)
	@Max(Byte.MAX_VALUE)
	@ColumnDefault("0")
	@Column(name = "Age", nullable = false)

	private byte age;

	/**
	 * @return the age
	 */
	public byte getAge() {

		return this.age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(final byte age) {

		this.age = age;
	}
}
