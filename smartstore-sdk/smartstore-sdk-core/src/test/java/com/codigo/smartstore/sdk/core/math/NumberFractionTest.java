package com.codigo.smartstore.sdk.core.math;

import static com.codigo.smartstore.sdk.core.math.NumberFraction.fraction;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.math.NumberFraction.DecimalPrecision;

@DisplayName("Testy operatora precyzji miejsc po przecinku z zaookrągleniem")
class NumberFractionTest {

	@Test
	@DisplayName("Prezycja 6 dla wartości .7976931348623157")
	void shouldBeTruePrec6_From_797693134862315() {

		final double myFraction = fraction(1.7976931348623157, DecimalPrecision.PRECTO6);

		assertThat(0.797693d, equalTo(myFraction));
	}

	@Test
	@DisplayName("Prezycja 0 dla wartości .2276931348623157")
	void shouldBeTruePrec0_From_2276931348623157() {

		final double myFraction = fraction(61.2276931348623157, DecimalPrecision.PRECTO0);

		assertThat(.0d, equalTo(myFraction));
	}

	@Test
	@DisplayName("Prezycja 1 dla wartości .5576931348623157")
	void shouldBeTruePrec1_From_5576931348623157() {

		final double myFraction = fraction(61.5576931348623157, DecimalPrecision.PRECTO1);

		assertThat(.6d, equalTo(myFraction));
	}

	@Test
	@DisplayName("Prezycja 1 dla wartości .5476931348623157")
	void shouldBeTruePrec1_From_5476931348623157() {

		final double myFraction = fraction(61.5476931348623157, DecimalPrecision.PRECTO1);

		assertThat(.5d, equalTo(myFraction));
	}

}
