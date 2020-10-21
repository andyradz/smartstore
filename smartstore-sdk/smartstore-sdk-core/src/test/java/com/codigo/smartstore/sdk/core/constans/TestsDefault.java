package com.codigo.smartstore.sdk.core.constans;

import static com.codigo.smartstore.sdk.core.constans.Default.zero;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testy domyślnych wartości dla dostępnych typów platformy JVM")
class TestsDefault {

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Boolean - test dla FALSE")
	void shouldBeTrue_For_Boolean_Class() {

		final Boolean instance = zero(Boolean.class);

		assertThat(Boolean.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo(Boolean.FALSE));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Byte - test dla 0")
	void shouldBeTrue_For_ByteClass() {

		final Byte instance = zero(Byte.class);

		assertThat(Byte.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo((byte) 0));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Short - test dla 0")
	void shouldBeTrue_For_ShortClass() {

		final Short instance = zero(Short.class);

		assertThat(Short.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo((short) 0));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Integer - test dla 0")
	void shouldBeTrue_For_Integer_Class() {

		final Integer instance = zero(Integer.class);

		assertThat(Integer.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo(0));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Long - test dla 0")
	void shouldBeTrue_For_Long_Class() {

		final Long instance = zero(Long.class);

		assertThat(Long.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo(0L));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu Double - test dla .0")
	void shouldBeTrue_For_Double_Class() {

		final Double instance = zero(Double.class);

		assertThat(Double.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo(.0));
	}

	@Test
	@DisplayName("Sprawdzenie domyślnej wartości typu String - test dla ")
	void shouldBeTrue_For_String_Class() {

		final String instance = zero(String.class);

		assertThat(String.class, equalTo(instance.getClass()));
		assertThat(instance, equalTo(new String("")));
	}
}
