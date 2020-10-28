package com.codigo.smartstore.sdk.core.struct.iterate.array;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIterable;
import com.codigo.smartstore.sdk.core.structs.iterate.array.ArrayIteratorFactory;

public class TestArrayIteratorReadCount {

	private static Logger log = Logger.getLogger(TestArrayIteratorReadCount.class);

	static final Double[] array = { 0.9, 99.2, 09.3, 232343.09, 2321.0, 1231.2, 12D, .09, 12D, .0923D, .3D, 4.5D };

	@Test
	@DisplayName("Test oczekuje liczby odczytanych rekordów równej ilość elementów kolekcji danych")
	public void testShouldBe_CountRead12() {

		// ...Arrange
		int itemsReadCount = 0;

		final ArrayIterable<Double> iterator = ArrayIteratorFactory.of(array);
		log.info(iterator);

		// ...Act
		while (iterator.hasNext())
			iterator.next();

		itemsReadCount = iterator.getCountVisited();

		// ...Assert
		assertThat(iterator.getCount(), equalTo(itemsReadCount));
		assertThat(array.length, equalTo(itemsReadCount));
	}

	@Test
	@DisplayName("Test oczekuje liczby odczytanych rekordów równej jeden(1)")
	public void testShouldBe_CountRead1() {

		// ...Arrange
		int itemsReadCount = 0;

		final ArrayIterable<Double> iterator = ArrayIteratorFactory.ofRange(array, 1, 1);
		log.info(iterator);

		// ...Act
		while (iterator.hasNext())
			iterator.next();

		itemsReadCount = iterator.getCountVisited();

		// ...Assert
		assertThat(1, equalTo(itemsReadCount));
	}

	@Test
	@DisplayName("Test oczekuje liczby odczytanych rekordów równej jeden(5)")
	public void testShouldBe_CountRead2() {

		// ...Arrange
		int itemsReadCount = 0;

		final ArrayIterable<Double> iterator = ArrayIteratorFactory.ofRange(array, 11, 11);
		log.info(iterator);

		// ...Act
		while (iterator.hasNext())
			iterator.next();

		itemsReadCount = iterator.getCountVisited();

		// ...Assert
		assertThat(iterator.getCountFromRange(), equalTo(itemsReadCount));
	}
}
