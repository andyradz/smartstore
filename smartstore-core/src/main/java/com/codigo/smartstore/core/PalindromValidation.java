package com.codigo.smartstore.core;

import java.util.Objects;

/**
 * Weryfikacja wyrażenia typu palindromu
 * @author andrzej.radziszewski
 * @since 2021 // TODO: dodac opcje przetwazania tylko samuch znaków alfabetu
 */
public interface PalindromValidation {

	default boolean validate(final String palindrom) {

		if (Objects.isNull(palindrom))
			throw new NullPointerException("Brak instancji obiektu palindrom !");

		if (palindrom.isBlank() || (palindrom.isEmpty()))
			return false;

		var palindromUpper = palindrom.replaceAll("\\s+", "");
		palindromUpper = palindromUpper.toUpperCase();

		final var palindromLength = palindromUpper.length();

		for (int i = 0, j = palindromLength - 1; i <= j; i++, j--) {

			final var leftChar = palindromUpper.charAt(i);
			final var rightChar = palindromUpper.charAt(j);

			if (leftChar != rightChar)
				return false;
		}

		return true;
	}
}