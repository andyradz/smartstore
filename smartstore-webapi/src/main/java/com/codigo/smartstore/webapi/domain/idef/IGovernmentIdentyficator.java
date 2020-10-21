package com.codigo.smartstore.webapi.domain.idef;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IGovernmentIdentyficator {

	/**
	 * Właściwość określa datę wydania
	 *
	 * @return
	 */
	default LocalDate getIssuedDate() {

		return LocalDate.now();
	}

	/**
	 * Właściwość określa czas wydania
	 *
	 * @return
	 */
	default LocalTime getIssuedIime() {

		return LocalTime.now();
	}

	/**
	 * Właściwość określa podmiot nadający numer
	 *
	 * @return
	 */
	String getIssuedBy();

	/**
	 * Właściwość określa datę ważności
	 *
	 * @return
	 */
	default LocalDate getExpireDate() {

		return LocalDate.MAX;
	}

	/**
	 * Właściwość określa czas ważności
	 *
	 * @return
	 */
	default LocalTime getExpireTime() {

		return LocalTime.MAX;
	}
}
