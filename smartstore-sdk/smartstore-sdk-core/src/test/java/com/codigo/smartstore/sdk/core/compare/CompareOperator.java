package com.codigo.smartstore.sdk.core.compare;

import static com.codigo.smartstore.sdk.core.compare.CompareResult.EQUAL;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.IS_EQUAL;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.IS_LESS;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.IS_MORE;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.LESS;
import static com.codigo.smartstore.sdk.core.compare.CompareResult.MORE;

import java.util.Comparator;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum CompareOperator implements
		IComparable {

	EQUALS {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			CompareOperator.checkObjectClass(leftOperand, rightOperand);

			@SuppressWarnings("unchecked")
			final Comparable<Object> comparable = Comparable.class.cast(leftOperand);

			return comparable.compareTo(rightOperand) == EQUAL.result();
		}

	},
	NOTEQUALS {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			return !EQUALS.compare(leftOperand, rightOperand);
		}

	},
	GREATERTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			CompareOperator.checkObjectClass(leftOperand, rightOperand);

			@SuppressWarnings("unchecked")
			final Comparable<Object> comparable = Comparable.class.cast(leftOperand);

			return comparable.compareTo(rightOperand) == MORE.result();
		}

	},
	NOTGREATERTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			return !GREATERTHEN.compare(leftOperand, rightOperand);
		}

	},
	EQUALSGREATERTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			CompareOperator.checkObjectClass(leftOperand, rightOperand);

			@SuppressWarnings("unchecked")
			final Comparable<Object> comparable = Comparable.class.cast(leftOperand);

			return (comparable.compareTo(rightOperand) == EQUAL.result())
					|| (comparable.compareTo(rightOperand) == MORE.result());
		}

	},
	NOTEQUALSGREATERTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			return !EQUALSGREATERTHEN.compare(leftOperand, rightOperand);
		}

	},
	LESSTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			CompareOperator.checkObjectClass(leftOperand, rightOperand);

			@SuppressWarnings("unchecked")
			final Comparable<Object> comparable = Comparable.class.cast(leftOperand);

			return comparable.compareTo(rightOperand) == LESS.result();
		}

	},
	NOTLESSTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			return !LESSTHEN.compare(leftOperand, rightOperand);
		}

	},
	EQUALSLESSTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			CompareOperator.checkObjectClass(leftOperand, rightOperand);

			@SuppressWarnings("unchecked")
			final Comparable<Object> comparable = Comparable.class.cast(leftOperand);

			return (comparable.compareTo(rightOperand) == EQUAL.result())
					|| (comparable.compareTo(rightOperand) == LESS.result());
		}

	},
	NOTEQUALSLESSTHEN {

		@Override
		public boolean compare(@NonNull final Comparable<?> leftOperand, @NonNull final Comparable<?> rightOperand) {

			return !EQUALSLESSTHEN.compare(leftOperand, rightOperand);
		}
	};

	/**
	 * @param comparator
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> boolean compare(final Comparator<T> comparator, final T first, final T second) {

		final int result = comparator.compare(first, second);

		switch (result) {

		case IS_LESS:
			return result == LESS.get();

		case IS_MORE:
			return result == MORE.get();

		case IS_EQUAL:
			return result == EQUAL.get();

		default:
			throw new UnsupportedOperationException();
		}
	}

	/**
	 *
	 * @param leftOperand
	 * @param rightOperand
	 */
	private static void checkObjectClass(@NonNull final Comparable<?> leftOperand,
			@NonNull final Comparable<?> rightOperand) {

		if (leftOperand.getClass() != rightOperand.getClass())
			throw new UnsupportedOperationException("leftOperand.getClass() != rightOperand.getClass()");
	}

}
