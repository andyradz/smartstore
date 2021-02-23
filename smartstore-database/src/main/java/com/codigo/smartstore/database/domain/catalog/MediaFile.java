package com.codigo.smartstore.database.domain.catalog;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.codigo.smartstore.database.domain.entity.ColumnPosition;
import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "MediaFile")
public class MediaFile
		extends
		EntityModel {

	private static final long serialVersionUID = -4003636065824439889L;

	@AttributeOverride(name = "id", column = @Column(name = "Id"))
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mediafile_generator")
	@TableGenerator(name = "mediafile_generator", initialValue = 0, allocationSize = 50)
	private Long id;

	@ColumnPosition(position = 1)
	@Column(name = "Name", nullable = false, unique = true, length = 50)
	private String name;

	@ColumnPosition(position = 2)
	@Column(name = "extension", nullable = true, unique = true, length = 50)
	private String extension;

	@ColumnPosition(position = 3)
	@Column(name = "MimeType", nullable = true, unique = true, length = 100)
	private String mimeType;

	@ColumnPosition(position = 4)
	@Column(name = "MediaType", nullable = true, unique = true, length = 100)
	private String mediaType;

	@ColumnPosition(position = 5)
	@Column(name = "Alt", nullable = true, unique = true, length = 100)
	private String alt;

	@ColumnPosition(position = 6)
	@Column(name = "Title", nullable = true, unique = true, length = 400)
	private String title;

	@ManyToOne()
	@JoinColumn(name = "CategoryId")
	private Category category;

	/**
	 * @return the category
	 */
	public Category getCategory() {

		return this.category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(final Category category) {

		this.category = category;
	}

	@Override
	public Long getId() {

		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {

		this.name = name;
	}
}
