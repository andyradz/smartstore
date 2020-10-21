/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package com.codigo.smartstore.database.domain.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.eclipse.persistence.annotations.Customizer;

/**
 *
 * @author andrzej.radziszewski
 */
@Embeddable
@Customizer(EntityColumnPositionCustomizer.class)
public class EntityCreatedInfo {

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "date",
		column = @Column(name = "CreatedDateUtc", columnDefinition = "date")))
	@ColumnPosition(position = 91)
	EntityDate createdDateUtc;

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "time",
		column = @Column(name = "CreatedTimeUtc", columnDefinition = "time(7)")))
	@ColumnPosition(position = 92)
	EntityTime createdTimeUtc;

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "timestamp",
		column = @Column(name = "CreatedTimestampUtc", columnDefinition = "datetime2")))
	@ColumnPosition(position = 92)
	EntityTimestamp createdTimestampUtc;

	@Column(name = "CreatedByUser")
	@ColumnPosition(position = 93)
	private String createdByUser;

	public EntityCreatedInfo() {

		this.createdDateUtc = new EntityDate();
		this.createdTimeUtc = new EntityTime();
		this.createdTimestampUtc = new EntityTimestamp();
	}

	public Date getCreatedDateUtc() {

		return this.createdDateUtc.getDate();
	}

	public void setCreatedDateUtc(final Date createdDateUtc) {

		this.createdDateUtc.setDate(createdDateUtc);
	}

	public Date getCreatedTimeUtc() {

		return this.createdTimeUtc.getTime();
	}

	public void setCreatedTimeUtc(final Date createdTimeUtc) {

		this.createdTimeUtc.setTime(createdTimeUtc);
	}

	public String getCreatedByUser() {

		return this.createdByUser;
	}

	public void setCreatedByUser(final String createdByUser) {

		this.createdByUser = createdByUser;
	}
}
