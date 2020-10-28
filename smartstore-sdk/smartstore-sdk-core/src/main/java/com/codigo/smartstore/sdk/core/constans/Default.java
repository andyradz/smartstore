package com.codigo.smartstore.sdk.core.constans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Klasa dostarcza wartości domyślne dla podstawowych typów klas dostępnych na23
 * platformie JVM.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2017
 * @category constant
 */
public final class Default {

	/**
	 * Definicja domyślnych wartości dla typów klas platforny JVM.
	 */
	private static final Map<Class<?>, Object> DEFAULTS;

	/**
	 * Domyślny statyczny konstruktor obiektu klasy <code>Default</code>.
	 */
	static {

		DEFAULTS = new HashMap<>();

		DEFAULTS.put(
			Boolean.class, Boolean.valueOf(false));

		DEFAULTS.put(
			boolean.class, false);

		DEFAULTS.put(
			Character.class, '\u0000');

		DEFAULTS.put(
			char.class, '\u0000');

		DEFAULTS.put(
			String.class, Default.EMPTY);

		DEFAULTS.put(
			Byte.class, Byte.valueOf((byte) 0));

		DEFAULTS.put(
			byte.class, (byte) 0);

		DEFAULTS.put(
			Short.class, Short.valueOf((short) 0));

		DEFAULTS.put(
			short.class, 0);

		DEFAULTS.put(
			Integer.class, Integer.valueOf(0));

		DEFAULTS.put(
			int.class, 0);

		DEFAULTS.put(
			BigInteger.class, BigInteger.valueOf(0));

		DEFAULTS.put(
			Long.class, Long.valueOf(0));

		DEFAULTS.put(
			long.class, 0L);

		DEFAULTS.put(
			Float.class, Float.valueOf(0));

		DEFAULTS.put(
			float.class, .0);

		DEFAULTS.put(
			Double.class, Double.valueOf(.0));

		DEFAULTS.put(
			double.class, .0);

		DEFAULTS.put(
			BigDecimal.class, BigDecimal.valueOf(0));

		DEFAULTS.put(
			Enum.class, Enum.valueOf(DefaultEnum.class, "ZERO"));

		DEFAULTS.put(
			Object.class, Default.NULL);
	}

	/**
	 * Definicja domyślnego typu klasy Enum.
	 */
	private enum DefaultEnum {
		ZERO
	}

	/**
	 * Domyślna wartość dla typów ciągu znaków
	 */
	private static final String EMPTY = "";

	/**
	 * Domyślna wartość dla obiektów bez instancji
	 */
	private static final Object NULL = null;

	/**
	 * Metoda dostarcza domyślną wartość dla wskazanego typu obiektu klasy.
	 *
	 * @param <T> Generyczna klasa typu
	 * @param type Klasa typu danych
	 *
	 * @return Domyślna wartość obiektu danej klasy
	 */
	public static <T> T zero(@NonNull final Class<T> type) {

		@SuppressWarnings("unchecked")
		final T instance = (type.isPrimitive()) ? (T) DEFAULTS.get(type) : type.cast(DEFAULTS.get(type));

		return instance;
	}
}
