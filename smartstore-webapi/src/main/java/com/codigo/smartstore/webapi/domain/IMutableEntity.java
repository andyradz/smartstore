package com.codigo.smartstore.webapi.domain;

import java.time.LocalDate;

public interface IMutableEntity {

	LocalDate getEligibleDate();

	void setEligibleDate(LocalDate eligibleDate);
}
