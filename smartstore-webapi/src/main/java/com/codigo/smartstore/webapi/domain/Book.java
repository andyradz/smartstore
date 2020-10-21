package com.codigo.smartstore.webapi.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.codigo.smartstore.webapi.generators.StringPrefixedSequenceIdGenerator;

@Entity
public class Book {

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "book_seq")
	@GenericGenerator(
		name = "book_seq",
		strategy = "com.codigo.smartstore.webapi.generators.StringPrefixedSequenceIdGenerator",
		parameters = {
			@Parameter(
				name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,
				value = "50"),
			@Parameter(
				name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
				value = "B_"),
			@Parameter(
				name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
				value = "%05d") })
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {

		return this.id;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		final Book other = (Book) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {

		return "Book [id=" + this.id
				+ "]";
	}
}
