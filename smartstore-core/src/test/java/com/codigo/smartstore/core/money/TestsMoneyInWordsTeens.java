package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.sequence.Sequence;

class TestsMoneyInWordsTeens {

	private static LongUnaryOperator hasTeens = item -> (((item % 100) / 10) == 1) && (((item % 100) % 10) != 0)
			? (item % 10)
				: 0;

	@Test
	void shouldBeTrue_Teens() {

		Sequence.sequence(11L, 919L, 100)
				.forEach(item -> {

					final var val = hasTeens.applyAsLong(item);
					System.out.println(String.format("%03d - %03d", item, val));
					assertThat((item % 10), equalTo(val));
				});
	}

	@Test
	void shouldBeFalse_Teens() {

		Sequence.sequence(20L, 110L, 1)
				.forEach(item -> {

					final var val = hasTeens.applyAsLong(item);
					System.out.println(String.format("%03d - %03d", item, val));
					assertThat(0L, equalTo(val));
				});
	}
}
