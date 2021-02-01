package com.codigo.smartstore.xbase.database.structure.field;

import java.util.stream.Stream;

/**
 * Klasa typu wyliczeniowego zawiera znaczniki reprezentujace typy danych pól
 * standardu XBase.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2017
 * @category enumeration
 */
public enum XbFieldType {

	/**
	 * Ogólny typ danych
	 *
	 * <pre>
	 * { 0 }
	 * </pre>
	 */
	UNKNOWN((byte) 0),

	/**
	 * Typ znakowy, typ dopełniony pustymi znakami
	 *
	 * <pre>
	 * { C, 1, 254, 0, true }
	 * </pre>
	 */
	CHARACTER('C', 1, 254, 0, true),

	/**
	 * Typ znakowy, typ bez pustych znaków
	 *
	 * <pre>
	 * { V, 1, 254, 0, false }
	 * </pre>
	 */
	VARCHAR('V', 1, 254, 0, false),

	/**
	 * Binary data
	 *
	 * <pre>
	 * { Q, 1, 254, 0, false }
	 * </pre>
	 */
	VARBINARY('Q', 1, 254, 0, false),

	/**
	 * Date
	 *
	 * <pre>
	 * { D, 8, 8, 8, true }
	 * </pre>
	 */
	DATE('D', 8, 8, 8, true),

	/**
	 * Numeric data
	 *
	 * <pre>
	 * { F, 1, 20, 0, true }
	 * </pre>
	 */
	FLOAT('F', 1, 20, 0, true),

	/**
	 * Double value
	 *
	 * <pre>
	 * { O, 8, 8, 0, false }
	 * </pre>
	 */
	DOUBLE('O', 8, 8, 0, false),

	/**
	 * To store boolean values.
	 *
	 * <pre>
	 * { L, 1, 1, 1, true }
	 * </pre>
	 */
	LOGICAL('L', 1, 1, 1, true),

	/**
	 * Memo (data is stored in dbt file)
	 */
	MEMO('M'),

	/**
	 * Binary (data is stored in dbt file)
	 */
	BINARY('B'),

	/**
	 * Blob (VFP 9) (data is stored in fpt file)
	 */
	BLOB('W'),

	/**
	 * OLE Objects (data is stored in dbt file)
	 */
	GENERAL('G'),

	/**
	 * Picture (FoxPro, data is sotred in dbt file)
	 */
	PICTURE('P'),

	/**
	 * Numeric data
	 *
	 * <pre>
	 * { N, 1, 32, 0, true }
	 * </pre>
	 */
	NUMERIC('N', 1, 32, 0, true),

	/**
	 * Numeric long (FoxPro)
	 */
	LONG('I', 4, 4, 4, false),

	/**
	 * Autoincrement (same as long, dbase 7)
	 */
	AUTOINCREMENT('+', 4, 4, 4, false),

	/**
	 * Currency type (FoxPro)
	 */
	CURRENCY('Y', 8, 8, 8, false),

	/**
	 * Timestamp type (FoxPro)
	 */
	TIMESTAMP('T', 8, 8, 8, false),

	/**
	 * Timestamp type (dbase level 7)
	 */
	TIMESTAMP_DBASE7('@', 8, 8, 8, false),

	/**
	 * Flags
	 */
	NULL('0');

	/**
	 * Kod typu danych
	 */
	private char typeCode;

	/**
	 * Nazwa typu danych
	 */
	private String typeName;

	/**
	 * Ilość miejsc po przecinku typu danych
	 */
	private int typeDecimalPlaces;

	/**
	 * Domyślny rozmiar w bajtach typu danych
	 */
	private int typeDefaultSize;

	/**
	 * Minimalny rozmiar w bajtach typu danych
	 */
	private int typeMinSize;

	/**
	 * Maksymalny rozmiar w bajtach typu danych
	 */
	private int typeMaxSize;

	/**
	 * Wsparcie typu danych do zapisywania
	 */
	private boolean typeWroteSupported;

	/**
	 * Podstawowy konstruktor obiektu klasy <code>XbFieldType</code>
	 * @param code oznaczenie kodowe typu danych pola
	 */
	private XbFieldType(final byte code) {

		this((char) code);
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>XbFieldType</code>
	 * @param code oznaczenie kodowe typu danych pola
	 */
	private XbFieldType(final char code) {

		this.typeCode = code;
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>XbFieldType</code>
	 *
	 * @param code code oznaczenie kodowe typu danych pola
	 * @param minSize minimalna długośc pola
	 * @param maxSize maksymalna długośc pola
	 * @param defaultSize domyślna wartość pola
	 * @param wroteSupported czy zapis wartości jest dozwolony
	 */
	private XbFieldType(final char code, final int minSize, final int maxSize, final int defaultSize,
			final boolean wroteSupported) {

		this(code);
		this.typeMinSize = minSize;
		this.typeMaxSize = maxSize;
		this.typeDefaultSize = defaultSize;
		this.typeWroteSupported = wroteSupported;
	}

	public XbFieldType contains(final byte code) {

		return this.contains((char) code);
	}

	/**
	 *
	 * @param code
	 * @return
	 */
	public XbFieldType contains(final char code) {

		return Stream.of(XbFieldType.values())
				.filter(item -> item.getTypeCode() == code)
				.findAny()
				.orElse(XbFieldType.UNKNOWN);
	}

	/**
	 * Właściwość określa jednoznakowy kod typu danych
	 *
	 * @return Pojedyńczy znak typu <code>Character</code>
	 */
	public char getTypeCode() {

		return this.typeCode;
	}

	/**
	 * Właściwość określa nazwę typu danych
	 *
	 * @return Sekwencja znaków typu <code>String</code>
	 */
	public String getTypeName() {

		return this.typeName;
	}

	/**
	 * Właściowość określa ilość miejsc po przecinku dla wartości
	 * zmiennoprzecinkowej
	 *
	 * @return Wartość numeryczna całkowita
	 */
	public int getTypeDecimalPlaces() {

		return this.typeDecimalPlaces;
	}

	/**
	 * Właściwość określa domyślną długość pola
	 *
	 * @return Wartość numeryczna całkowita
	 */
	public int getTypeDefaultSize() {

		return this.typeDefaultSize;
	}

	/**
	 * Właściwość określa minimalną długość pola
	 *
	 * @return Wartość numeryczna całkowita
	 */
	public int getTypeMinSize() {

		return this.typeMinSize;
	}

	/**
	 * Własciwość określa czy jest mozliwośc aktualizacji pola
	 *
	 * @return Wartość logiczna
	 */
	public boolean getTypeWroteSupported() {

		return this.typeWroteSupported;
	}

	/**
	 * Właściwość określa maksymalną długość pola
	 *
	 * @return Wartość numeryczna całkowita
	 */
	public int getTypeMaxSize() {

		return this.typeMaxSize;
	}
}
