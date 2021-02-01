package com.codigo.smartstore.sdk.core.money;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.stream.IntStream;

import com.codigo.smartstore.sdk.core.opearte.StringOperator;
import com.codigo.smartstore.sdk.core.sequence.Divider;

@FunctionalInterface
interface IConvertable<T, R> {

	R convert(T instance);
}

@FunctionalInterface
interface INumberConvertable<T extends Number>
	extends IConvertable<T, String> {

	@Override
	String convert(T instance);
}

/**
 * Operator realizuje zamianę/konwersję wartości monetarnej na wartość słowną
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2018
 * @category model
 */
public final class MoneyInWordsModel
	implements IConvertable<Double, String> {

	private static final String MONEY_WORDS_FILE = "moneyinwords_pl.properties";

	private static final Properties moneyInWords;

	static {

		moneyInWords = new Properties();

		try (InputStream input = MoneyInWordsModel.class.getClassLoader()
				.getResourceAsStream(MONEY_WORDS_FILE)) {

			if (input == null)
				throw new NullPointerException("Sorry, unable to find moneyinwords_pl.properties");

			moneyInWords.loadFromXML(input);

		} catch (final IOException ex) {

			ex.printStackTrace();
		}
	}

	/**
	 * Oprator wyznacznia setek z wartości liczby
	 */
	private static LongUnaryOperator hasHunds = item -> ((item / 100) % 100) != 0 ? (item / 100) : 0;

	/**
	 * Operator wyznacznia jednostek z wartości liczby
	 */
	private static LongUnaryOperator hasOnes = item -> (1 == ((item / 10) % 10)) ? 0 : item % 10;

	/**
	 * Operator wyznacznia nastek z wartości liczby
	 */
	private static final LongUnaryOperator hasTeens = item -> (1 == ((item % 100) / 10)) && ((0 != ((item % 100) % 10)))
			? (item % 10)
				: 0;
	/**
	 * Oprator wyznacznia dziesiątek z wartości liczby
	 */
	private static LongUnaryOperator hasTens = item -> (((item / 10) % 10) != 1)
			|| ((((item / 10) % 10) == 1) && (((item) % 10) == 0)) ? ((item / 10) % 10) : 0;

	public static void main(final String[] args) {

		final var iterator = IntStream.iterate(1, item -> item + 1)
				.iterator();

		final LongFunction<String> func = tyt -> {

			final var sb = new StringBuilder();

			Divider.compute(tyt, 1_000)
					.mapToObj(item -> MoneyInWordsModel.builder()
							.setValue((int) item)
							.setSector(iterator.next())
							.setUnitsCount((int) hasOnes.applyAsLong(item))
							.setTeensCount((int) hasTeens.applyAsLong(item))
							.setTensCount((int) hasTens.applyAsLong(item))
							.setHundsCount((int) hasHunds.applyAsLong(item))
							.build())
					.map(item -> item)
					.sorted(Comparator.comparingLong(MoneyInWordsModel::getSector)
							.reversed())
					.forEach(obj -> {

						final var units = moneyInWords.get("0" + "."
								+ obj.countOfUnit())
								.toString()
								.trim();

						final var teens = moneyInWords.get("1" + "."
								+ obj.countOfTeens())
								.toString()
								.trim();

						final var tens = moneyInWords.get("2" + "."
								+ obj.countOfTens())
								.toString()
								.trim();

						final var hunds = moneyInWords.get("3" + "."
								+ obj.countOfHundred())
								.toString()
								.trim();

						final var v3 = moneyInWords.get("v." + (obj.getSector() - 1)
								+ ".1")
								.toString()
								.trim();

						sb.append(StringOperator.isNullOrEmpty(hunds) ? "" : hunds + " ");
						sb.append(StringOperator.isNullOrEmpty(tens) ? "" : tens + " ");
						sb.append(StringOperator.isNullOrEmpty(teens) ? "" : teens + " ");
						sb.append(StringOperator.isNullOrEmpty(units) ? "" : units + " ");
						sb.append(v3 + " ");
					});
			return sb.toString();
		};

		System.out.println(func.apply(1_452_114L));

	}

	private final int value;

	/**
	 * Pola określa numer sekcji tysięcznej wartości monetarnej
	 */
	private final int sector;

	/**
	 * Pola określa ilość jedności w sekcji tysięcznej wartości monetarnej
	 */
	private final int unitsCount;

	/**
	 * Pola określa ilość nastek w sekcji tysięcznej wartości monetarnej
	 */
	private final int teensCount;

	/**
	 * Pola określa ilość dziesiątek w sekcji tysięcznej wartości monetarnej
	 */
	private final int tensCount;

	/**
	 * Pola określa ilość setek w sekcji tysięcznej wartości monetarnej
	 */
	private final int hundsCount;

	public static MoneyPartBuilder builder() {

		return new MoneyPartBuilder(
		);
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
	 * solid;font-size:1.1em'>
	 * Podstawowy konstruktor obiektu klasy
	 * </p>
	 *
	 * @param partBuilder Budowniczy struktury przechowującej sektory liczby.
	 */
	public MoneyInWordsModel(final MoneyPartBuilder partBuilder) {

		this.value = partBuilder.value;
		this.sector = partBuilder.sector;
		this.unitsCount = partBuilder.unitsCount;
		this.tensCount = partBuilder.tensCount;
		this.teensCount = partBuilder.teensCount;
		this.hundsCount = partBuilder.hundsCount;
	}

	public int getValue() {

		return this.value;
	}

	public int getSector() {

		return this.sector;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:1px;border-style:
	 * thin;'>
	 * Właściwość określa ilość jedności w danym segmencie wartości montetarnej.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfUnit() {

		return this.unitsCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
	 * solid;'>
	 * Właściwość określa ilość nastek w danym segmencie wartości montetarnej.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfTeens() {

		return this.teensCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:1px;border-style:
	 * thin;'>
	 * Właściwość określa ilość dziesiątek w danym segmencie wartości montetarnej.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfTens() {

		return this.tensCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
	 * solid;'>
	 * Właściwość określa ilość setek w danym segmencie wartości montetarnej.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfHundred() {

		return this.hundsCount;
	}

	@Override
	public String toString() {

		final StringBuilder myBuilder = new StringBuilder();

		myBuilder.append("{");
		myBuilder.append(String.format("sector:'%03d'", this.getSector()));
		myBuilder.append(String.format("value:'%03d'", this.getValue()));
		myBuilder.append(String.format(",hundreds:'%03d'", this.countOfHundred()));
		myBuilder.append(String.format(",tens:'%03d'", this.countOfTens()));
		myBuilder.append(String.format(",teens:'%03d'", this.countOfTeens()));
		myBuilder.append(String.format(",units:'%03d'", this.countOfUnit()));
		myBuilder.append("}");

		return myBuilder.toString();
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:1px;border-style:
	 * solid;font-size:1.1em'>
	 * Klasa realizuje mechanizm przechowywania wartości ilości jednostek danego
	 * sektora liczby<br>
	 * Store file : MoneyInWords.java</br>
	 * Create date: 24.01.2017
	 * </p>
	 *
	 * @author andrzej.radziszewski *
	 * @version 1.0.0.0
	 */
	public static class MoneyPartBuilder {

		private int value;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Numer sektora w liczbie.
		 * </p>
		 */
		private int sector;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Ilość jednostek w sektorze liczby.
		 * </p>
		 */
		private int unitsCount;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Ilość nastek w sektorze liczby.
		 * </p>
		 */
		private int teensCount;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Ilość dziesiątek w sektorze liczby.
		 * </p>
		 */
		private int tensCount;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
		 * solid;border-width:1px'>
		 * Ilość setek w sektorze liczby
		 * </p>
		 */
		private int hundsCount;

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
		 * solid;border-width:1px'>
		 * Metoda weryfikuje wartość ilości jednostek przypisywanych do danego sektora
		 * liczby.</br>
		 * Wykonywana jest walidacja czy przypisywana wartość jest z zakresu [0-9].
		 * </p>
		 *
		 * @param assignValue Wartość ilości przypisywanej do sektora liczby.
		 *
		 * @throws IllegalArgumentException
		 * <p style=
		 * 'color:red;background:rgba(255,230,230,0.9);padding:12px;border-radius:2px;'>
		 * Wyjątek powstaje w przypadku gdy wartości <code>assignValue</code> jest poza
		 * zakresem dozwolonych wartości [0-9]
		 * </p>
		 */
		private void checkAssignValue(final int assignValue) {

			if ((assignValue < 0) || (assignValue > 999))
				throw new IllegalArgumentException(
						"\nBłędna wartość parametru {assignValue}."
								+ " \nDozwolone wartości to liczby z zakresu [0-999]");
		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
		 * solid;'>
		 * Podstawowy konstruktor obiektu klasy.
		 * </p>
		 *
		 * @param sector Numer sektora w liczbie. Numer sektora należy rozumieć jako
		 * kolejny tysięczny blok składowy liczby.
		 */
		private MoneyPartBuilder() {

		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Właściwość ustawia atrybut <code>this.unitCount</code> określający ilość
		 * jednostek w danym sektorze liczby.
		 * </p>
		 *
		 * @param count Ilość jednostek w danym sektorze liczby.
		 *
		 * @return Obiekt typu <code>WordsMoneyPartBuilder</code>.
		 */
		public MoneyPartBuilder setValue(final int value) {

			this.checkAssignValue(value);
			this.value = value;

			return this;
		}

		public MoneyPartBuilder setSector(final int sector) {

			this.checkAssignValue(sector);
			this.sector = sector;

			return this;
		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Właściwość ustawia atrybut <code>this.unitCount</code> określający ilość
		 * jednostek w danym sektorze liczby.
		 * </p>
		 *
		 * @param count Ilość jednostek w danym sektorze liczby.
		 *
		 * @return Obiekt typu <code>WordsMoneyPartBuilder</code>.
		 */
		public MoneyPartBuilder setUnitsCount(final int count) {

			this.checkAssignValue(count);
			this.unitsCount = count;

			return this;
		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Właściwość ustawia atrybut <code>this.teenCount</code> określający ilość
		 * nastek w danym sektorze liczby.
		 * </p>
		 *
		 * @param count : Ilość nastek w danym sektorze liczby.
		 *
		 * @return Obiekt typu <code>WordsMoneyPartBuilder</code>.
		 */
		public MoneyPartBuilder setTeensCount(final int count) {

			this.checkAssignValue(count);
			this.teensCount = count;

			return this;
		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:1px;border-style:
		 * solid;'>
		 * Właściwość ustawia atrybut <code>this.tenCount</code> określający ilość
		 * dziesiątek w danym sektorze liczby.
		 * </p>
		 *
		 * @param count Ilość dziesiątek w danym sektorze liczby.
		 *
		 * @return Obiekt typu <code>WordsMoneyPartBuilder</code>.
		 */
		public MoneyPartBuilder setTensCount(final int count) {

			this.checkAssignValue(count);
			this.tensCount = count;

			return this;
		}

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:solid;'>
		 * Właściwość ustawia atrybut <code>this.hundCount</code> określający ilość
		 * setek w danym sektorze liczby.
		 * </p>
		 *
		 * @param count Ilość setek w danym sektorze liczby.
		 *
		 * @return Obiekt typu <code>WordsMoneyPartBuilder</code>.
		 */
		public MoneyPartBuilder setHundsCount(final int count) {

			this.checkAssignValue(count);
			this.hundsCount = count;

			return this;
		}

		public MoneyInWordsModel build() {

			return new MoneyInWordsModel(this);
		}
	}

	@Override
	public String convert(final Double instance) {

		return "";

	}
}
