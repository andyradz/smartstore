package com.codigo.smartstore.database.domain.common;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.codigo.smartstore.database.domain.entity.EntityCreatedInfo;
import com.codigo.smartstore.database.domain.entity.EntityTimestamp;
import com.codigo.smartstore.database.domain.entity.ManagedEntityModel;

public class AuditListener {

	@PrePersist
	public void onEntitySave(final Object o) {

		if (o instanceof ManagedEntityModel) {

			final LocalDate localDate = LocalDate.now(TimeZone.getTimeZone("UTC")
					.toZoneId());
			final LocalTime localTime = LocalTime.now(TimeZone.getTimeZone("UTC")
					.toZoneId());

			new EntityTimestamp();
			final EntityCreatedInfo entityCreatedInfo = new EntityCreatedInfo();
			// entityDtTm.setEntityCreatedInfo(entityCreatedInfo);
			entityCreatedInfo.setCreatedDateUtc(Date.valueOf(localDate));
			entityCreatedInfo.setCreatedTimeUtc(Time.valueOf(localTime));

			// audit.setEntityDateTime(entityDtTm);
		}
	}

	@PreUpdate
	public void onEntityUpdate(final Object o) {

		if (o instanceof ManagedEntityModel) {

			LocalDate.now(TimeZone.getTimeZone("UTC")
					.toZoneId());
			LocalTime.now(TimeZone.getTimeZone("UTC")
					.toZoneId());

			// final EntityTimestamp entityDtTm = audit.getEntityDateTime();
			// final EntityUpdatedInfo entityUpdatedInfo = new EntityUpdatedInfo();
			// entityDtTm.setEntityUpdatedInfo(entityUpdatedInfo);
			// entityUpdatedInfo.setUpdatedDateUtc(Date.valueOf(localNow));
			// entityUpdatedInfo.setUpdatedTimeUtc(Time.valueOf(localTime));

			// audit.setEntityDateTime(entityDtTm);
		}
	}

}
