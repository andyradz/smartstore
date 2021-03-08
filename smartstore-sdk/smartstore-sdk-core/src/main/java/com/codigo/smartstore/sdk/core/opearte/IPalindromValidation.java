package com.codigo.smartstore.sdk.core.opearte;

import java.util.Objects;

/**
 * Operator weryfikacja wyrażenia typu palindromu
 * @author andrzej.radziszewski
 * @since 2021
 * @category operator
 */
public interface IPalindromValidation {

	/**
	 * Weryfikacja ciągu znaków w konkekście występowania wyrażenia typu palindrom
	 *
	 * @param palindrom Ciąg znaków
	 * @return Wartość logiczna TRUE - obiekt jest palindromem, wartość FALSE -
	 * obiekt nie jest palindromem
	 */
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