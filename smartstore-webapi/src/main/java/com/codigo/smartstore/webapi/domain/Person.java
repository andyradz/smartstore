package com.codigo.smartstore.webapi.domain;

public abstract class Person
	implements IPerson {

	private AgeType age;

	@Override
	public FirstNameType getName() {

		return null;
	}

	@Override
	public SurnameType getSurname() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgeType getAge() {

		return this.age;
	}
}
