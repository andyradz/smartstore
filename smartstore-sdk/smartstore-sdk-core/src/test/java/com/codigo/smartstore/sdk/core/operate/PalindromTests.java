package com.codigo.smartstore.sdk.core.operate;

import static com.codigo.smartstore.sdk.core.opearte.SetOperator.union;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codigo.smartstore.sdk.core.opearte.IPalindromValidation;
import com.codigo.smartstore.sdk.core.opearte.RecursivePalindrom;

@DisplayName(value = "Testy wyrażenia typu palindrom")
class PalindromTests {

	@ParameterizedTest
	@ValueSource(
		strings = {
			"Kobyła ma mały bok", "Akta generała ma mała renegatka", "Ile Romanowi dała za ład Iwona moreli",
			"Łapał za kran a kanarka złapał", "Zakopane na pokaz", "Żartem dano nadmetraż", "A kilku tu klika", "radar",
			"rotor", "sedes", "senes", "sos", "towot", "jeż largo gra lżej", "udoi miś i miodu" })
	void testPalindrom(final String input) {

		final var palindromText = input;

		final var validator = new RecursivePalindrom();

		final var isPalindrom = validator.validate(palindromText);

		assertThat(true, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsEmpty() {

		final var palindromText = "";

		final var validator = new IPalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNotValid() {

		final var palindromText = "caz";

		final var validator = new IPalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNullExceptionValid() {

		final var validator = new IPalindromValidation() {};

		assertThrows(NullPointerException.class,
			(
			) -> {

				validator.validate(null);
			}

		);

		final Set<Integer> integers = Set.of(1, 3, 5);
		// final Set<Integer> integers1 = Set.of(1, 3, 5);
		final Set<Double> doubles = Set.of(2.1, 4.1, 6.1);
		final Set<Byte> bytes = Set.of((byte) -2, (byte) -4, (byte) -6, (byte) 5);
		Set<Number> numbers = union(integers, doubles);
		numbers = union(numbers, bytes);
		// numbers = union(numbers, integers1);

		numbers.stream()
				.map(item -> {

					if (item instanceof Integer)
						return (double) (int) item;
					else if (item instanceof Double)
						return (double) item;
					else if (item instanceof Byte)
						return (double) (byte) item;
					else
						return 0.0;
				})
				.sorted()
				.forEach(System.out::println);
	}
}
