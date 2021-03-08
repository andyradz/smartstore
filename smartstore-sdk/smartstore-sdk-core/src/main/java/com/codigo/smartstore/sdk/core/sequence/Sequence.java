package com.codigo.smartstore.sdk.core.sequence;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Klasa reprezentuje mechanizm generowanie sekwencji dla wybranych typów
 * danych. Sposób działania podobny do pętli tylko z wykorzystaniem strumieni.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2020
 */
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
	public static LongStream sequence(final long value, final int count, final long grow) {

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
	 * Metoda generuje tablicę elementów, od wskazanej wartości początkowej
	 * wykonując powtarzanie o wskazana licznę kroków przyrastają o konkretną
	 * wartość. Metoda to analogia do pętli iterująca po elementach numerycznych
	 *
	 * @param value Wartość początkowa iterowania
	 * @param limit Liczba powtórzeń iterowania
	 * @param grow grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Tablica elementów numerycznych typu Long[]
	 */
	public static Long[] sequence(final int value, final int limit, final int grow) {

		return LongStream.iterate(value, item -> item + grow)
				.limit(limit)
				.boxed()
				.toArray(Long[]::new);
	}

	/**
	 * Metoda generuje tablicę elementów, od wskazanej wartości początkowej
	 * wykonując powtarzanie o wskazana licznę kroków przyrastają o konkretną
	 * wartość. Metoda to analogia do pętli iterująca po elementach numerycznych
	 *
	 * @param value Wartość początkowa iterowania
	 * @param limit Liczba powtórzeń iterowania
	 * @param grow grow Wartość zwiększenia elementu przy kolejnych iteracjach
	 *
	 * @return Tablica elementów numerycznych typu Double[]
	 */
	public static Double[] sequence(final double value, final int limit, final double grow) {

		return DoubleStream.iterate(value, item -> item + grow)
				.limit(limit)
				.boxed()
				.toArray(Double[]::new);
	}

	/**
	 * Metoda generuje strumień dat ze wskazanego zakresu
	 *
	 * @param startDate Data początku zakresu generowania
	 * @param endDate Data końca zakresu generowania
	 * @param step Wartość przesunięcia między bieżącą datą a kolejną data
	 * @return Strumień zakresu dat
	 */
	public static Stream<LocalDate> sequence(final LocalDate startDate, final LocalDate endDate, final int step) {

		return startDate.datesUntil(endDate, Period.ofDays(step));
	}

	/**
	 * @param startDate startDate Data początku zakresu generowania
	 * @param step Wartość przesunięcia między bieżącą datą a kolejną data
	 * @param limit Ilość kroków do wykonania
	 * @return Strumień zakresu dat
	 */
	public static Stream<LocalDate> sequence(final LocalDate startDate, final int step, final long limit) {

		return Stream.iterate(startDate, date -> startDate.plusDays(step))
				.limit(limit);
	}

	/**
	 * Podstawowy konstruktor obiektu <code>Sequence</code>
	 */
	private Sequence() {

		super();
	}
}
