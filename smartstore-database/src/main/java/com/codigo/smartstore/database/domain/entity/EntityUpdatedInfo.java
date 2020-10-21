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
public class EntityUpdatedInfo {

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "date",
		column = @Column(name = "UpdatedDateUtc", columnDefinition = "date")))
	@ColumnPosition(position = 94)
	EntityDate updatedDateUtc;

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "time",
		column = @Column(name = "UpdatedTimeUtc", columnDefinition = "time(7)")))
	@ColumnPosition(position = 95)
	EntityTime updatedTimeUtc;

	@Column(name = "UpdatedByUser")
	@ColumnPosition(position = 96)
	private String updatedByUser;

	public Date getUpdatedDateUtc() {

		return this.updatedDateUtc.getDate();
	}

	public EntityUpdatedInfo() {

		this.updatedDateUtc = new EntityDate();
		this.updatedTimeUtc = new EntityTime();
	}

	public void setUpdatedDateUtc(final Date updatedDateUtc) {

		this.updatedDateUtc.setDate(updatedDateUtc);
	}

	public Date getUpdatedTimeUtc() {

		return this.updatedTimeUtc.getTime();
	}

	public void setUpdatedTimeUtc(final Date updatedTimeUtc) {

		this.updatedTimeUtc.setTime(updatedTimeUtc);
	}

	public String getUpdatedByUser() {

		return this.updatedByUser;
	}

	public void setUpdatedByUser(final String updatedByUser) {

		this.updatedByUser = updatedByUser;
	}
}
