package com.codigo.smartstore.sdk.core.errors;

public class ErrorMessages {

	public static NullPointerException getNullPointerExceptioMessage(final Object instance)
			throws NullPointerException {

		throw new NullPointerException(
				"Obiekt o identyfikatorze:" + instance
						+ " nie posiada swojej instancji w pamięci!");
	}

}
