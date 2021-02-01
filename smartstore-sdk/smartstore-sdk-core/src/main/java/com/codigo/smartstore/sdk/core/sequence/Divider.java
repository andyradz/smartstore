package com.codigo.smartstore.sdk.core.sequence;

import static com.codigo.smartstore.sdk.core.constans.Default.zero;
import static com.codigo.smartstore.sdk.core.messages.errors.ErrorsCoreMessages.getIllegalArgumentException;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/**
 * Klasa zawiera operatory wyznacznia strumienia wartości po przeprowadzeniu
 * operacji dzielenia. Sposób działania i sterowania generowaniem elementów
 * strumienia jest zbliżony do działania pętli for.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2020
 */
public class Divider {

	/**
	 * Metoda generuje strumień wartości numerycznych po wykonaniu operacji
	 * dzielenia
	 *
	 * @param value Wartość początkowa operatora
	 * @param divider Wartość dzielnika
	 * @param limit Liczba wykonanych powtórzeń operacji dzielenia
	 *
	 * @return Strumień wartości typu Long
	 */
	public static LongStream compute(final long value, final long divider, final long limit) {

		if (zero(Long.class).equals(divider))
			throw getIllegalArgumentException(divider);

		return LongStream.iterate(value, item -> (item) > zero(long.class), item -> (item / divider))
				.map(item -> item % divider)
				.limit(limit);
	}

	/**
	 * Metoda generuje strumień wartości numerycznych po wykonaniu operacji
	 * dzielenia
	 *
	 * @param value Wartość początkowa operatora
	 * @param divider Wartość dzielnika
	 * @param limit Liczba wykonanych powtórzeń operacji dzielenia
	 *
	 * @return Strumień wartości typu Double
	 */
	public static DoubleStream compute(final double value, final double divider, final long limit) {

		if (zero(Double.class).equals(divider))
			throw getIllegalArgumentException(divider);

		return DoubleStream.iterate(value, item -> item > .0, item -> (item / divider))
				.map(item -> item / divider)
				.limit(limit);
	}

	/**
	 * Metoda generuje strumień wartości numerycznych po wykonaniu operacji
	 * dzielenia
	 *
	 * @param value Wartość początkowa operatora
	 * @param divider Wartość dzielnika
	 *
	 * @return Strumień wartości typu Long
	 */
	public static LongStream compute(final long value, final long divider) {

		if (zero(Long.class).equals(divider))
			throw getIllegalArgumentException(divider);

		return LongStream.iterate(value, item -> (item) > zero(long.class), item -> (item / divider))
				.map(item -> item % divider);
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>Divider</code>
	 */
	private Divider() {

	}
}
