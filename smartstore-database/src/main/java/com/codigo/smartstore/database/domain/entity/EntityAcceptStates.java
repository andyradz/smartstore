package com.codigo.smartstore.database.domain.entity;

public enum EntityAcceptStates {

	/**
	 * Stan obowiązywania zaakceptowany, zatwierdzony, obowiązujący
	 */
	APPROVED,

	/**
	 * Stan obowiązywania oczekujacy na zatwierdzenie
	 */
	PENDING,

	/**
	 * Stan obowiązywania anulowany, odwołany, nieaktywny
	 */
	CANCELLED
}
