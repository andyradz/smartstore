package com.codigo.smartstore.database.domain.catalog;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.eclipse.persistence.annotations.Customizer;

import com.codigo.smartstore.database.domain.entity.ColumnPosition;
import com.codigo.smartstore.database.domain.entity.EntityColumnPositionCustomizer;
import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "Category")
@Customizer(EntityColumnPositionCustomizer.class)
public class Category
		extends
		EntityModel {

	private static final long serialVersionUID = 5195542005041435577L;

	@AttributeOverride(name = "id", column = @Column(name = "Id"))
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@TableGenerator(name = "category_generator", initialValue = 0, allocationSize = 50)
	private Long id;

	@ColumnPosition(position = 1)
	@Column(name = "Name", nullable = false, unique = true, length = 400)
	private String name;

	@ColumnPosition(position = 2)
	@Column(name = "FullName", nullable = true, unique = false, length = 400)
	private String fullName;

	@ColumnPosition(position = 3)
	@Column(name = "ExternalLink", nullable = true, unique = false, length = 255)
	private String externalLink;

	@ColumnPosition(position = 4)
	@Column(name = "BottomDescription", nullable = true, unique = false, length = 255)
	private String bottomDescription;

	@ColumnPosition(position = 5)
	@Column(name = "Description", nullable = true, unique = false, length = 512)
	private String description;

	@ColumnPosition(position = 6)
	@Column(name = "MetaKeywords", nullable = true, unique = false, length = 400)
	private String metaKeywords;

	@ColumnPosition(position = 7)
	@Column(name = "MetaTitle", nullable = true, unique = false, length = 400)
	private String metaTitle;

	@ColumnPosition(position = 8)
	@Column(name = "PageSizeOptions", nullable = true, unique = false, length = 200)
	private String pageSizeOptions;

	@ColumnPosition(position = 9)
	@Column(name = "Alias", nullable = false, unique = true, length = 100)
	private String alias;

	@OneToMany(mappedBy = "category")
	Set<CategoryAttribute> attributes = new HashSet<>();

	@OneToMany(mappedBy = "category", cascade = { CascadeType.ALL })
	Set<MediaFile> files = new HashSet<>();

	/**
	 * @return the files
	 */
	public Set<MediaFile> getFiles() {

		return this.files;
	}

	public void addAttribuite(final CategoryAttribute attribute) {

		attribute.setCategory(this);
		this.attributes.add(attribute);
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {

		return this.alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(final String alias) {

		this.alias = alias;
	}

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	@Override
	public Long getId() {

		return this.id;
	}

	public Set<CategoryAttribute> getAttributes() {

		return this.attributes;
	}

	@Override
	public String toString() {

		return "Category [id=" + this.id
				+ ", name="
				+ this.name
				+ ", fullName="
				+ this.fullName
				+ ", externalLink="
				+ this.externalLink
				+ ", bottomDescription="
				+ this.bottomDescription
				+ ", description="
				+ this.description
				+ ", metaKeywords="
				+ this.metaKeywords
				+ ", metaTitle="
				+ this.metaTitle
				+ ", pageSizeOptions="
				+ this.pageSizeOptions
				+ ", alias="
				+ this.alias
				+ ", attributes="
				+ this.attributes
				+ ", files="
				+ this.files
				+ "]";
	}
}
