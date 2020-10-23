package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.sequence.Sequence;

@DisplayName("Testy operatory wyznacznia liczby dziesiątek z wartości liczby")
class TestsMoneyInWordsTens {

	/**
	 * Oprator wyznacznia dziesiątek z wartości liczby
	 */
	private static LongUnaryOperator hasTens = item -> (((item / 10) % 10) != 1)
			|| ((((item / 10) % 10) == 1) && (((item) % 10) == 0)) ? ((item / 10) % 10) : 0;

	@Test
	void shouldBeTrue_Tens() {

		Sequence.sequence(20L, 29L, 1)
				.forEach(item -> {

					hasTens.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(2L, equalTo(hasTens.applyAsLong(item)));
				});
	}

	@Test
	void shouldBeFalse_Tens() {

		Sequence.sequence(11L, 19L, 1)
				.forEach(item -> {

					hasTens.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, equalTo(hasTens.applyAsLong(item)));
				});
	}

	@Test
	void shouldBeFalse_Tens1() {

		Sequence.sequence(0L, 9L, 1)
				.forEach(item -> {

					hasTens.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, equalTo(hasTens.applyAsLong(item)));
				});
	}

	@Test
	void shouldBeFalse_Tens2() {

		Sequence.sequence(11L, 911L, 100)
				.forEach(item -> {

					hasTens.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, equalTo(hasTens.applyAsLong(item)));
				});
	}

	@Test
	void shouldBeFalse_Tens3() {

		Sequence.sequence(20L, 99L, 1)
				.forEach(item -> {

					hasTens.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, not(equalTo(hasTens.applyAsLong(item))));
				});
	}
}
