package com.codigo.smartstore.webapi.domain;

/**
 * Definicja osoby prawnej
 *
 * @author dp0470
 *
 */
public interface ILegalPerson
	extends ICompany {

	public enum LegalPersonType {

		/* skarb państwa */
		STATE_TREASURY,

		/* spółka zoo */
		LIMITED_COMPANY,

		/* spółka akcyjna */
		JOINTSTOCK_COMPANY,

		/* spółka europejska */
		EUROPEAN_COMPANY,

		/* bank */
		BANK,

		/* przedsiębiorstwo państwowe */
		STATEOWNED_ENTERPRISE,

		/* jednostka samorządu terytorialnego */
		LOCAL_GOVERNMENT_UNIT,

		/* spółdzielnia */
		COOPERATIVE,

		/* fundacja */
		FOUNDATION,

		/* kościół */
		CHURCH,

		/* uniwersytet */
		UNIVERSITY,

		/* stowarzyszenie */
		ASSOCIATION,

		/* związek zawodowy */
		TRADEUNION,

		/* partia polityczna */
		POLITICAL_PARTY
	}
}
