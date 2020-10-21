package com.codigo.smartstore.database.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Customizer;

@Embeddable
@Customizer(EntityColumnPositionCustomizer.class)
public class EntityDeletedInfo {

	@Column(name = "DeletedDateUtc")
	@Temporal(TemporalType.DATE)
	@ColumnPosition(position = 94)
	private Date deletedDateUtc;

	@Column(name = "DeletedTimeUtc")
	@Temporal(TemporalType.TIME)
	@ColumnPosition(position = 95)
	private Date deletedTimeUtc;

	@Column(name = "DeletedByUser")
	@ColumnPosition(position = 96)
	private String deletedByUser;

	public Date getDeletedDateUtc() {

		return this.deletedDateUtc;
	}

	public void setDeletedDateUtc(final Date deletedDateUtc) {

		this.deletedDateUtc = deletedDateUtc;
	}

	public Date getDeletedTimeUtc() {

		return this.deletedTimeUtc;
	}

	public void setDeletedTimeUtc(final Date deletedTimeUtc) {

		this.deletedTimeUtc = deletedTimeUtc;
	}

	public String getDeletedByUser() {

		return this.deletedByUser;
	}

	public void setDeletedByUser(final String deletedByUser) {

		this.deletedByUser = deletedByUser;
	}
}