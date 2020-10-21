package com.codigo.smartstore.core.money;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.function.LongUnaryOperator;

import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.sequence.Sequence;

class TestsMoneyInWordsOnes {

	/**
	 * Operator wyznacznia jednostek z wartości liczby
	 */
	private static LongUnaryOperator hasOnes = item -> (1 == ((item / 10) % 10)) ? 0 : item % 10;

	@Test
	void shouldByTrue_ForOnesUnits() {

		Sequence.sequence(21, 8, 1)
				.forEach(item -> {

					System.out.println(item);
					assertThat(item % 10, equalTo(hasOnes.applyAsLong(item)));
				});
	}

	@Test
	void shouldByFalse_ForTensUnits() {

		Sequence.sequence(10, 90, 10)
				.forEach(item -> {

					System.out.println(item);
					assertThat(item, not(equalTo(hasOnes.applyAsLong(item))));
				});
	}

	@Test
	void shouldByFalse_ForTeensUnits() {

		Sequence.sequence(11, 9, 1)
				.forEach(item -> {

					System.out.println(item);
					assertThat(item, not(equalTo(hasOnes.applyAsLong(item))));
				});
	}

	@Test

	void shouldByFalse_ForHundsUnits() {

		Sequence.sequence(100, 9, 100)
				.forEach(item -> {

					System.out.println(item);
					assertThat(item, not(equalTo(hasOnes.applyAsLong(item))));
				});
	}

	@Test
	void shouldReturnZeroUnits_From910() {

		final var value = 919;

		final var val = hasOnes.applyAsLong(value);

		assertThat(0L, equalTo(val));
	}

	@Test
	void shouldReturnZeroUnits_From10() {

		final var value = 10;

		final var val = hasOnes.applyAsLong(value);

		assertThat(0L, equalTo(val));
	}

	@Test
	void shouldReturnZeroUnits_From919() {

		final var value = 919;

		final var val = hasOnes.applyAsLong(value);

		assertThat(0L, equalTo(val));
	}

	@Test
	void shouldReturnZeroUnits_From12() {

		final var value = 12;

		final var val = hasOnes.applyAsLong(value);

		assertThat(0L, equalTo(val));
	}

	@Test
	void shouldReturnTwoUnits_From22() {

		final var value = 22;

		final var val = hasOnes.applyAsLong(value);

		assertThat(2L, equalTo(val));
	}

	@Test
	void shouldReturnTwoUnits_From2() {

		final var value = 2;

		final var val = hasOnes.applyAsLong(value);

		assertThat(2L, equalTo(val));
	}

	@Test
	void shouldReturnTwoUnits_From102() {

		final var value = 102;

		final var val = hasOnes.applyAsLong(value);

		assertThat(2L, equalTo(val));
	}

	@Test
	void shouldReturnZeroUnits_From112() {

		final var value = 112;

		final var val = hasOnes.applyAsLong(value);

		assertThat(0L, equalTo(val));
	}
}

// @Test
// @ParameterizedTest(name = "{index} => number={0}")
// @MethodSource("getData")
// @ArgumentsSource(CustomArgumentProvider.class)
// public void shouldPrintAllUnits_FromRange0To999(final int number) {
//
// final String format = "Ones count - %03d::%03d";
// assertThat(number, equalToBetween.between(1, 9));
//
// final IntConsumer checker = value -> {
//
// final int result = hasOnes.applyAsLong(value);
//
// if (result != 0) {
//
// assertThat(result, equalToBetween.between(1, 9));
// log.info((String.format(format, value, result)));
// }
// };
//
// IntStream.rangeClosed(1, 999)
// .forEach(checker);
// }

// static class CustomArgumentProvider
// implements ArgumentsProvider {
//
// @Override
// public Stream<? extends Arguments> provideArguments(final ExtensionContext
// context) throws Exception {
//
// return Stream.of(Arguments.of(1));
// }
// }
//
// private static Stream<Arguments> getData() {
//
// return Stream.of(Arguments.of(IntStream.rangeClosed(1, 1)));
// }
// }

//// Safe method with a generic varargs parameter
// @SafeVarargs
// static <T> List<T> flatten(final List<? extends T>... lists) {
// // Kiedy wiadomo, że jest bezpieczna?
// //
// // Gdy nie modyfikujemy zawartości tablicy
// // Gdy nie przekazujemy referencji tej tablicy na zewnątrz, co by umożliwiło
//// jej
// // modyfikację, z wyjątkiem gdy:
// // przekazujemy ją do innej metody z varargs z adnotacją SafeVarargs
// // lub metody, która też odczytuje tylko wartości z tablicy
//
// // Adnotacje @SafeVarargs możemy zadeklarować tylko na metodach, które nie
//// mogą
// // być nadpisane, ponieważ nie ma możliwości, aby zagwarantować, że każda
// // nadpisująca metoda będzie bezpieczna. Do Javy 8 można było ją używać tylko
//// na
// // metodach statycznych i finalnych instancyjnych. W Javie 9 umożliwiono też
//// na
// // prywatnych metodach instancyjnych.
//
// final List<T> result = new ArrayList<>();
//
// for (final List<? extends T> list : lists)
// result.addAll(list);
//
// return result;
// }
//
// static class Person {
// }
//
// static class VipPerson
// extends
// Person {
// }
//
// static class SuperPerson
// extends
// VipPerson {
// }
//
// private static void printElements(final List<? extends Person> list) {
//
// list.forEach(System.out::println);
// }
//
// private static void addPersons(final List<? super Person> list) {
//
// list.add(new Person());
// list.add(new VipPerson());
// list.add(new SuperPerson());
//
// list.get(2);
// }
//
// public static void copy(final List<? extends VipPerson> src, final List<?
//// super VipPerson> dest) {
//
// for (int i = 0; i < src.size(); i++)
// dest.add(src.get(i));
// }
//
// @Test
// void testKonwariancja() {
//
// final List<Person> list = new ArrayList<>();
// addPersons(list);
//
// new ArrayList<>();
// new ArrayList<>();
//
// new ArrayList<>();
// // addPersons(vipList); // ->
// // bª¡d (nie ka»dy Person jest VipPerson )
// final List<SuperPerson> superList = new ArrayList<>(); // ok
// addPersons(list);
//
// copy(superList, list); // ok
// }
//
// @Test
// public void test1() {
//
// Divider.compute(166_879_413_500_135L, 1_000L)
// .forEach(item -> {
//
// final var val = item;
// System.out.print(String.format("%d_", val));
// });
// // sequence(0L, 100L, 25).forEach(System.out::println);
// }
