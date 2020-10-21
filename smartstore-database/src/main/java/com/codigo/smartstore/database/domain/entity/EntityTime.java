package com.codigo.smartstore.database.domain.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class EntityTime {

	@Temporal(TemporalType.TIME)
	private Date time;

	public Date getTime() {

		return this.time;
	}

	public void setTime(final Date time) {

		this.time = time;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.time);
	}

	@Override
	public boolean equals(final Object entity) {

		if (Objects.isNull(entity))
			return false;

		if (this == entity)
			return true;

		if (!(entity instanceof EntityTime))
			return false;

		final EntityTime other = EntityTime.class.cast(entity);

		return Objects.equals(this.time, other.time);
	}

	@Override
	public String toString() {

		return "EntityTime [time=" + this.time
				+ "]";
	}
}
