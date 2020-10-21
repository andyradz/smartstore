package com.codigo.smartstore.database.domain.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Table(name = "ManagedEtityModel")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(value = ManagedEntityListener.class)
@MappedSuperclass
public abstract class ManagedEntityModel
		extends
		EntityModel
	implements Serializable {

	private static final long serialVersionUID = 9210202540912189346L;

	@Embedded
	@ColumnPosition(position = -4)
	private EntityTimestamp entityTimestamp;

	@Embedded
	@ColumnPosition(position = -5)
	private EntityLifeState entityLifeState;

	public EntityTimestamp getEntityDateTime() {

		return this.entityTimestamp;
	}

	public void setEntityDateTime(final EntityTimestamp metainfo) {

		this.entityTimestamp = metainfo;
	}

	public EntityLifeState getEntityLifeState() {

		return this.entityLifeState;
	}

	public void setEntityLifeState(final EntityLifeState entityState) {

		this.entityLifeState = entityState;
	}
}
