package com.codigo.smartstore.webapi.monetary;

/**
 * @author andrzej.radziszewski
 *
 * @version 1.0.0.0
 *
 * @since 2018
 *
 * @category model
 */
public final class MoneyInWordsModel {

	private final int sector;

	private final int unitsCount;

	private final int teensCount;

	private final int tensCount;

	private final int hundsCount;

	public static MoneyPartBuilder builder(final int sector) {

		return new MoneyPartBuilder(
				sector);
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

		this.sector = partBuilder.sector;
		this.unitsCount = partBuilder.unitsCount;
		this.tensCount = partBuilder.tensCount;
		this.teensCount = partBuilder.teensCount;
		this.hundsCount = partBuilder.hundsCount;
	}

	public int getSector() {

		return this.sector;
	}

	public int countOfUnit() {

		return this.unitsCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
	 * solid;'>
	 * Właściwość określa ilość dziesiątek w danym segmencie liczby.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfTen() {

		return this.tensCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:2px;border-style:
	 * solid;'>
	 * Właściwość określa ilość nastek w danym segmencie liczby.
	 * </p>
	 *
	 * @return Wartość numeryczna całkowita.
	 */
	public int countOfTeen() {

		return this.teensCount;
	}

	/**
	 * <p style=
	 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
	 * solid;'>
	 * Właściwość określa ilość setek w danym segmencie liczby.
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
		myBuilder.append(String.format("sector:10x'%d'", this.getSector()));
		myBuilder.append(String.format(",units:'%d'", this.countOfUnit()));
		myBuilder.append(String.format(",teens:'%d'", this.countOfTeen()));
		myBuilder.append(String.format(",tens:'%d'", this.countOfTen()));
		myBuilder.append(String.format(",hundreds:'%d'", this.countOfHundred()));
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
	 * @author andrzej.radziszewski
	 *
	 * @version 1.0.0.0
	 */
	public static class MoneyPartBuilder {

		/**
		 * <p style=
		 * 'color:white;background:rgba(1,113,113,0.5);padding:12px;border-radius:4px;border-style:
		 * solid;'>
		 * Numer sektora w liczbie.
		 * </p>
		 */
		private final int sector;

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

			if ((assignValue < 0) || (assignValue > 9))
				throw new IllegalArgumentException(
						"\nBłędna wartość parametru {assignValue}."
								+ " \nDozwolone wartości to liczby z zakresu [0-9]");
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
		private MoneyPartBuilder(final int sector) {

			this.sector = sector;
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
		public MoneyPartBuilder assignUnitCount(final int count) {

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
		public MoneyPartBuilder assignTeenCount(final int count) {

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
		public MoneyPartBuilder assignTenCount(final int count) {

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
		public MoneyPartBuilder assignHundCount(final int count) {

			this.checkAssignValue(count);
			this.hundsCount = count;

			return this;
		}

		public MoneyInWordsModel build() {

			return new MoneyInWordsModel(this);
		}
	}
}
