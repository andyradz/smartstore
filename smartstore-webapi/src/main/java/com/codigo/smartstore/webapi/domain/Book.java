package com.codigo.smartstore.webapi.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "Book")
public class Book
		extends
		EntityModel
	implements Serializable {

	private static final long serialVersionUID = -6038802999200941194L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ")
	@SequenceGenerator(sequenceName = "book_seq", allocationSize = 1, name = "BOOK_SEQ")
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	public String name;

	@Override
	public int hashCode() {

		return Objects.hash(this.id, this.name);
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

	@Override
	public Long getId() {

		return this.getId();
	}
}
