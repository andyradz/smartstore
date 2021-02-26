package com.codigo.smartstore.webapi.dto;

import java.io.Serializable;

import com.codigo.smartstore.webapi.validators.FieldsValueMatch;

import io.swagger.annotations.ApiModelProperty;

@FieldsValueMatch.List({
	@FieldsValueMatch(field = "firstName", fieldMatch = "verifyFirstName", message = "FirstName do not match!"),
	@FieldsValueMatch(field = "lastName", fieldMatch = "verifyLastName", message = "LastName do not match!") })
public class EmployeeAdd
	implements Serializable {

	private static final long serialVersionUID = -5173509550820192350L;

	private Long id;

	@ApiModelProperty(name = "firstName", required = true, value = "??", notes = "employee first name")
	private String firstName;

	private String verifyFirstName;

	/**
	 * @return the verifyFirstName
	 */
	public String getVerifyFirstName() {

		return this.verifyFirstName;
	}

	/**
	 * @param verifyFirstName the verifyFirstName to set
	 */
	public void setVerifyFirstName(final String verifyFirstName) {

		this.verifyFirstName = verifyFirstName;
	}

	@ApiModelProperty(name = "lastName", required = true, value = "??", notes = "employee last name")
	private String lastName;
	private String verifyLastName;

	/**
	 * @return the verifyLastName
	 */
	public String getVerifyLastName() {

		return this.verifyLastName;
	}

	/**
	 * @param verifyLastName the verifyLastName to set
	 */
	public void setVerifyLastName(final String verifyLastName) {

		this.verifyLastName = verifyLastName;
	}

	private String role;
	private int size;

	/**
	 * @return the id
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(final String firstName) {

		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {

		this.lastName = lastName;
	}

	/**
	 * @return the role
	 */
	public String getRole() {

		return this.role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(final String role) {

		this.role = role;
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

}
