package com.codigo.smartstore.webapi.domain;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(
	name = "Customers")
public class Customer {

	public static Customer fromCustomer(final Customer customer) {

		return new Customer(
				customer.getId(),
				customer.getTelephone(),
				customer.getFavorites(),
				customer.getCommunicationPreferences());
	}

	private @Id @GeneratedValue Long id;

	@Transient
	private String telephone;
	@Transient
	private List<String> favorites;
	@Transient
	private Map<String, Boolean> communicationPreferences;

	/**
	 * Podstawowy konstruktor obiektu klasy <code>Customer</code>
	 */
	public Customer() {

	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>Customer</code>
	 *
	 * @param id
	 * @param telephone
	 * @param favorites
	 * @param communicationPreferences
	 */
	public Customer(final Long id, final String telephone, final List<String> favorites,
			final Map<String, Boolean> communicationPreferences) {

		this(telephone, favorites, communicationPreferences);
		this.id = id;
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>Customer</code>
	 *
	 * @param telephone
	 * @param favorites
	 * @param communicationPreferences
	 */
	public Customer(final String telephone, final List<String> favorites,
			final Map<String, Boolean> communicationPreferences) {

		// Objects.requireNonNull(this.id);
		Objects.requireNonNull(telephone);
		Objects.requireNonNull(favorites);
		Objects.requireNonNull(communicationPreferences);

		this.telephone = telephone;
		this.favorites = favorites;
		this.communicationPreferences = communicationPreferences;
	}

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

	public Map<String, Boolean> getCommunicationPreferences() {

		return this.communicationPreferences;
	}

	/**
	 * @param communicationPreferences
	 */
	public void setCommunicationPreferences(final Map<String, Boolean> communicationPreferences) {

		this.communicationPreferences = communicationPreferences;
	}

	/**
	 * @return
	 */
	public List<String> getFavorites() {

		return this.favorites;
	}

	/**
	 * @param favorites
	 */
	public void setFavorites(final List<String> favorites) {

		this.favorites = favorites;
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
				+ ", favorites="
				+ this.favorites
				+ ", communicationPreferences="
				+ this.communicationPreferences
				+ "]";
	}

}
