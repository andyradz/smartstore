package com.codigo.smartstore.webapi.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

// @Data
@Entity
public class Employee
	implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -110335657004177699L;

	private @Id @GeneratedValue Long id;

	private String firstName;
	private String lastName;
	private String role;
	private int size;

	@ElementCollection
	@CollectionTable(name = "employee_phone", joinColumns = @JoinColumn(name = "employee_id"))
	private List<Phone> phones;

	public Employee() {

	}

	public Employee(final String firstName, final String lastName, final String role) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getRole() {

		return this.role;
	}

	public void setRole(final String role) {

		this.role = role;
	}

	public String getName() {

		return this.firstName + " "
				+ this.lastName;
	}

	public void setName(final String name) {

		final String[] parts = name.split(" ");

		this.firstName = parts[0];
		this.lastName = parts[1];
	}

	/**
	 * @return the size
	 */
	public int getSize() {

		return this.size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(final int size) {

		this.size = size;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.firstName, this.id, this.lastName, this.phones, this.role, this.size);
	}

	@Override
	public boolean equals(final Object object) {

		if (this == object)
			return true;

		if (!(object instanceof Employee))
			return false;

		final Employee other = Employee.class.cast(object);

		return Objects.equals(this.firstName, other.firstName) && Objects.equals(this.id, other.id)
				&& Objects.equals(this.lastName, other.lastName)
				&& Objects.equals(this.phones, other.phones)
				&& Objects.equals(this.role, other.role)
				&& Objects.equals(this.size, other.size);
	}

	@Override
	public String toString() {

		return "Employee [id=" + this.id
				+ ", firstName="
				+ this.firstName
				+ ", lastName="
				+ this.lastName
				+ ", role="
				+ this.role
				+ ", size="
				+ this.size
				+ ", phones="
				+ this.phones
				+ "]";
	}

}