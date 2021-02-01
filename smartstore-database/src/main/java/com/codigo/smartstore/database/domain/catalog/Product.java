package com.codigo.smartstore.database.domain.catalog;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Customizer;

import com.codigo.smartstore.database.domain.entity.ColumnPosition;
import com.codigo.smartstore.database.domain.entity.EntityColumnPositionCustomizer;
import com.codigo.smartstore.database.domain.entity.EntityDate;
import com.codigo.smartstore.database.domain.entity.EntityModel;

/**
 * @author andrzej.radziszewski
 *
 */
@Entity
@Customizer(EntityColumnPositionCustomizer.class)
@Table(name = "Products")
public class Product
		extends
		EntityModel {

	private static final long serialVersionUID = -1399154554678035069L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@TableGenerator(name = "product_generator", initialValue = 0, allocationSize = 50)
	private Long id;

	@Column(name = "name", nullable = false, unique = true, length = 150)
	@ColumnPosition(position = 1)
	private String name;

	@Column(name = "CatalogNumber")
	private String catalogNumber;

	@Column(name = "SerialNumber")
	private String serialNumber;

	@Embedded
	@AttributeOverrides(@AttributeOverride(
		name = "date",
		column = @Column(name = "BuildDate", columnDefinition = "date")))
	private EntityDate buildDate;

	@Column(name = "MadeIn")
	private String madeIn;

	@ColumnPosition(position = 2)
	@Column(name = "price", nullable = false)
	private Double price;

	@ColumnPosition(position = 3)
	@Column(name = "createdDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date createdDate;

	@ColumnPosition(position = 4)
	@Column(name = "createdTime", nullable = false)
	@Temporal(TemporalType.TIME)
	private java.util.Date createdTime;

	@ElementCollection
	@CollectionTable(name = "dimenssions", joinColumns = @JoinColumn(name = "id"))
	private Set<Dimension> dimension;

	public Product() {

		super();
	}

	public String getName(final int pix) {

		var zmienna = 100;
		zmienna += +1;

		System.out.println(zmienna);

		return this.name;
	}

	public Double getPrice() {

		return this.price;
	}

	public void setPrice(final Double price) {

		this.price = price;
	}

	public void setName(final String name) {

		this.name = name;
	}

	/**
	 * @return
	 */
	public java.util.Date getCreatedDate() {

		return this.createdDate;
	}

	public void setCreatedDate(final java.util.Date createdDate) {

		this.createdDate = createdDate;
	}

	public java.util.Date getCreatedTime() {

		return this.createdTime;
	}

	public void setCreatedTime(final java.util.Date createdTime) {

		this.createdTime = createdTime;
	}

	public Set<Dimension> getDimension() {

		return this.dimension;
	}

	public void setDimension(final Set<Dimension> dimension) {

		this.dimension = dimension;
	}

	@Override
	public String toString() {

		return this.name + " "
				+ this.price;
	}

	@Override
	public Long getId() {

		// TODO Auto-generated method stub
		return this.id;
	}

}
