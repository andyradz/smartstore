package com.codigo.smartstore.database.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "EligibleDate" }) })
@MappedSuperclass
public abstract class MutableEntity
		extends
		EntityModel {

	private static final long serialVersionUID = -8898213911702720377L;

	@Temporal(TemporalType.DATE)
	@Column(name = "EligibleDate", nullable = false, updatable = false)
	@OrderBy("eligibleDate DESC")
	private Date eligibleDate;

	/**
	 * @return the eligibleDate
	 */
	public Date getEligibleDate() {

		return this.eligibleDate;
	}

	/**
	 * @param eligibleDate the eligibleDate to set
	 */
	public void setEligibleDate(final Date eligibleDate) {

		this.eligibleDate = eligibleDate;
	}

}
