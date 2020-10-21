package com.codigo.smartstore.database.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.eclipse.persistence.annotations.Customizer;

@Embeddable
@Customizer(EntityColumnPositionCustomizer.class)
public class EntityLifeState
	implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -869941512026063430L;

	@Enumerated(EnumType.STRING)
	@Column(name = "EntityLifeState", nullable = false)
	private EntityLifeStates entityLifeState = EntityLifeStates.NEW;

	@Enumerated(EnumType.STRING)
	@Column(name = "EntityAcceptState", nullable = false)
	private EntityAcceptStates entityAcceptState = EntityAcceptStates.PENDING;

	public EntityLifeStates getEntityLifeState() {

		return this.entityLifeState;
	}

	public void setEntityLifeState(final EntityLifeStates rowState) {

		this.entityLifeState = rowState;
	}

	public EntityAcceptStates getEntityAcceptState() {

		return this.entityAcceptState;
	}

	public void setEntityAcceptState(final EntityAcceptStates entityAcceptState) {

		this.entityAcceptState = entityAcceptState;
	}
}
