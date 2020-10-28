package com.codigo.smartstore.sdk.core.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ChainComparator<T>
	implements Comparator<T> {

	public static void main(final String[] args) {

		final List<Character> array1 = Arrays.asList('a', 'z', 'm');
		final List<Integer> array2 = Arrays.asList(1, 2, 0);
		final List<Double> array3 = Arrays.asList(.1, .2, .0, .11);

		ChainComparator.sort(array1, Character::compare);
		ChainComparator.sort(array2, Integer::compare);
		ChainComparator.sort(array3, Double::compare);

		System.out.println(array1);
		System.out.println(array2);
		System.out.println(array3);

	}

	private final List<Comparator<? super T>> comparators;

	public ChainComparator(final List<Comparator<? super T>> comparators) {

		this.comparators = comparators;
	}

	@SafeVarargs
	public ChainComparator(final Comparator<? super T>... comparators) {

		this(Arrays.asList(comparators));
	}

	@Override
	public int compare(final T o1, final T o2) {

		for (final Comparator<? super T> c : this.comparators) {

			final int result = c.compare(o1, o2);
			if (result != 0)
				return result;
		}
		return 0;
	}

	@SafeVarargs
	public static <T> void sort(final List<T> list, final Comparator<? super T>... comparators) {

		Collections.sort(list, new ChainComparator<>(comparators));
	}
}