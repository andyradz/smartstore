package com.codigo.smartstore.webapi.domain.idef.pesel;

import java.time.LocalDate;

import com.codigo.smartstore.webapi.domain.idef.IGovernmentIdentyficator;

public interface IPeselNumber
	extends IGovernmentIdentyficator {

	/**
	 * pobierz rok urodzenia
	 *
	 * @return
	 */
	short getBirthdateYear();

	/**
	 * pobierz miesiąć urodzenia
	 */
	byte getBirthdateMonth();

	/**
	 * pobierz dzień urodzenia
	 */
	byte getBirthdateDay();

	/**
	 * pobierz wiek urodzenia
	 */
	short getCentury();

	/**
	 * pobierz datę urodzenia
	 */
	LocalDate getBirthdate();

	/**
	 * pobierz płeć
	 */
	String getGender();
}
