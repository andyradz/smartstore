package com.codigo.smartstore.database.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ManagedEntityListener {

	@PrePersist
	public void onEntitySave(final Object o) {

		if (o instanceof ManagedEntityModel) {

			LocalDate.now(TimeZone.getTimeZone("UTC")
					.toZoneId());

			LocalTime.now(TimeZone.getTimeZone("UTC")
					.toZoneId());

			// EntityDateTime entityDtTm = new EntityDateTime();
			// final EntityCreatedInfo entityCreatedInfo = new EntityCreatedInfo();
			// entityDtTm.setEntityCreatedInfo(entityCreatedInfo);
			// entityCreatedInfo.setCreatedDateUtc(Date.valueOf(localDate));
			// entityCreatedInfo.setCreatedTimeUtc(Time.valueOf(localTime));
			//
			// var hj = new EntityLifeState();
			// hj.setEntityLifeState(EntityLifeStates.ACTIVE);
			// hj.setEntityAcceptState(EntityAcceptStates.PENDING);
			// audit.setEntityDateTime(entityDtTm);
			// audit.setEntityLifeState(hj);
		}
	}

	@PreUpdate
	public void onEntityUpdate(final Object o) {

		if (o instanceof ManagedEntityModel) {

			LocalDate.now(TimeZone.getTimeZone("UTC")
					.toZoneId());
			LocalTime.now(TimeZone.getTimeZone("UTC")
					.toZoneId());

			// final EntityDateTime entityDtTm = audit.getEntityDateTime();
			// final EntityUpdatedInfo entityUpdatedInfo = new EntityUpdatedInfo();
			// entityDtTm.setEntityUpdatedInfo(entityUpdatedInfo);
			// entityUpdatedInfo.setUpdatedDateUtc(Date.valueOf(localDate));
			// entityUpdatedInfo.setUpdatedTimeUtc(Time.valueOf(localTime));
			//
			// audit.setEntityDateTime(entityDtTm);
		}
	}
}
