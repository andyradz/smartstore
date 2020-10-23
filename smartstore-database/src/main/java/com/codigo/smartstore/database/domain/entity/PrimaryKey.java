package com.codigo.smartstore.database.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class PrimaryKey
	implements Serializable {

	// -----------------------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = -1528223225651711166L;
	UUID keyGuid;
	String keyName;
	Long keyId;

	// -----------------------------------------------------------------------------------------------------------------

	public PrimaryKey() {

		this("zero", 1L);
	}

	public PrimaryKey(final String keyName, final Long keyId) {

		this.keyGuid = UUID.randomUUID();
		this.keyName = keyName;
		this.keyId = keyId;
	}

	// -----------------------------------------------------------------------------------------------------------------

	public String getKeyName() {

		return this.keyName;
	}

	// -----------------------------------------------------------------------------------------------------------------

	public Long getKeyId() {

		return this.keyId;
	}

	// -----------------------------------------------------------------------------------------------------------------

	public UUID getKeyGuid() {

		return this.keyGuid;
	}

	// -----------------------------------------------------------------------------------------------------------------

	@Override
	public int hashCode() {

		return Objects.hash(this.keyName, this.keyGuid, this.keyId);
	}

	// -----------------------------------------------------------------------------------------------------------------

	@Override
	public boolean equals(final Object instance) {

		if (this == instance)
			return true;

		if ((instance == null) || (this.getClass() != instance.getClass()))
			return false;

		final PrimaryKey primaryKey = PrimaryKey.class.cast(instance);

		return((this.keyId == primaryKey.keyId) && this.keyGuid.equals(primaryKey.keyGuid));
	}

	// -----------------------------------------------------------------------------------------------------------------
}
