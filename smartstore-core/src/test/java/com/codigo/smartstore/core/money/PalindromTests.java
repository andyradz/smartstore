package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codigo.smartstore.core.PalindromValidation;

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

		final var validator = new PalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(true, equalTo(isPalindrom));

		assertThat(true, equalTo(Recursivepalindrom.check(input)));
	}

	@Test
	void testPalindrom_IsEmpty() {

		final var palindromText = "";

		final var validator = new PalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNotValid() {

		final var palindromText = "caz";

		final var validator = new PalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNullExceptionValid() {

		final var validator = new PalindromValidation() {};

		assertThrows(NullPointerException.class,
			(
			) -> {

				validator.validate(null);
			}

		);
	}
}

class Recursivepalindrom {

	static boolean check(final String palindrom) {

		if (Objects.isNull(palindrom))
			throw new NullPointerException("Brak instancji obiektu palindrom !");

		if (palindrom.isBlank() || (palindrom.isEmpty()))
			return false;

		var palindromUpper = palindrom.replaceAll("\\s+", "");
		palindromUpper = palindromUpper.toUpperCase();

		final var palindromLength = palindromUpper.length();

		return test(palindromUpper, 0, palindromLength - 1);
	}

	static boolean test(final String palindrom, final int forward, final int backward) {

		if (forward == backward)
			return true;

		if (palindrom.charAt(forward) != palindrom.charAt(backward))
			return false;

		if (forward < (backward))
			test(palindrom, forward + 1, backward - 1);

		return true;
	}

}
