package com.codigo.smartstore.webapi.domain.idef.pesel;

import java.time.LocalDate;
import java.util.Objects;

public class PeselNumber
	implements IPeselNumber {

	public static void main(final String[] args) {

		final var pesel = new PeselNumber(
				"79062601652");
		var val = pesel.getBirthdateYear();
		System.out.println(val);
		val = pesel.getBirthdateMonth();
		System.out.println(val);
		val = pesel.getBirthdateDay();
		System.out.println(val);
		final var val1 = pesel.getGender();
		System.out.println(val1);

		System.out.println(pesel.getBirthdate());
	}

	private final String peselNumber;

	public PeselNumber(final String peselNumber) {

		Objects.requireNonNull(peselNumber);

		this.peselNumber = peselNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIssuedBy() {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public short getBirthdateYear() {

		final var indexStart = (byte) 0;
		final var indexEnd = (byte) 2;

		return Short.parseShort(this.peselNumber.substring(indexStart, indexEnd));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getBirthdateMonth() {

		final var indexStart = (byte) 2;
		final var indexEnd = (byte) 4;

		return Byte.parseByte(this.peselNumber.substring(indexStart, indexEnd));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte getBirthdateDay() {

		final var indexStart = (byte) 4;
		final var indexEnd = (byte) 6;

		return Byte.parseByte(this.peselNumber.substring(indexStart, indexEnd));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocalDate getBirthdate() {

		final var year = this.getBirthdateYear();
		final var month = this.getBirthdateMonth();
		final var day = this.getBirthdateDay();

		return LocalDate.of(year, month, day);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public short getCentury() {

		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGender() {

		final var indexStart = (byte) 6;
		final var indexEnd = (byte) 10;

		final var temp = this.peselNumber.substring(indexStart, indexEnd);
		final var val = Byte.parseByte(temp.substring(3, 4));

		return (val % 2) == 0 ? "FEMALE" : "MALE";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		return Objects.hash(this.peselNumber);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;
		if (!(obj instanceof PeselNumber))
			return false;
		final PeselNumber other = (PeselNumber) obj;
		return Objects.equals(this.peselNumber, other.peselNumber);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return "PeselNumber [peselNumber=" + this.peselNumber
				+ "]";
	}
}
