package com.codigo.smartstore.sdk.core.operate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codigo.smartstore.sdk.core.opearte.IPalindromValidation;
import com.codigo.smartstore.sdk.core.opearte.RecursivePalindrom;

@DisplayName(value = "Testy wyrażenia typu palindrom")
class PalindromTests {

	@ParameterizedTest
	@ValueSource(
		strings = {
			"Kobyła ma mały bok", "Akta generała ma mała renegatka", "Ile Romanowi dała za ład Iwona moreli",
			"Łapał za kran a kanarka złapał", "Zakopane na pokaz", "Żartem dano nadmetraż", "A kilku tu klika", "radar",
			"rotor", "sedes", "senes", "sos", "towot", "jeż largo gra lżej", "udoi miś i miodu" })
	void testPalindrom(final String input) {

		final var palindromText = input;

		final var validator = new RecursivePalindrom();

		final var isPalindrom = validator.validate(palindromText);

		assertThat(true, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsEmpty() {

		final var palindromText = "";

		final var validator = new IPalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNotValid() {

		final var palindromText = "caz";

		final var validator = new IPalindromValidation() {};

		final var isPalindrom = validator.validate(palindromText);

		assertThat(false, equalTo(isPalindrom));
	}

	@Test
	void testPalindrom_IsNullExceptionValid() {

		final var validator = new IPalindromValidation() {};

		assertThrows(NullPointerException.class,
			(
			) -> {

				validator.validate(null);
			}

		);
	}

	@Test
	void test() {

		final Kontrwarancja<Organism> AnimalK = instance -> System.out.println(instance);
		final Kontrwarancja<Animal[]> CatK = instance -> System.out.println(instance);

		CatK.set(new Animal[] {});
		CatK.set(new Cat[] {});
		// CatK.set(new Organism());

		AnimalK.set(new Animal());
		AnimalK.set(new Cat());
		AnimalK.set(new Organism());

		final String str1 = new String("11");
		final String str2 = new String("1");

		var comp = str1.equals(str2);
		comp = str1 == str2;
		System.out.println(comp);
	}
}

interface Kowarancja<T> {

	T get();
}

interface Kontrwarancja<T> {

	void set(T instance);
}

class Organism {
}

class Animal
		extends
		Organism {
}

class Cat
		extends
		Animal {
}
