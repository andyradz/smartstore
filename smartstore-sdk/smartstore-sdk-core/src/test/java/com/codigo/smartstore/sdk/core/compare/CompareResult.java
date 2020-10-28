package com.codigo.smartstore.sdk.core.compare;

/**
 * Typ wyliczeniowy reprezentuje wynik operacji porówania wyrażony w postaci
 * znaczników. Poszczególne znacczniki reprezentują możliwe wyniki operacji
 * porównania.
 *
 * @author andrzej.radziszewski
 * @category enumeration
 * @serial 2017
 */
public enum CompareResult {

	/**
	 * Znacznik reprezentuje wynik wyrażenia mniejszy niż wyrażony jako
	 * <code>x < y</code> Porównanie wzgledem lewego operanda.
	 */
	LESS((byte) -1),

	/**
	 * Znacznik reprezentuje wynik wyrażenia równości wyrażony jako
	 * <code>x == y</code> Porownanie wzgledem lewego operanda.
	 */
	EQUAL((byte) 0),

	/**
	 * Znacznik reprezentuje wynik wyrażenia większy niż wyrażony jako
	 * <code>x > y</code> Porownanie wzgledem lewego operanda.
	 */
	MORE((byte) 1);

	static final int IS_EQUAL = 0;
	static final int IS_MORE = 1;
	static final int IS_LESS = -1;

	/**
	 * Atrybut określa kod wyniku operacji porówania
	 */
	private final byte compareCode;

	/**
	 * Podstawowy kontruktor obiektu klasy <code>CompareResult</code>
	 *
	 * @param compareCode Kod wyniku porównania
	 */
	private CompareResult(final byte compareCode) {

		this.compareCode = compareCode;
	}

	/**
	 * Właściwość wskazuje wartość wyniku operacji porównania
	 *
	 * @return Wartość numeryczna może zwracać wartości (-1, 0, 1)
	 */
	public byte result() {

		return this.compareCode;
	}

	/**
	 * Właściwość wskazuje wartość wyniku operacji porównania
	 *
	 * @return Wartość numeryczna może zwracać wartości (-1, 0, 1)
	 */
	public int get() {

		return this.compareCode;
	}
}
