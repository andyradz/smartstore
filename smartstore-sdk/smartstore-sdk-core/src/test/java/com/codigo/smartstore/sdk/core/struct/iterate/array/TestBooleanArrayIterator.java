package com.codigo.smartstore.sdk.core.struct.iterate.array;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIterable;
import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIteratorFactory;

// @RunWith(JUnitPlatform.class)
class TestBooleanArrayIterator {

	final Boolean[] array = { false, true, true, false, false, false, true, false, true, false, true, true };

	@DisplayName("Test add user successfully.")
	@Test
	void testShouldCount12_Of() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.of(this.array);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCount(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(this.array.length, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeFirst_To_First() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(this.array, 0, 0);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(1, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeLast_To_Last() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(this.array, 11, 11);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(1, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount9_OfRangeOne_To_Nine() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(this.array, 1, 9);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(9, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount1_OfCount_One() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofCount(this.array, 1);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(1, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount1_OfFrst_Ten() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofFirst(this.array, 10);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(1, CoreMatchers.is(itemsCount));
	}

	@Test
	void testShouldCount6_OfLast_Five() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofLast(this.array, 5);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		MatcherAssert.assertThat(iterator.getCountFromRange(), CoreMatchers.is(itemsCount));
		MatcherAssert.assertThat(6, CoreMatchers.is(itemsCount));
	}
}
