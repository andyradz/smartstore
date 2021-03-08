package com.codigo.smartstore.sdk.core.opearte;

import java.util.Objects;

/**
 * Implementacja operator weryfikacji czy ciąg znaków jest palindromem,
 * implementacja oparta na rekurencji
 *
 * @author andrzej/radziszewski
 * @version 1.0.0.1
 * @since 2021
 */
final public class RecursivePalindrom
	implements IPalindromValidation {

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean validate(final String palindrom) {

		if (Objects.isNull(palindrom))
			throw new NullPointerException("Brak instancji obiektu palindrom!");

		if (palindrom.isBlank() || (palindrom.isEmpty()))
			return false;

		var palindromUpper = palindrom.replaceAll("\\s+", "");
		palindromUpper = palindromUpper.toUpperCase();

		final var palindromLength = palindromUpper.length();

		return process(palindromUpper, 0, palindromLength - 1);
	}

	/**
	 * Przetwarzanie rekurencyjne ciągu znaków
	 *
	 * @param palindrom Ciąg znaków
	 * @param forward Pozycja z ciągu znaków licząc od lewej
	 * @param backward Pozycja z ciągu znaków licząc od prawej
	 * @return Wartość logiczna TRUE gdy wyrażenie jest palindromem wartość logiczna
	 * FALSE gdy wyrażenie nie jest palindromem
	 */
	static boolean process(final String palindrom, final int forward, final int backward) {

		if (forward == backward)
			return true;

		if (palindrom.charAt(forward) != palindrom.charAt(backward))
			return false;

		if (forward < (backward))
			process(palindrom, forward + 1, backward - 1);

		return true;
	}
}
