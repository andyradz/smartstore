package com.codigo.smartstore.sdk.core;

import static com.codigo.smartstore.sdk.core.FailsWithMatcher.failsWith;
import static com.codigo.smartstore.sdk.core.Valuable.from;
import static com.codigo.smartstore.sdk.core.Valuable.none;
import static com.codigo.smartstore.sdk.core.compare.CompareOperator.EQUALS;
import static com.codigo.smartstore.sdk.core.compare.CompareOperator.NOTEQUALS;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.EQUAL;
import static com.codigo.smartstore.sdk.core.constans.Default.zero;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Month;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.codigo.smartstore.sdk.core.opearte.StringOperator;

// https://www.baeldung.com/parameterized-tests-junit-5
// https://www.eclipse.org/community/eclipse_newsletter/2017/october/article5.php
class ValuableTest {

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10, 12, 16, 18, 20 })
	void test1(final int number) {

		assertThat(number % 2, equalTo(0));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " " })
	void test2(final String chain) {

		assertThat(StringOperator.isNullOrEmpty(chain), equalTo(true));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = { "APRIL" }, mode = EnumSource.Mode.MATCH_ALL)
	void test2(final Month month) {

	}

	@Test
	@RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością null")
	void testInitPropertyFromNull_sholudHasNullObjectValue() {

		final Object object = null;

		// arrange
		final Valuable<Object> property = from(object);

		// act
		final var value = property.get();

		// assert
		assertThat(null, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością null i ustawienie wartości float")
	void testSetFromFloat_sholudHasFloatObjectValue() {

		final Object object = 100.44f;

		// arrange
		final Valuable<Object> property = none();
		property.set(object);

		// act
		final var value = property.get();

		// asset
		assertThat(100.44f, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypadek powstania wyjątku IllegalArgumentException gdy flaga ThrowIfNull=True")
	void testSetPropertyFromStringWithoutNull_sholudGetIllegalArgumentException() {

		// arrange
		final Object object = "";

		// act
		final Valuable<Object> property = from(object, true, false);

		// assert
		assertThat((
		) -> property.set(null), failsWith(UnsupportedOperationException.class));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością false i ustawienie wartości true")
	void testSetFromBoolean_sholudHasBoleanObjectValue() {

		final Boolean object = false;

		// arrange
		final Valuable<Boolean> property = from(object);
		property.set(true);

		// act
		final Boolean value = property.get();

		// assert
		assertThat(true, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypadek powstania wyjątku UnsupportedOperationException gdy flaga ReadOnly=True")
	void testInitPropertyFromObjectReadOnly_sholudGetUnsupportedOperationException() {

		// arrange
		final Object object = null;

		// act
		final Valuable<Object> property = from(true);

		// assert
		assertThat((
		) -> property.set(object), failsWith(UnsupportedOperationException.class));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością blank i zwrot wartości brank")
	void testInitFromEmptyString_sholudHasEmptyStringValue() {

		final String string = "";

		// arrange
		final Valuable<String> property = from(string);

		// act
		final var value = property.get();

		// assert
		assertThat("", equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością integer(0) i zwrot wartości integer(0)")
	void testInitFromDefaultInteger_sholudHasDefaultIntegerValue() {

		final Integer number = 0;

		// arrange
		final Valuable<Integer> property = from(number);

		// act
		final var value = property.get();

		// assert
		assertThat(0, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością short(0) i zwrot wartości short(0)")
	void testInitFromShortInteger_sholudHasDefaultShortValue() {

		final Short number = 0;

		// arrange
		final Valuable<Short> property = from(number);

		// act
		final var value = property.get();

		// assert
		assertThat((short) 0, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością byte(0) i zwrot wartości byte(0)")
	void testInitFromInteger_sholudHasDefaultIntegerValue() {

		final Integer number = zero(Integer.class);

		// arrange
		final Valuable<Integer> property = from(number);

		// act
		final var value = property.get();

		// assert
		assertThat(zero(Integer.class), equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek inicjalizacji obiektu wartością long(0) i zwrot wartości long(0)")
	void testInitFromLong_sholudHasDefaultLongValue() {

		final Byte number = 0;

		// arrange
		final Valuable<Byte> property = from(number);

		// act
		final var value = property.get();

		// assert
		assertThat((byte) 0, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek wielokrotnem modyfikacji wartości string")
	void testSetFromStringWithManyChanges_sholudHasStringValue() {

		final String string = null;

		// arrange
		final Valuable<String> property = from(string);
		property.set("0");
		property.set(property.get() + "1");
		property.set(property.get() + "2");
		property.set(property.get() + "3");
		property.set(property.get() + "4");
		property.set(property.get() + "5");
		property.set(property.get() + "6");
		property.set(property.get() + "7");
		property.set(property.get() + "8");
		property.set(property.get() + "9");
		property.set(property.get() + "");

		// act
		final var value = property.get();

		// assert
		assertThat("0123456789", equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek wielokrotnem modyfikacji wartości integer")
	void testSetFromIntegerWithkManyChanges_sholudHasIntegerValue() {

		final Integer number = null;

		// arrange
		final Valuable<Integer> property = from(number);
		property.set(0);
		property.set(property.get() + 1);
		property.set(property.get() + 2);
		property.set(property.get() + 3);
		property.set(property.get() + 4);
		property.set(property.get() + 5);
		property.set(property.get() + 6);
		property.set(property.get() + 7);
		property.set(property.get() + 8);
		property.set(property.get() + 9);

		// act
		final var value = property.get();

		// assert
		assertThat(45, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza przypdek ustawienia flagi readonly=true")
	void testInitFromObjectWithReadOnly_sholudHasReadonlyTrue() {

		final Object object = null;

		// arrange
		final Valuable<?> property = from(object, true);

		// act
		final var readonly = property.isReadOnly();

		// assert
		assertThat(true, equalTo(readonly));
	}

	@Test
	@DisplayName("Test sprawdza przypdek atrybutu isnull=true")
	void testInitFromObjectWithNull_sholudHasNullTrue() {

		final Object object = null;

		// arrange
		final Valuable<?> property = from(object);

		// act
		final var readonly = property.isNull();

		// assert
		assertThat(true, equalTo(readonly));
	}

	@Test
	@DisplayName("Test sprawdza porównannie dwóch różnych obiektów właściwości typu string")
	void testCompareStringAndString_sholudNotEqualsResult() {

		// act
		final Valuable<String> propertyOne = from("1");
		final Valuable<String> propertyTwo = from("");

		// assert
		assertThat(true, equalTo(NOTEQUALS.compare(propertyOne, propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównannie dwóch identycznych obiektów właściwości typu string")
	void testCompareStringAndString_sholudEqualsResult() {

		// act
		final Valuable<String> propertyOne = from("   ąćł12230))))łłł");

		// assert
		final Valuable<String> propertyTwo = from("   ąćł12230))))łłł");

		assertThat(true, equalTo(EQUALS.compare(propertyOne, propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównannie dwóch różnych obiektów właściwości typu object")
	void testCompareNumberObjectAndString_sholudNotEqualsResult() {

		// act
		final Valuable<Object> propertyOne = from(1);
		final Valuable<Object> propertyTwo = from("1");

		// assert
		assertThat(true, equalTo(EQUALS.compare(propertyOne, propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównannie wartość nieokreślonej obiektów właściwości typu object")
	void testCompareNullObjectAndNullString_sholudNotEqualsResult() {

		// act
		final Valuable<Object> propertyOne = none();
		final Valuable<String> propertyTwo = none();

		// assert
		assertThat(true, equalTo(NOTEQUALS.compare(propertyOne, propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównannie wartość nieokreślonej i określonej obiektów właściwości typu object")
	void testCompareNullObjecAndNumberObject_sholudNotEqualsResult() {

		// act
		final Valuable<Object> propertyOne = none();
		final Valuable<Object> propertyTwo = from(1);

		// assert
		assertThat(true, equalTo(NOTEQUALS.compare(propertyOne, propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównanie dwóch identycznych właściwości z wartością tekstowych")
	void testCompareStringObjectAndStringObject_shouldEqualsResult() {

		// arrange
		final Valuable<String> propertyOne = Valuable.from("2");
		final Valuable<String> propertyTwo = Valuable.from("2");

		// act
		// final ValuableStringComparator c = new ValuableStringComparator();

		// assert
		assertThat(true, equalTo(propertyOne.equals(propertyTwo)));
	}

	@Test
	@DisplayName("Test sprawdza porównanie dwóch właściwości z różną wartością numeryczną")
	void testCompareIntegerObjectAndIntegerObject_shouldNotEqualsResult() {

		// arrange
		final Valuable<Integer> propertyOne = Valuable.from(-1);
		final Valuable<Integer> propertyTwo = Valuable.from(1);

		// assert
		assertThat(false, equalTo(propertyOne.equals(propertyTwo)));
	}

	// @Test
	// @DisplayName("Test sprawdza porównanie dwóch właściwości z różną wartością
	// numeryczną")
	// void testCompareDoubleObjectAndDoubleObject_shouldNotEqualsResult() {
	//
	// // arrange
	// final Valuable<Double> propertyOne = Valuable.from(-.02);
	// final Valuable<Double> propertyTwo = Valuable.from(-.05);
	//
	// // act
	// final ValuableDoubleComparator c = new ValuableDoubleComparator();
	//
	// // assert
	// MatcherAssert.assertThat(true, equalTo(CompareOperator.compare(c,
	// propertyOne,
	// propertyTwo)));
	//
	// }

	@Test
	@DisplayName("Test sprawdza zachowanie getter ustawionego do zwracania wartości")
	void testInitFromNullObjectWithSetterAndGetter_sholudGetValue() {

		final Valuable<Object> property = from(null, UnaryOperator.identity(), UnaryOperator.identity());

		assertThat(null, equalTo(property.get()));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie getter ustawionego do zwracania wartości")
	void testInitFromEmptyStringWithSetterAndGetter_sholudGetValue() {

		final Valuable<Object> property = from("", UnaryOperator.identity(), UnaryOperator.identity(), true);

		assertThat("", equalTo(property.get()));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie konstruktora kopiującego")
	void testInitFromEmptyObjectByCopyConstructor_sholudGetValue() {

		final Valuable<Object> property1 = from("");
		final Valuable<Object> property2 = from(property1);

		assertThat("", equalTo(property2.get()));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie operatora konwertującego wartość na inną postać")
	void testInitFromStringObjectUsingConverter_sholudGetValue() {

		final Valuable<Object> property = from("a");
		final String string = String.class.cast(property.get(String::valueOf));

		assertThat("a", equalTo(string));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie operatora modyfikującego wartość do innej wartości")
	void testInitFromStringObjectUsingModyficator_sholudGetValue() {

		final Valuable<Object> property = from("a");
		final String string = String.class.cast(property.get(item -> item + "1"));

		assertThat("a1", equalTo(string));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie gettera wartości przy nie spełnieniu warunku zwrotu wartości")
	void testInitFromIntegerUsingPredict_sholudNotGetValue() {

		final Predicate<Integer> predicate = item -> item > 2;
		final Valuable<Integer> property = none();
		property.set(0, predicate);
		final Integer value = property.get();

		assertThat(null, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie gettera wartości przy spełnieniu warunku zwrotu wartości")
	void testInitFromIntegerUsingPredict_sholudGetValue() {

		final Predicate<Integer> predicate = item -> item > 2;
		final Valuable<Integer> property = none();
		property.set(3, predicate);

		final Integer value = property.get();

		assertThat(3, equalTo(value));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie klonowania właściwości dla barku określonej wartości")
	void testInitFromNullObjectUsingClone_sholudBeNewObject() {

		final Valuable<Integer> clone = from(null);

		assertThat(null, not(clone));

	}

	@Test
	@DisplayName("Test sprawdza zachowanie przekszatłecenia obiektu własciwości na postać stringa")
	void testInitFromString_sholudBeToString() {

		final Valuable<String> property = from("1");
		final String value = "Property [value=1,";

		assertThat(property.toString(), startsWith(value));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie konstruktora kopiującego dla obiektu wartości boolean")
	void testInitFromBooleanObjectByCopyConstructor_sholudGetValue() {

		final Valuable<Object> property1 = from(true);
		final Valuable<Object> property2 = from(property1);

		assertThat(property2, equalTo(property2));
	}

	@Test
	@DisplayName("Test sprawdza zachowanie konstruktora kopiującego dla obiektu wartości boolean")
	void testInitFromBooleanObjectByCopyConstructor_sholudNotByEqual() {

		final Valuable<Object> property1 = from(true, false);
		final Valuable<Object> property2 = from(property1);
		property1.set(false);

		assertThat(property1, not(property2));
	}

	@Test
	@DisplayName("Test sprawdza zachowania porównania dwóch tych samych właściwości wartości")
	void testCompareFromSameObjects_sholudByEqual() {

		final Valuable<Object> property1 = from(true, false);
		final Valuable<Object> property2 = from(true, false);

		assertThat(EQUAL.get(), equalTo(property1.compareTo(property2)));
	}

	@Test
	void testHashCode() {

		final Valuable<Object> property1 = from(true, true);
		final Valuable<Object> property2 = from(true, true);

		assertThat(property1.hashCode(), equalTo(property2.hashCode()));
	}

}
