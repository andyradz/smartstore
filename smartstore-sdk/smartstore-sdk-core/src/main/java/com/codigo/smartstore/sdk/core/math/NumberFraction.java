package com.codigo.smartstore.sdk.core.math;

import java.util.function.DoubleUnaryOperator;

/**
 * Operatory klasy wykonują ekstrakcję farkcji po przecinku liczby rzeczywistej
 * z wykonaniem zaookręglenia stsoując algorytm HALF_ROUND
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2016
 */
public class NumberFraction {

	/**
	 * Znacznik wyraża precyzję części umałkowej wartości liczby rzeczywistej, która
	 * będzie brana pod uwagę podczas operacji arytmetycznych.
	 */
	public enum DecimalPrecision {

		/**
		 * Brak precyzji.
		 */
		PRECTO0(0D),

		/**
		 * Precyzja jednej pozycji.
		 */
		PRECTO1(1D),

		/**
		 * Precyzja dwóch pozycji.
		 */
		PRECTO2(2D),

		/**
		 * Precyzja trzech pozycji.
		 */
		PRECTO3(3D),

		/**
		 * Precyzja czterech pozycji.
		 */
		PRECTO4(4D),

		/**
		 * Precyzja pięciu pozycji.
		 */
		PRECTO5(5D),

		/**
		 * Precyzja sześciu pozycji.
		 */
		PRECTO6(6D);

		/**
		 * Domyślny konstruktor obiektu klasy <code>DecimalPrecision></code>
		 *
		 * @param precision Wartość liczbowa wyrażona w postaci liczby rzeczywsitej.
		 * Określa ilość pozycji części ułamka wartości rzeczywistej, która będzie brana
		 * pod uwagę podczas obliczeń arytmetycznych.
		 */
		DecimalPrecision(final double precision) {

			this.precision = precision;
		}

		/**
		 * Właściwość obiektu określa precyzję ilości miejsc po przecinku, do której
		 * będzie sprowadzało się zaokrąglenie wartości liczby rzeczywistej.
		 *
		 * @return Wartość liczbowa liczby rzeczywistej.
		 */
		public double value() {

			return this.precision;
		}

		/**
		 * Operator definiuje za pomocą znaczników parametry funkcji zaokrągleń.
		 */
		public enum Round {

			EVALTO1(DecimalPrecision.PRECTO1),
			EVALTO2(DecimalPrecision.PRECTO2),
			EVALTO3(DecimalPrecision.PRECTO3),
			EVALTO4(DecimalPrecision.PRECTO4),
			EVALTO5(DecimalPrecision.PRECTO5),
			EVALTO6(DecimalPrecision.PRECTO6);

			/**
			 * Metoda funktora dokonuje zaaokrąglenia wartosci liczby rzeczywistej do
			 * wskazanej precyzji.
			 */
			private final DoubleUnaryOperator doRound = number -> {

				if (!Double.isFinite(number))
					throw new IllegalArgumentException(
							"\nWartość liczby rzeczywistej jest nieprawidłowa!");

				final double range = .0;

				return Math.round(number * range) / range;
			};

			/**
			 * Domyślny konstruktor obiektu klasy.
			 *
			 * @param precision Precyzja ułamka liczby rzeczywistej.
			 */
			Round(final DecimalPrecision precision) {

				this.precision = precision;
			}

			private final DecimalPrecision precision;

			/**
			 * @return the doRound
			 */
			public DoubleUnaryOperator getDoRound() {

				return this.doRound;
			}

			/**
			 * @return the precision
			 */
			public DecimalPrecision getPrecision() {

				return this.precision;
			}

			/**
			 * Metoda dokonuje wyznaczenia ułamka liczby rzeczywistej z uwzględnieniem
			 * precyzji zaokrąglenia.
			 *
			 * @param number Wartość liczby rzeczywistej.
			 * @return Wartość numeryczna wyrażona liczbą rzeczywistą.
			 */
			public double compute(final double number) {

				return this.doRound.applyAsDouble(number);
			}
		}

		/**
		 * Atrybut obiektu określa precyzję ułamka wartości liczby rzeczywistej.
		 */
		private final double precision;
	}

	/**
	 * Funkcja zwraca wartość ułamka liczby rzeczywistej z możliwością zastosowania
	 * zaaokrąglenia tej wartość do wskazanej dokładności.
	 *
	 * @param number Wartość liczby rzeczywistej.
	 * @param precision Precyzja obliczania ilości miejsc po przecinku.
	 * @return Wartość numeryczna wyrażona liczbą rzeczywistą.
	 */
	public static double fraction(final double number, final DecimalPrecision precision) {

		if (!Double.isFinite(number))
			throw new IllegalArgumentException(
					"\nWartość liczby rzeczywistej jest nieprawidłowa!");

		final double range = Math.pow(1E1, precision.value());
		return Math.round((number % 1E0) * range) / range;
	}

}