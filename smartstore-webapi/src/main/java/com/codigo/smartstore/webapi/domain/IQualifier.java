package com.codigo.smartstore.webapi.domain;

public interface IQualifier {

	/**
	 * Odczytuje wartość kodu
	 *
	 * @return
	 */
	public String getCode();

	/**
	 * Odczytuje opis wartości kodu
	 *
	 * @return
	 */
	public String getDescription();

}
