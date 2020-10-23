package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.sequence.Sequence;

/// https://marketplace.eclipse.org/content/snipmatch#group-details
// https://marketplace.eclipse.org/content/emmet-ex-zen-coding-eclipse-plugin#group-details

@DisplayName("Testy operatory wyznacznia liczby setek z wartości liczby")
class TestsMoneyInWordsHunds {

	/**
	 * Oprator wyznacznia setek z wartości liczby
	 */
	private static LongUnaryOperator hasHunds = item -> ((item / 100) % 100) != 0 ? (item / 100) : 0;

	@Test
	void shouldBeTrue_Hunds() {

		Sequence.sequence(100L, 199L, 1)
				.forEach(item -> {

					hasHunds.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(1L, equalTo(hasHunds.applyAsLong(item)));
				});
	}

	@Test
	void shouldBeFalse_Hunds() {

		Sequence.sequence(0L, 99L, 1)
				.forEach(item -> {

					hasHunds.applyAsLong(item);
					// System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, equalTo(hasHunds.applyAsLong(item)));
				});
	}
}
