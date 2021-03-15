package com.codigo.smartstore.sdk.core.opearte;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetOperator {

	public static <E> Set<E> union(final Set<? extends E> set1, final Set<? extends E> set2) {

		if (Objects.isNull(set1))
			throw new NullPointerException("Brak referencji zbioru set1!");

		if (Objects.isNull(set2))
			throw new NullPointerException("Brak referencji zbioru set2!");

		final Set<E> set = new HashSet<>();
		set.addAll(set1);
		set.addAll(set2);

		assert set.size() == (set1.size() + set2.size()) : "Niespójność kolekcji danych";

		return set;
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>SetOperator</<code> Przesłonięcie
	 * publicznego konstruktora
	 */
	private SetOperator() {

	}
}