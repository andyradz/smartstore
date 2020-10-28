package com.codigo.smartstore.sdk.core.struct.iterate.array;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIterable;
import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIteratorFactory;

class TestsStringArrayIterator {

	static final String[] array = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "", "null" };

	@Test
	void testShouldCount12_Of() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.of(array);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCount(), equalTo(itemsCount));
		assertThat(array.length, equalTo(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeFirst_To_First() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofRange(array, 0, 0);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(1, equalTo(itemsCount));
	}

	@Test
	void testShouldCount1_OfRangeLast_To_Last() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofRange(array, 11, 11);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(1, equalTo(itemsCount));
	}

	@Test
	void testShouldCount9_OfRangeOne_To_Nine() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofRange(array, 1, 9);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(9, equalTo(itemsCount));
	}

	@Test
	void testShouldCount1_OfCount_One() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofCount(array, 1);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(1, equalTo(itemsCount));
	}

	@Test
	void testShouldCount1_OfFrst_Ten() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofFirst(array, 10);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(1, equalTo(itemsCount));
	}

	@Test
	void testShouldCount6_OfLast_Five() {

		// ...Arrange
		int itemsCount = 0;

		final ArrayIterable<String> iterator = ArrayIteratorFactory.ofLast(array, 5);
		// log.info(iterator);

		// ...Act
		while (iterator.hasNext()) { iterator.next(); itemsCount++; }

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsCount));
		assertThat(6, equalTo(itemsCount));
	}

}
