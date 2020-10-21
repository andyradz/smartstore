package com.codigo.smartstore.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Klasa reprezentuje listę operatorów dotyczących obiektu zserializowanego do
 * strumienia bajtów.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2020
 */
public class SerializedIntrospection {

	/**
	 * Obiekt niespełnia warunków do wyznaczenia informacji o obiekcie
	 */
	private static final int OBJECT_SIZE_NOT_COMPUTED = -1;

	/**
	 * Procedura wykonuje serializację przekazanego obiektu. Obiek musi implementowa
	 * interfejs Serializable
	 *
	 * @param object Obiekt poddawany serializacji
	 * @return
	 * @throws IOException
	 */
	public static int sizeOf(@NonNull final Object object) throws IOException {

		if (!(object instanceof Serializable))
			return OBJECT_SIZE_NOT_COMPUTED;

		final ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

		final ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);

		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
		objectOutputStream.close();

		return arrayOutputStream.size();
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>ObjectIntrospection</code>
	 */
	private SerializedIntrospection() {

		super();
	}
}
