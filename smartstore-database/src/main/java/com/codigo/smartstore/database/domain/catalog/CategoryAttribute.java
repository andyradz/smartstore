package com.codigo.smartstore.database.domain.catalog;

import java.util.Objects;

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

import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "CategoryAttribute")
public class CategoryAttribute
		extends
		EntityModel {

	private static final long serialVersionUID = 7651592702745185585L;

	@AttributeOverride(name = "id", column = @Column(name = "Id"))
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_attribute_generator")
	@TableGenerator(name = "category_attribute_generator", initialValue = 0, allocationSize = 50)
	protected Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Value")
	private String value;

	@Column(name = "Searchable")
	private Boolean searchable;

	@ManyToOne()
	@JoinColumn(name = "CategoryId")
	private Category category;

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public String getValue() {

		return this.value;
	}

	public void setValue(final String value) {

		this.value = value;
	}

	public Boolean getSearchable() {

		return this.searchable == null ? Boolean.FALSE : this.searchable;
	}

	public void setSearchable(final Boolean searchable) {

		this.searchable = searchable;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + Objects.hash(this.id, this.name, this.searchable, this.value);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;

		if (!super.equals(obj))
			return false;

		if (!(obj instanceof CategoryAttribute))
			return false;

		final CategoryAttribute other = CategoryAttribute.class.cast(obj);

		return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name)
				&& Objects.equals(this.searchable, other.searchable)
				&& Objects.equals(this.value, other.value);
	}

	@Override
	public Long getId() {

		return this.id;
	}

	public void setCategory(final Category category) {

		this.category = category;
	}

}
