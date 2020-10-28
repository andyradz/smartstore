package com.codigo.smartstore.sdk.core.struct.iterate.array;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIterable;
import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIteratorFactory;

class TestsBooleanArrayIterator {

	static final Boolean[] array = { false, true, true, false, false, false, true, false, true, false, true, true };

	@DisplayName("Test add user successfully.")
	@Test
	void testShouldCount12_Of() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.of(array);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCount(), is(itemsCount));
		assertThat(array.length, is(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeFirst_To_First() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(array, 0, 0);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(1, is(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeLast_To_Last() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(array, 11, 11);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(1, is(itemsCount));
	}

	@Test
	void testShouldCount9_OfRangeOne_To_Nine() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofRange(array, 1, 9);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(9, is(itemsCount));
	}

	@Test
	void testShouldCount1_OfCount_One() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofCount(array, 1);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(1, is(itemsCount));
	}

	@Test
	void testShouldCount1_OfFrst_Ten() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofFirst(array, 10);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(1, is(itemsCount));
	}

	@Test
	void testShouldCount6_OfLast_Five() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<Boolean> iterator = ArrayIteratorFactory.ofLast(array, 5);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), is(itemsCount));
		assertThat(6, is(itemsCount));
	}
}
