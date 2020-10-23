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
			Byte.class, Byte.valueOf(Default.ZERO));

		DEFAULTS.put(
			byte.class, Default.ZERO);

		DEFAULTS.put(
			Short.class, Short.valueOf(Default.ZERO));

		DEFAULTS.put(
			short.class, Default.ZERO);

		DEFAULTS.put(
			Integer.class, Integer.valueOf(Default.ZERO));

		DEFAULTS.put(
			int.class, Default.ZERO);

		DEFAULTS.put(
			BigInteger.class, BigInteger.valueOf(Default.ZERO));

		DEFAULTS.put(
			Long.class, Long.valueOf(Default.ZERO));

		DEFAULTS.put(
			long.class, Default.ZERO);

		DEFAULTS.put(
			Float.class, Float.valueOf(Default.ZERO));

		DEFAULTS.put(
			float.class, Default.ZERO);

		DEFAULTS.put(
			Double.class, Double.valueOf(Default.ZERO));

		DEFAULTS.put(
			double.class, Default.ZERO);

		DEFAULTS.put(
			BigDecimal.class, BigDecimal.valueOf(Default.ZERO));

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
	 * Domyślna wartość dla typów numerycznych
	 */
	private static final byte ZERO = 0;

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
