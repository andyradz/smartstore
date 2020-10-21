package com.codigo.smartstore.sdk.core.sequence;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class Sequence {

	/**
	 * Metoda generuje sekwencje elementów, od wskazanej wartości początkowej
	 * wykonując powtarzanie o wskazana licznę kroków przyrastają o konkretną
	 * wartość. Metoda to analogia do pętli iterująca po elementach numerycznych
	 *
	 * @param value Wartość początkowa iterowania
	 * @param count Ilość powtórzeń iterowania
	 * @param grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Strumień elementów wartości numerycznych typu Long
	 */
	public static LongStream sequence(final int value, final int count, final int grow) {

		return LongStream.iterate(value, i -> i + grow)
				.limit(count);
	}

	/**
	 * Metoda generuje sekwencje elementów, od wskazanej wartości początkowej
	 * wykonując powtarzanie o wskazana licznę kroków przyrastają o konkretną
	 * wartość. Metoda to analogia do pętli iterująca po elementach numerycznych
	 *
	 * @param value Wartość początkowa iterowania
	 * @param max Maksymalna wartość iterowania
	 * @param grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Strumień elementów wartości numerycznych typu Long
	 */
	public static LongStream sequence(final long value, final long max, final int grow) {

		return LongStream.iterate(value, item -> item <= max, item -> item + grow);
	}

	/**
	 * Metoda generuje sekwencje elementów, od wskazanej wartości początkowej
	 * wykonując powtarzanie o wskazana licznę kroków przyrastają o konkretną
	 * wartość. Metoda to analogia do pętli iterująca po elementach numerycznych
	 *
	 * @param value Wartość początkowa iterowania
	 * @param max Maksymalna wartość iterowania
	 * @param grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Strumień elementów wartości numerycznych typu Long
	 */
	public static DoubleStream sequence(final double value, final double max, final double grow) {

		return DoubleStream.iterate(value, item -> item <= max, item -> item + grow);
	}

	/**
	 * @param value Wartość początkowa iterowania
	 * @param limit Liczba powtórzeń iterowania
	 * @param grow grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Tablica elementów numerycznych typu Long[]
	 */
	public static Long[] sequence1(final int value, final int limit, final int grow) {

		return LongStream.iterate(value, item -> item + grow)
				.limit(limit)
				.boxed()
				.toArray(Long[]::new);
	}

	/**
	 * Podstawowy konstruktor obiektu <code>Sequence</code>
	 */
	private Sequence() {

	}

}
