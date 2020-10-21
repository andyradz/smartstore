/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package com.codigo.smartstore.database.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Customizer;

/**
 *
 * @author andrzej.radziszewski
 */
@Embeddable
@Customizer(EntityColumnPositionCustomizer.class)
public class EntityPublishedInfo {

	@Column(name = "PublishedDateUtc")
	@Temporal(TemporalType.DATE)
	@ColumnPosition(position = 97)
	private Date publishedDateUtc;

	@Column(name = "PublishedTimeUtc")
	@Temporal(TemporalType.TIME)
	@ColumnPosition(position = 98)
	private Date publishedTimeUtc;

	@Column(name = "PublishedByUser")
	@ColumnPosition(position = 99)
	private String publishedByUser;

	public Date getPublishedDateUtc() {

		return this.publishedDateUtc;
	}

	public void setPublishedDateUtc(final Date publishedDateUtc) {

		this.publishedDateUtc = publishedDateUtc;
	}

	public Date getPublishedTimeUtc() {

		return this.publishedTimeUtc;
	}

	public void setPublishedTimeUtc(final Date publishedTimeUtc) {

		this.publishedTimeUtc = publishedTimeUtc;
	}

	public Date getPublishedDate() {

		return this.publishedDateUtc;
	}

	public void setPublishedDate(final Date published) {

		this.publishedDateUtc = published;
	}

	public String getPublishedByUser() {

		return this.publishedByUser;
	}

	public void setPublishedByUser(final String publishedByUser) {

		this.publishedByUser = publishedByUser;
	}
}
