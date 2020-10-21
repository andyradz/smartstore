package com.codigo.smartstore.database.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class EntityTimestamp
	implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1312924196021678035L;

	@Column(name = "Timestamp", nullable = false, insertable = false, updatable = false, columnDefinition = "datetime2")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public Date getTimestamp() {

		return this.timestamp;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.timestamp);
	}

	@Override
	public boolean equals(final Object entity) {

		if (Objects.isNull(entity))
			return false;

		if (this == entity)
			return true;

		if (!(entity instanceof EntityTimestamp))
			return false;

		final EntityTimestamp other = EntityTimestamp.class.cast(entity);

		return Objects.equals(this.timestamp, other.timestamp);
	}

	@Override
	public String toString() {

		return "EntityTimestamp [timestamp=" + this.timestamp
				+ "]";
	}
}
