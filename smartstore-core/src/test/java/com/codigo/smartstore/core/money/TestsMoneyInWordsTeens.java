package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.sequence.Sequence;

@DisplayName("Testy operatory wyznacznia liczby nastek z wartości liczby")
class TestsMoneyInWordsTeens {

	private static final LongUnaryOperator hasTeens = item -> (1 == ((item % 100) / 10)) && ((0 != ((item % 100) % 10)))
			? (item % 10)
				: 0;

	@Test
	@DisplayName("Test wyznaczania nastek z zakresu wartości [11...919]")
	void shouldBeTrue_Teens() {

		Sequence.sequence(11L, 919L, 100)
				.forEach(item -> {

					final var val = hasTeens.applyAsLong(item);
					assertThat((item % 10), equalTo(val));
				});
	}

	@Test
	@DisplayName("Test wyznaczania nastek z zakresu wartości [20...110]")
	void shouldBeFalse_Teens() {

		Sequence.sequence(20L, 110L, 1)
				.forEach(item -> {

					final var val = hasTeens.applyAsLong(item);
					assertThat(0L, equalTo(val));
				});

	}
}
