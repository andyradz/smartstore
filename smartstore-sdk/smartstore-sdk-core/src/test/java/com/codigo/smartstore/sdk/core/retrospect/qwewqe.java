package com.codigo.smartstore.sdk.core.retrospect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Sprawdzenie czy pole jest transient aby nie tworzy dla niego skrótu
 *
 * @author dp0470
 *
 */
public class qwewqe {

	public static void main(final String[] args) throws NoSuchFieldException, SecurityException {

		final Field field = qwewqe.class.getField("fieldName");
		Modifier.isTransient(field.getModifiers());
	}
}
