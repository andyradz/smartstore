package com.codigo.smartstore.webapi.domain;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Embeddable
public final class Qualifier
	implements IQualifier {

	@Min(4)
	@Max(4)
	final private String code;

	@Min(0)
	@Max(50)
	final private String description;

	/**
	 * Podstawowy konstruktor obiektu klasy <code>Qualifier</code>
	 *
	 * @param code Wartość kodu
	 * @param description Opis wartości kodu
	 */
	public Qualifier(final String code, final String description) {

		super();

		requireNonNull(code);
		requireNonNull(description);

		this.code = code;
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCode() {

		return this.code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		return hash(this.code, this.description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {

		return this.description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object object) {

		if (isNull(object))
			return false;

		if (this == object)
			return true;

		if (!(object instanceof Qualifier))
			return false;

		final Qualifier other = Qualifier.class.cast(object);
		return Objects.equals(this.code, other.code) && Objects.equals(this.description, other.description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return "Qualifier [code=" + this.code
				+ ", description="
				+ this.description
				+ "]";
	}
}
