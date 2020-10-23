package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testy wyznaczania poszczególnych części wartości liczby")
class TestMoneyInWordsParts {

	@Test
	void shouldBeTrue_IntegerPart_Plus_11() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal("11.89557", mathContext);

		final var longPart = BigDecimal.valueOf(number.longValue());

		assertThat(11L, equalTo(longPart.longValue()));
	}

	@Test
	void shouldBeTrue_IntegerPart_Plus_0() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal("0.89557", mathContext);

		final var longPart = BigDecimal.valueOf(number.longValue());

		assertThat(
			0L, equalTo(longPart.longValue()));
	}

	@Test
	void shouldBeTrue_IntegerPart_Plus_1_000_000() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal(
				"1000000.89557", mathContext);

		final var longPart = BigDecimal.valueOf(number.longValue());

		assertThat(
			1_000_000L, equalTo(longPart.longValue()));
	}

	@Test
	void shouldBeTrue_IntegerPart_Plus_500() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal("500", mathContext);

		final var longPart = BigDecimal.valueOf(number.longValue());

		assertThat(
			500L, equalTo(longPart.longValue()));
	}

	@Test
	void shouldBeTrue_IntegerPart_Minus_800() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal("-800", mathContext);

		final var longPart = BigDecimal.valueOf(number.longValue());

		assertThat(-800L, equalTo(longPart.longValue()));
	}

	@Test
	void shouldBeTrue_FractionPart_Minus_0() {

		final MathContext mathContext = new MathContext(3);

		final BigDecimal number = new BigDecimal("-0", mathContext);

		final var fractionPart = BigDecimal.valueOf(number.longValue() % 1);

		assertThat(
			.0d, equalTo(fractionPart.doubleValue()));
	}

}
