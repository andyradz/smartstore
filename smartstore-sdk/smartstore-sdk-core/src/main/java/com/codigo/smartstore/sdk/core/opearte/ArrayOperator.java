package com.codigo.smartstore.sdk.core.opearte;

import static com.codigo.smartstore.sdk.core.constans.Default.zero;
import static com.codigo.smartstore.sdk.core.messages.errors.ErrorsCoreMessages.getNullPointerExceptioMessage;
import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.stream;
import static java.util.Objects.isNull;
import static java.util.stream.IntStream.range;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

// TODO: dodaĆ Paginator dla tablicy elementów
/**
 * Klasa zawiera najczęściej stosowane metody do obsługi kolekcji typu tablica.
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.1
 * @since 2017
 * @category helpers
 */
public final class ArrayOperator {

	/**
	 * Klasa typu reprzentująca indeks dla tablicy elementów
	 */
	private static final Class<Integer> ARRAYINDEXTYPE = Integer.class;

	/**
	 * Metoda wyznacza średnią wartości numeryczną z elementów kolekcji typu
	 * tablica.
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Tablica wartości numerycznych
	 * @return Średnia wartość wyznaczona z wartości elementów tablicy
	 * @throws NullPointerException Brak instancji tablicy w pamieci
	 */
	public static <E extends Number> double avg(final E[] array) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		return stream(array).map(Number::doubleValue)
				.mapToDouble(Double::doubleValue)
				.average()
				.getAsDouble();
	}

	/**
	 * Metoda wyznacza duplikaty wartości z tablicy elementów.
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Tablica wartości numerycznych
	 * @return Strumień danych wyznaczający duplikaty z tablicy wartości.
	 * @throws NullPointerException Brak instancji tablicy w pamieci
	 */
	public static <E> Stream<E> duplicate(final E[] array) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		return stream(array).filter(n -> stream(array).filter(x -> x == n)
				.count() > 1)
				.distinct();
	}

	/**
	 * Metoda zwraca numer ostatniego indeksu tablicy dwuwymiarowej
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Kolekcja danych typu tablica
	 * @param dimension Wymiar tablicy
	 * @return Numer ostattniego indeksu tablicy dwuwymiarowej
	 * @throws NullPointerException Brak instancji tablicy w pamieci
	 */
	public static <E> long hbound(final E[][] array, final int dimension) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		// TODO: dodać preconditional do weryfikacji parametru dimenssion

		final long count = stream(array[dimension]).count();

		if (count <= zero(Long.class))
			throw new ArrayIndexOutOfBoundsException("Tablica elementów nie posiada ostatniego indeksu!");

		return count - 1;
	}

	/**
	 * Metoda zwraca numer ostatniego indeksu tablicy jednowymiarowej
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Kolekcja danych typu tablica
	 * @return Numer ostatniego indeksu tablicy
	 * @throws NullPointerException Brak instancji tablicy w pamieci
	 */
	public static <E> long hbound(final E[] array) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		// w przypadku braku elementów w tablicy zwraca wartość -1
		return array.length - 1L;
	}

	/**
	 * Metoda zwraca numer pierwszego indeksu tablicy jednowymiarowej
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Kolekcja danych typu tablica
	 * @return Numer pierwszego indeksu tablicy
	 */
	public static <E> long lbound(final E[] array) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		return zero(Long.class);
	}

	/**
	 * Metoda wyznacza wspólne elementy dwóch kolekcji typu tablica
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param clazz Klasa elementów tablicy
	 * @param firstArray Pierwsza kolekcja
	 * @param lastArray Kolejna kolekcja
	 * @return Kolekcja elmentów znajdujących sie w obu tablcach elementów
	 */
	public static <E> E[] intersect(final Class<E[]> clazz, final E[] firstArray, final E[] lastArray) {

		if (firstArray == lastArray)
			return firstArray;

		return stream(firstArray).filter(left -> stream(lastArray).anyMatch(right -> right.equals(left)))
				.toArray(e1 -> clazz.cast(Array.newInstance(clazz.getComponentType(),
					firstArray.length >= lastArray.length ? firstArray.length : lastArray.length)));
	}

	/**
	 * Metoda wykonuje połączenie dwóch kolekcji typu tablica w jedną
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param firstArray Pierwsza kolekcja danych
	 * @param lastArray Następna kolekcja danych
	 * @return Iterator połączonych kolekcji typu tablica
	 * @throws NullPointerException Brak instancji tablicy w pamieci
	 */
	public static <E> Iterator<E> join(final E[] firstArray, final E[] lastArray) {

		if (isNull(firstArray))
			throw getNullPointerExceptioMessage(firstArray);

		if (isNull(lastArray))
			throw getNullPointerExceptioMessage(lastArray);

		return Stream.concat(stream(firstArray), stream(lastArray))
				.iterator();
	}

	/**
	 * Metoda wyznacza maksymalną wartość elementu tablicy. Maksymalna wartość
	 * wyznaczana jest na podstawie przekazanego komparatora.
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Tablica elementów
	 * @param comparator Komparator elementów kolekcji
	 * @return Maksymalna wartość elemntu kolkecji
	 * @throws NullPointerException Brak instancji tablicy, Brak instancji
	 * komparatora
	 */
	public static <E extends Comparable<E>> Optional<E> max(final E[] array, final Comparator<E> comparator) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		if (isNull(comparator))
			throw getNullPointerExceptioMessage(comparator);

		return stream(array).max(comparator);
	}

	/**
	 * Metoda wyznacza minimalną wartość elementu tablicy. Minimalna wartość
	 * wyznaczana jest na podstawie przekazanego komparatora.
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Tablica elementów
	 * @param comparator Komparator elementów kolekcji
	 * @return Minimalna wartość elementu kolekcji
	 * @throws NullPointerException Brak instancji tablicy, Brak instancji
	 * komparatora
	 */
	public static <E extends Comparable<E>> Optional<E> min(final E[] array, final Comparator<E> comparator) {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		if (isNull(comparator))
			throw getNullPointerExceptioMessage(comparator);

		return stream(array).min(comparator);
	}

	/**
	 * Metoda wykonuje zmianę rozmiaru kolekcji
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Kolekcja danych
	 * @param size Nowy rozmiar kolekcji danych
	 * @return Kolekcja typu tablica
	 * @throws NullPointerException Brak instancji tablicy w pamięci
	 * @throws IllegalArgumentException Nieprawidłowa wartość nowego rozmiaru
	 * tablicy
	 * @throws OutOfMemoryError Brak zasobóW do alokacji tablicy o takim rozmiarze
	 */
	public static <E> E[] resize(final E[] array, final int size) throws OutOfMemoryError {

		if (isNull(array))
			throw getNullPointerExceptioMessage(array);

		if (zero(ArrayOperator.ARRAYINDEXTYPE) > size)
			throw new IllegalArgumentException("Rozmiar tablicy nie może być wartością ujemną!");

		if (zero(ArrayOperator.ARRAYINDEXTYPE).equals(size))
			return array;

		return copyOf(array, size);
	}

	/**
	 * Metoda wykonuje sortowanie elementów kolekcji na podstawie wskazanego
	 * komparatora danych.
	 *
	 * @param <E> Generyczny typ klasy elementów kolekcji
	 * @param array Kolekcja danych
	 * @param comparator Komparator danych
	 * @return Iterator elementów posortowanej tablicy danych
	 */
	public static <E> Iterator<E> sort(final E[] array, final Comparator<E> comparator) {

		return stream(array).sorted(comparator)
				.iterator();
	}

	/**
	 * Metoda tworzy instancję tablicy bajtów na podstawie przekazanej wartości
	 * Double. Rozmiar tablicy ustalany jest na podstawie ilość bajtów typu Double.
	 *
	 * @param value Wartość rzeczywista
	 * @return Tablica bajtów
	 */
	public static byte[] toByteArray(final double value) {

		final byte[] bytes = new byte[Double.SIZE];
		ByteBuffer.wrap(bytes)
				.putDouble(value);

		return bytes;
	}

	/**
	 * Metoda wykonuje połączenie dwóch posortowanych kolekcji w jedną z zachowaniem
	 * kolejności elementów.
	 *
	 * @param <E> Generyczny typ elementów kolekcji
	 * @param type Klasa elemntów kolekcji
	 * @param firstArray Pierwsza kolekcja elementów
	 * @param lastArray Nastpna kolekcja elementów
	 * @return Posortowana tablica połączonych dwóch kolekcji elementów
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <E extends Comparable<E>> E[] merge(final Class<E[]> type, final E[] firstArray,
			final E[] lastArray) {

		if (isNull(firstArray))
			throw getNullPointerExceptioMessage(firstArray);

		if (isNull(lastArray))
			throw getNullPointerExceptioMessage(lastArray);

		if (firstArray == lastArray)
			return firstArray;

		if (ArrayOperator.isEmpty(firstArray) && !ArrayOperator.isEmpty(lastArray))
			return lastArray;

		if (ArrayOperator.isEmpty(lastArray) && !ArrayOperator.isEmpty(firstArray))
			return firstArray;

		final E[] mergedArray = type
				.cast(Array.newInstance(type.getComponentType(), firstArray.length + lastArray.length));
		Integer firstArrayIndex, lastArrayIndex, mergedArrayIndex;

		firstArrayIndex = lastArrayIndex = mergedArrayIndex = zero(Integer.class);

		firstArrayIndex = lastArrayIndex = mergedArrayIndex = zero(ArrayOperator.ARRAYINDEXTYPE);

		while ((firstArrayIndex < firstArray.length) && (lastArrayIndex < lastArray.length)) {

			mergedArray[mergedArrayIndex] = firstArray[firstArrayIndex].compareTo(lastArray[lastArrayIndex]) <= zero(
				ArrayOperator.ARRAYINDEXTYPE) ? firstArray[firstArrayIndex++] : lastArray[lastArrayIndex++];
			++mergedArrayIndex;
		}

		if (firstArrayIndex < firstArray.length)
			arraycopy(firstArray, firstArrayIndex, mergedArray, mergedArrayIndex, firstArray.length - firstArrayIndex);
		else if (lastArrayIndex < lastArray.length)
			arraycopy(lastArray, lastArrayIndex, mergedArray, mergedArrayIndex, lastArray.length - lastArrayIndex);

		return mergedArray;
	}

	/**
	 * Metoda sprawdza czy kolekcja jest pusta (nie posiada elementów)
	 *
	 * @param <E> type Generyczny typ elementów kolekcji
	 * @param array Tablica elementów typu T
	 * @return Wartość logiczna true gdy tablica pusta, wartośc false gdy tablica
	 * posiada elementy
	 */
	public static <E> boolean isEmpty(final E[] array) {

		return zero(ArrayOperator.ARRAYINDEXTYPE).equals(array.length);
	}

	/**
	 * Metoda zwraca pustą instancj tablice (nie posiada elementów)
	 *
	 * @param <E> Generyczny typ elementów kolekcji
	 * @param type Typ elementów tablicy
	 * @return Pusta instancja tablicy
	 */
	public static <E> E[] empty(final Class<E[]> type) {

		return type.cast(Array.newInstance(type.getComponentType(), 0));
	}

	/**
	 * Metoda czyści wszystkie elementy kolekcji
	 *
	 * @param <E> Generyczny typ elemenów tablicy
	 * @param array Kolekcja elementów
	 */
	public static <E> void clear(final E[] array) {

		fill(array, null);
	}

	/**
	 * Metoda wyszukuje element w kolekcji i wyznacza numer pozycji tego elementu w
	 * kolekcji.
	 *
	 * @param <E> Generyczny typ klasy elementu kolekcji
	 * @param array Kolekcja elementów
	 * @param element Szukany element
	 * @return Numer pozycji elementu w kolekcji
	 */
	public static <E> OptionalInt indexOf(final E[] array, final E element) {

		return range(zero(ArrayOperator.ARRAYINDEXTYPE), array.length).filter(i -> array[i].equals(element))
				.findAny();
	}

	/**
	 * Podstawowy konstruktor obiektu klasy <code>ArrayOperator</code>
	 */
	private ArrayOperator() {

	}

}
