package com.codigo.smartstore.sdk.core.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

class ChainComparator<T>
	implements Comparator<T> {

	private static Logger log = Logger.getLogger(ChainComparator.class);

	public static void main(final String[] args) {

		final Runnable run1 = (
		) -> {

			try {

				for (int i = 0; i < 1000; i++) {

					System.out.println(String.format("(%s) %3d - %s(%3d)",
						Thread.currentThread()
								.getName(),
						i,
						"jestem",
						1000 - i));
					Thread.sleep(100);
				}
			} catch (final InterruptedException ex) {

				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		};

		new Thread(run1).start();
		new Thread(run1).start();
		new Thread(run1).start();
		new Thread(run1).start();

		final List<Character> array1 = Arrays.asList('a', 'z', 'm');
		final List<Integer> array2 = Arrays.asList(1, 2, 0);
		final List<Double> array3 = Arrays.asList(.1, .2, .0, .11);

		final Comparator<Integer> compareInteger = Integer::compareTo;

		ChainComparator.sort(array1, Character::compare);
		ChainComparator.sort(array2, Integer::compare, compareInteger);
		ChainComparator.sort(array3, Double::compare);

		log.info(array1);
		log.info(array2);
		log.info(array3);
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