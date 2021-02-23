package com.codigo.smartstore.webapi.domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "Customers")
public class Customer
		extends
		EntityModel

	implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 942321185028459955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUS_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUS_SEQ")
	private Long id;

	private String telephone;

	@Override
	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getTelephone() {

		return this.telephone;
	}

	public void setTelephone(final String telephone) {

		this.telephone = telephone;
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public boolean equals(final Object object) {

		if (isNull(object))
			return false;

		if (this == object)
			return true;

		if (!(object instanceof Customer))
			return false;

		final Customer customer = Customer.class.cast(object);

		return Objects.equals(this.id, customer.id);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public int hashCode() {

		return Objects.hash(this.id);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public String toString() {

		return "Customer [id=" + this.id
				+ ", telephone="
				+ this.telephone
				+ "]";
	}

}
