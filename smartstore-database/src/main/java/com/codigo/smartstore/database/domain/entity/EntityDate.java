package com.codigo.smartstore.database.domain.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class EntityDate {

	@Temporal(TemporalType.DATE)
	private Date date;

	public Date getDate() {

		return this.date;
	}

	public void setDate(final Date createdDateUtc) {

		this.date = createdDateUtc;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.date);
	}

	@Override
	public boolean equals(final Object entity) {

		if (Objects.isNull(entity))
			return false;

		if (this == entity)
			return true;

		if (!(entity instanceof EntityDate))
			return false;

		final EntityDate other = EntityDate.class.cast(entity);

		return Objects.equals(this.date, other.date);
	}

	@Override
	public String toString() {

		return "EntityDate [date=" + this.date
				+ "]";
	}
}