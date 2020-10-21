package com.codigo.smartstore.database.domain.entity;

public enum EntityLifeStates {

	/**
	 * Stan rekordu encji roboczy
	 */
	NEW,

	/**
	 * Stan rekordu encji usuniętej
	 */
	DELETED,

	/**
	 * Stan rekordu encji zawieszonej
	 */
	SUSPENDED,

	/**
	 * Stan rekordu encji aktywnej
	 */
	ACTIVE
}
