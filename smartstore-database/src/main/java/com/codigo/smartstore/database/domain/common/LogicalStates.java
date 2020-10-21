package com.codigo.smartstore.database.domain.common;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public enum LogicalStates {

	@Enumerated
	YES,
	NO
}
