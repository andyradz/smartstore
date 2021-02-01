package com.codigo.smartstore.timeline;

import static com.codigo.smartstore.sdk.core.TimeSpec.TimeRelations.MAXDAYSPERMONTH;
import static com.codigo.smartstore.sdk.core.TimeSpec.TimeRelations.MONTHSPERYEAR;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import com.codigo.smartstore.sdk.core.TimeSpan;
import com.codigo.smartstore.sdk.core.compare.CompareOperator;
import com.codigo.smartstore.sdk.core.compare.IComparable;

// ------------------------------------------------------------------------
public class Date
	implements IComparable {

	private final LocalDate date;

	public Date(final LocalDateTime date) {

		this.date = date.toLocalDate();
	}

	// ----------------------------------------------------------------------
	public Date(final int year, final int month, final int day) {

		if ((year < LocalDate.MIN.getYear()) || (year > LocalDateTime.MAX.getYear()))
			throw new IllegalArgumentException("year");

		if ((month <= 0) || (month > MONTHSPERYEAR.get()))
			throw new IllegalArgumentException("month");

		if ((day <= 0) || (day > MAXDAYSPERMONTH.get()))
			throw new IllegalArgumentException("day");

		this.date = LocalDate.of(year, month, day);
	}

	public int year() {

		return this.date.getYear();
	}

	public int month() {

		return this.date.getMonthValue();
	}

	public int Day() {

		return this.date.getDayOfMonth();
	}

	public LocalDate date() {

		return this.date;
	}

	/**
	 * @param other
	 * @return
	 */
	public int compareTo(final Date other) {

		return this.date.compareTo(other.date);
	}

	public int compareTo(final Object obj) {

		return this.date.compareTo((Date.class.cast(obj)).date);
	}

	public boolean equals(final Date other) {

		return this.date.equals(other.date);
	}

	@Override
	public String toString() {

		return this.date.toString(); // only the date part
	}

	@Override
	public boolean equals(final Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;

		return this.equals((Date) obj);
	}

	@Override
	public int hashCode() {

		return 0;
		// return HashTool.ComputeHashCode(GetType().GetHashCode(), date);
	} // GetHashCode

	public static TimeSpan minus(final LocalDate date1, final LocalDate date2) {

		final var period = Period.between(date1, date2);

		return new TimeSpan(period.getYears(), period.getMonths(), period.getDays());
	}

	public static LocalDate minus(final LocalDate date, final TimeSpan duration) {

		final Duration dur = Duration.ofMillis((duration.totalMilliseconds()
				.get()
				.longValue()));

		return date.minus(dur.toDays(), ChronoUnit.DAYS);
	}

	@Override
	public boolean compare(final Comparable<?> leftOperand, final Comparable<?> rightOperand) {

		return false;
	}

	public static LocalDate plus(final LocalDate date, final TimeSpan duration) {

		final Duration dur = Duration.ofMillis((duration.totalMilliseconds()
				.get()
				.longValue()));

		return date.plus(dur.toDays(), ChronoUnit.DAYS);
	}

	public static boolean lessThen(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.LESSTHEN.compare(date1, date2);
	}

	public static boolean lessEqualThen(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.EQUALSLESSTHEN.compare(date1, date2);
	}

	public static boolean equals(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.EQUALS.compare(date1, date2);
	}

	public static boolean notEquals(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.NOTEQUALS.compare(date1, date2);
	}

	public static boolean greaterThen(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.GREATERTHEN.compare(date1, date2);
	}

	public static boolean greatetEqualThen(final LocalDate date1, final LocalDate date2) {

		return CompareOperator.EQUALSGREATERTHEN.compare(date1, date2);
	}

	public LocalDateTime toDateTime(final Time time) {

		return Date.toDateTime(this, time);
	}

	public LocalDateTime toDateTime(final int hour, final int minute, final int second, final int millisecond) {

		return Date.toDateTime(this, hour, minute, second, millisecond);
	}

	public static LocalDateTime toDateTime(final Date date, final Time time) {

		final LocalTime mid = LocalTime.MIDNIGHT;
		final LocalDate dt = LocalDate.of(date.year(), date.month(), date.Day());

		return LocalDateTime.of(dt, mid)
				.plus(time.totalMilliseconds()
						.get()
						.longValue(),
					ChronoUnit.MILLIS);
	}

	public static LocalDateTime toDateTime(final Date date, final int hour, final int minute, final int second,
			final int millisecond) {

		// TODO: błąd minisekundy na na nbosekundy
		return LocalDateTime.of(date.year(), date.month(), date.Day(), hour, minute, second, millisecond);
	}
	//
	// @Override
	// public boolean compare(final Comparable<?> leftOperand, final Comparable<?>
	// rightOperand) {
	//
	// // TODO Auto-generated method stub
	// return false;
	// }

} // struct Date
