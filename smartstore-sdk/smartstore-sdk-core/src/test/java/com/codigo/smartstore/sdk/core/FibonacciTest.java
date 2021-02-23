package com.codigo.smartstore.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;
import java.util.EnumSet;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

// @RunWith(Parameterized.class)
class FibonacciTest {

	// @Parameters
	// public static Collection<Object[]> data() {
	//
	// return Arrays.asList(new Object[][] { { 1, 1 }, { 2, 4 }, { 3, 9 } });
	// }
	//
	// private final int input;
	//
	// private final int expected;
	//
	// public FibonacciTest(final int input, final int expected) {
	//
	// this.input = input;
	// this.expected = expected;
	// }
	//
	// // @Test
	// public void test() {
	//
	// assertEquals(this.expected, Math.pow(3, 2));
	// }

	static boolean isOdd(final int number) {

		return (number % 2) != 0;
	}

	static boolean isEven(final int number) {

		return (number % 2) == 0;
	}

	static boolean isBlank(final String input) {

		return Objects.isNull(input) || input.trim()
				.isEmpty();
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE }) // six numbers
	void isOdd_ShouldReturnTrueForOddNumbers(final int number) {

		assertTrue(FibonacciTest.isOdd(number));
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, -100, -102, -0, Integer.MIN_VALUE })
	void isEven_ShouldReturnTrueEvenNumber(final int number) {

		assertTrue(isEven(number));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " " })
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(final String input) {

		assertTrue(isBlank(input));
	}

	@ParameterizedTest
	@NullSource
	void isBlank_ShouldReturnTrueForNullInputs(final String input) {

		assertTrue(isBlank(input));
	}

	@ParameterizedTest
	@EmptySource
	void isBlank_ShouldReturnTrueForEmptyStrings(final String input) {

		assertTrue(isBlank(input));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void isBlank_ShouldReturnTrueForNullAndEmptyStrings(final String input) {

		assertTrue(isBlank(input));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { " ", "\n", "\t" })
	void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(final String input) {

		assertTrue(isBlank(input));
	}

	@ParameterizedTest
	@EnumSource(Month.class) // passing all 12 months
	void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(final Month month) {

		final int monthNumber = month.getValue();
		assertTrue((monthNumber >= 1) && (monthNumber <= 12));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" })
	void someMonths_Are30DaysLong(final Month month) {

		final boolean isALeapYear = false;
		assertEquals(30, month.length(isALeapYear));
	}

	@ParameterizedTest
	@EnumSource(
		value = Month.class,
		names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY" },
		mode = EnumSource.Mode.EXCLUDE)
	void exceptFourMonths_OthersAre31DaysLong(final Month month) {

		final boolean isALeapYear = false;
		assertEquals(31, month.length(isALeapYear));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
	void fourMonths_AreEndingWithBer(final Month month) {

		final EnumSet<Month> months = EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
		assertTrue(months.contains(month));
	}

	@ParameterizedTest
	@CsvSource({ "test,TEST", "tEst,TEST", "Java,JAVA" })
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(final String input, final String expected) {

		final String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

	@ParameterizedTest
	@CsvSource(value = { "test:test", "tEst:test", "Java:java" }, delimiter = ':')
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(final String input, final String expected) {

		final String actualValue = input.toLowerCase();
		assertEquals(expected, actualValue);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(final String input, final String expected) {

		final String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

	private static Stream<Arguments> provideStringsForIsBlank() {

		return Stream.of(
			Arguments.of(null, true),
			Arguments.of("", true),
			Arguments.of("  ", true),
			Arguments.of("not blank", false)
		);
	}

	@ParameterizedTest
	@MethodSource // hmm, no method name ...
	void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(final String input) {

		assertTrue(isBlank(input));
	}

	private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {

		return Stream.of(null, "", "  ");
	}

	@ParameterizedTest
	@MethodSource("provideStringsForIsBlank")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(final String input, final boolean expected) {

		assertEquals(expected, isBlank(input));
	}

	// https://www.baeldung.com/parameterized-tests-junit-5

}