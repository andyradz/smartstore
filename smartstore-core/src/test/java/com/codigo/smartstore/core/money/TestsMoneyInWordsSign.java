package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Zestaw testów badania znaku (plus, minus) typu money")
class TestsMoneyInWordsSign {

	/**
	 * Znacznik wartości dodatniej liczby rzeczywistej
	 */
	private static final int POSITIVE_SIGN = 1;

	/**
	 * Znacznik wartości ujemnej liczby rzeczywistej
	 */
	private static final int NEGATIVE_SIGN = -1;

	@Test
	@DisplayName("Liczba 11.89557/oczekiwanie znaku liczby (+)")
	void shouldBeTrue_ForNoneSign() {

		final BigDecimal number = new BigDecimal("11.89557");

		final var sign = number.signum();

		assertThat(sign, equalTo(POSITIVE_SIGN));
	}

	@Test
	@DisplayName("Liczba +11.89557/oczekiwanie znaku liczby (+)")
	void shouldBeTrue_ForPlusSign() {

		final BigDecimal number = new BigDecimal("+11.89557");

		final var sign = number.signum();

		assertThat(sign, equalTo(POSITIVE_SIGN));
	}

	@Test
	@DisplayName("Liczba -11.89557/oczekiwanie znaku liczby (-)")
	void shouldBeTrue_ForMinusSign() {

		final BigDecimal number = new BigDecimal("-11.89557");

		final var sign = number.signum();

		assertThat(sign, equalTo(NEGATIVE_SIGN));
	}
}
