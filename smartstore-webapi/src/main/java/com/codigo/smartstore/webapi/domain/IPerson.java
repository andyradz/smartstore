package com.codigo.smartstore.webapi.domain;

import java.time.LocalDate;

public interface IPerson {

	FirstNameType getName();

	SurnameType getSurname();

	AgeType getAge();

	LocalDate getBirthDate();

	String getGender();
}

// white race
// black race
// yellow race
// population