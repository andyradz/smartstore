package com.codigo.smartstore.sdk.core.messages.errors;

import static java.text.MessageFormat.format;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ErrorsCoreMessages {

	private static final String CORE_ERRORS_FILE = "errors.core.properites";

	private static final Properties coreErrorMessages;

	static {

		coreErrorMessages = new Properties();

		try (InputStream input = ErrorsCoreMessages.class.getClassLoader()
				.getResourceAsStream(CORE_ERRORS_FILE)) {

			if (input == null)
				throw new NullPointerException("Sorry, unable to find config.properties");

			coreErrorMessages.load(input);

		} catch (final IOException ex) {

			ex.printStackTrace();
		}
	}

	public static NullPointerException getNullPointerExceptioMessage(final Object instance) {

		throw new NullPointerException(
				format(coreErrorMessages.getProperty("core.nullpointerexceptiomessage"), instance));
	}

	public static IllegalArgumentException getIllegalArgumentException(final Object instance) {

		throw new IllegalArgumentException(
				format(coreErrorMessages.getProperty("core.illegalargumentexception"), instance));
	}

	private ErrorsCoreMessages() {

	}
}
