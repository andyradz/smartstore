package com.codigo.smartstore.database.domain.evidence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreditCard {

	@Column(name = "ccNumber")
	private String ccNumber;

	public String getCcNumber() {

		return this.ccNumber;
	}

	public void setCcNumber(final String ccNumber) {

		this.ccNumber = ccNumber;
	}

}
