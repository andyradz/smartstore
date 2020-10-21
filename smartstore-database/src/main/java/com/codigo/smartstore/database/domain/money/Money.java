package com.codigo.smartstore.database.domain.money;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Currency;
import java.util.Objects;

public final class Money
	implements Comparable<Money>, Serializable {

	/**
	 * Thrown when a set of <tt>Money</tt> objects do not have matching currencies.
	 *
	 * <P>
	 * For example, adding together Euros and Dollars does not make any sense.
	 */
	public static final class MismatchedCurrencyException
			extends
			RuntimeException {

		private static final long serialVersionUID = -572918744321166344L;

		MismatchedCurrencyException(final String aMessage) {

			super(aMessage);
		}
	}

	/**
	 * Set default values for currency and rounding style.
	 *
	 * <em>Your application must call this method upon startup</em>. This method
	 * should usually be called only once (upon startup).
	 *
	 * <P>
	 * The recommended rounding style is {@link RoundingMode#HALF_EVEN}, also called
	 * <em>banker's rounding</em>; this rounding style introduces the least bias.
	 *
	 * <P>
	 * Setting these defaults allow you to use the more terse constructors of this
	 * class, which are much more convenient.
	 *
	 * <P>
	 * (In a servlet environment, each app has its own classloader. Calling this
	 * method in one app will never affect the operation of a second app running in
	 * the same servlet container. They are independent.)
	 */
	public static void init(final Currency defaultCurrency, final RoundingMode defaultRounding) {

		Money.DEFAULT_CURRENCY = defaultCurrency;
		Money.DEFAULT_ROUNDING = defaultRounding;
	}

	/**
	 * Full constructor.
	 *
	 * @param amount is required, can be positive or negative. The number of
	 * decimals in the amount cannot <em>exceed</em> the maximum number of decimals
	 * for the given {@link Currency}. It's possible to create a <tt>Money</tt>
	 * object in terms of 'thousands of dollars', for instance. Such an amount would
	 * have a scale of -3.
	 * @param currency is required.
	 * @param roundingStyle is required, must match a rounding style used by
	 * {@link BigDecimal}.
	 */
	public Money(final BigDecimal amount, final Currency currency, final RoundingMode roundingStyle) {

		this.mAmount = amount;
		this.mCurrency = currency;
		this.mRounding = roundingStyle;
		this.validateState();
	}

	/**
	 * Constructor taking only the money amount.
	 *
	 * <P>
	 * The currency and rounding style both take default values.
	 *
	 * @param amount is required, can be positive or negative.
	 */
	public Money(final BigDecimal amount) {

		this(amount, Money.DEFAULT_CURRENCY, Money.DEFAULT_ROUNDING);
	}

	/**
	 * Constructor taking the money amount and currency.
	 *
	 * <P>
	 * The rounding style takes a default value.
	 *
	 * @param amount is required, can be positive or negative.
	 * @param currency is required.
	 */
	public Money(final BigDecimal amount, final Currency currency) {

		this(amount, currency, Money.DEFAULT_ROUNDING);
	}

	/**
	 * Metoda zwraca wartość waluty.
	 *
	 * @return Wartość numeryczna.
	 */
	public BigDecimal getAmount() {

		return this.mAmount;
	}

	/**
	 * Metoda zwraca symbol waluty.
	 *
	 * @return Wartość tekstowa.
	 */
	public Currency getCurrency() {

		return this.mCurrency;
	}

	/**
	 * Return the rounding style passed to the constructor, or the default rounding
	 * style.
	 */
	public RoundingMode getRoundingStyle() {

		return this.mRounding;
	}

	/**
	 * Return <tt>true</tt> only if <tt>aThat</tt> <tt>Money</tt> has the same
	 * currency as this <tt>Money</tt>.
	 */
	public boolean isSameCurrencyAs(final Money money) {

		boolean result = false;
		if (money != null)
			result = this.mCurrency.equals(money.mCurrency);
		return result;
	}

	/** Return <tt>true</tt> only if the amount is positive. */
	public boolean isPlus() {

		return this.mAmount.compareTo(BigDecimal.ZERO) > 0;
	}

	/** Return <tt>true</tt> only if the amount is negative. */
	public boolean isMinus() {

		return this.mAmount.compareTo(BigDecimal.ZERO) < 0;
	}

	/** Return <tt>true</tt> only if the amount is zero. */
	public boolean isZero() {

		return this.mAmount.compareTo(BigDecimal.ZERO) == 0;
	}

	/**
	 * Add <tt>aThat</tt> <tt>Money</tt> to this <tt>Money</tt>. Currencies must
	 * match.
	 */
	public Money plus(final Money money) {

		this.checkCurrenciesMatch(money);
		return new Money(this.mAmount.add(money.mAmount), this.mCurrency, this.mRounding);
	}

	/**
	 * Subtract <tt>aThat</tt> <tt>Money</tt> from this <tt>Money</tt>. Currencies
	 * must match.
	 */
	public Money minus(final Money money) {

		this.checkCurrenciesMatch(money);
		return new Money(this.mAmount.subtract(money.mAmount), this.mCurrency, this.mRounding);
	}

	/**
	 * Sum a collection of <tt>Money</tt> objects. Currencies must match. You are
	 * encouraged to use database summary functions whenever possible, instead of
	 * this method.
	 *
	 * @param moneys collection of <tt>Money</tt> objects, all of the same currency.
	 * If the collection is empty, then a zero value is returned.
	 * @param currencyIfEmpty is used only when <tt>aMoneys</tt> is empty; that way,
	 * this method can return a zero amount in the desired currency.
	 */
	public static Money sum(final Collection<Money> moneys, final Currency currencyIfEmpty) {

		Money sum = new Money(BigDecimal.ZERO, currencyIfEmpty);
		for (final Money money : moneys)
			sum = sum.plus(money);
		return sum;
	}

	/**
	 * Equals (insensitive to scale).
	 *
	 * <P>
	 * Return <tt>true</tt> only if the amounts are equal. Currencies must match.
	 * This method is <em>not</em> synonymous with the <tt>equals</tt> method.
	 */
	public boolean eq(final Money money) {

		this.checkCurrenciesMatch(money);
		return this.compareAmount(money) == 0;
	}

	/**
	 * Procedura wykonuje sprawdzenie logiczne czy przekazana wartość pieniężna jest
	 * większa od wartości pieniężnej bieżącego obiektu.
	 *
	 * @param money Obiekt Wartość pienieżna
	 * @return
	 */
	public boolean gt(final Money money) {

		this.checkCurrenciesMatch(money);
		return this.compareAmount(money) > 0;
	}

	/**
	 * Greater than or equal to.
	 *
	 * <P>
	 * Return <tt>true</tt> only if 'this' amount is greater than or equal to 'that'
	 * amount. Currencies must match.
	 */
	public boolean gteq(final Money money) {

		this.checkCurrenciesMatch(money);
		return this.compareAmount(money) >= 0;
	}

	/**
	 * Less than.
	 *
	 * <P>
	 * Return <tt>true</tt> only if 'this' amount is less than 'that' amount.
	 * Currencies must match.
	 */
	public boolean lt(final Money aThat) {

		this.checkCurrenciesMatch(aThat);
		return this.compareAmount(aThat) < 0;
	}

	/**
	 * Less than or equal to.
	 *
	 * <P>
	 * Return <tt>true</tt> only if 'this' amount is less than or equal to 'that'
	 * amount. Currencies must match.
	 */
	public boolean lteq(final Money money) {

		this.checkCurrenciesMatch(money);
		return this.compareAmount(money) <= 0;
	}

	/**
	 * Multiply this <tt>Money</tt> by an integral factor.
	 *
	 * The scale of the returned <tt>Money</tt> is equal to the scale of 'this'
	 * <tt>Money</tt>.
	 */
	public Money times(final int factor) {

		final BigDecimal newFactor = new BigDecimal(factor);
		final BigDecimal newAmount = this.mAmount.multiply(newFactor);
		return new Money(newAmount, this.mCurrency, this.mRounding);
	}

	/**
	 * Multiply this <tt>Money</tt> by an non-integral factor (having a decimal
	 * point).
	 *
	 * <P>
	 * The scale of the returned <tt>Money</tt> is equal to the scale of 'this'
	 * <tt>Money</tt>.
	 */
	public Money times(final double factor) {

		BigDecimal newAmount = this.mAmount.multiply(this.asBigDecimal(factor));
		newAmount = newAmount.setScale(this.getNumDecimalsForCurrency(), this.mRounding);

		return new Money(newAmount, this.mCurrency, this.mRounding);
	}

	/**
	 * Divide this <tt>Money</tt> by an integral divisor.
	 *
	 * <P>
	 * The scale of the returned <tt>Money</tt> is equal to the scale of 'this'
	 * <tt>Money</tt>.
	 */
	public Money div(final int aDivisor) {

		final BigDecimal divisor = new BigDecimal(aDivisor);
		final BigDecimal newAmount = this.mAmount.divide(divisor, this.mRounding);
		return new Money(newAmount, this.mCurrency, this.mRounding);
	}

	/**
	 * Divide this <tt>Money</tt> by an non-integral divisor.
	 *
	 * <P>
	 * The scale of the returned <tt>Money</tt> is equal to the scale of 'this'
	 * <tt>Money</tt>.
	 */
	public Money div(final double aDivisor) {

		final BigDecimal newAmount = this.mAmount.divide(this.asBigDecimal(aDivisor), this.mRounding);
		return new Money(newAmount, this.mCurrency, this.mRounding);
	}

	/** Return the absolute value of the amount. */
	public Money abs() {

		return this.isPlus() ? this : this.times(-1);
	}

	/** Return the amount x (-1). */
	public Money negate() {

		return this.times(-1);
	}

	/**
	 * Returns {@link #getAmount()}.getPlainString() + space +
	 * {@link #getCurrency()}.getSymbol().
	 *
	 * <P>
	 * The return value uses the runtime's <em>default locale</em>, and will not
	 * always be suitable for display to an end user.
	 */
	@Override
	public String toString() {

		return this.mAmount.toPlainString() + " "
				+ this.mCurrency.getSymbol();
	}

	/**
	 * Like {@link BigDecimal#equals(java.lang.Object)}, this <tt>equals</tt> method
	 * is also sensitive to scale.
	 *
	 * For example, <tt>10</tt> is <em>not</em> equal to <tt>10.00</tt> The
	 * {@link #eq(Money)} method, on the other hand, is <em>not</em> sensitive to
	 * scale.
	 */
	@Override
	public boolean equals(final Object aThat) {

		if (this == aThat)
			return true;
		if (!(aThat instanceof Money))
			return false;
		final Money that = (Money) aThat;
		// the object fields are never null :
		boolean result = (this.mAmount.equals(that.mAmount));
		result = result && (this.mCurrency.equals(that.mCurrency));
		result = result && (this.mRounding == that.mRounding);
		return result;
	}

	@Override
	public int hashCode() {

		if (this.fHashCode == 0) {

			this.fHashCode = Money.HASH_SEED;
			this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.mAmount.hashCode();
			this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.mCurrency.hashCode();
			this.fHashCode = (Money.HASH_FACTOR * this.fHashCode) + this.mRounding.hashCode();
		}
		return this.fHashCode;
	}

	@Override
	public int compareTo(final Money aThat) {

		final int EQUAL = 0;

		if (this == aThat)
			return EQUAL;

		// the object fields are never null
		int comparison = this.mAmount.compareTo(aThat.mAmount);
		if (comparison != EQUAL)
			return comparison;

		comparison = this.mCurrency.getCurrencyCode()
				.compareTo(aThat.mCurrency.getCurrencyCode());
		if (comparison != EQUAL)
			return comparison;

		comparison = this.mRounding.compareTo(aThat.mRounding);
		if (comparison != EQUAL)
			return comparison;

		return EQUAL;
	}

	// PRIVATE //

	/**
	 * The money amount. Never null.
	 *
	 * @serial
	 */
	private BigDecimal mAmount;

	/**
	 * The currency of the money, such as US Dollars or Euros. Never null.
	 *
	 * @serial
	 */
	private final Currency mCurrency;

	/**
	 * The rounding style to be used. See {@link BigDecimal}.
	 *
	 * @serial
	 */
	private final RoundingMode mRounding;

	/**
	 * Pole klasy reprezentuje domyślną instancję obiektu klasy, z której korzystamy
	 * w momencie tworzenia obiektu z domyślnymi parametrami. Dla tego scenariusza
	 * tworzenia obiektu wywoływany jest domyslny konstruktor.
	 */
	private static Currency DEFAULT_CURRENCY;

	/**
	 * The default rounding style to be used if no currency is passed to the
	 * constructor. See {@link BigDecimal}.
	 */
	private static RoundingMode DEFAULT_ROUNDING;

	/** @serial */
	private int fHashCode;
	private static final int HASH_SEED = 23;
	private static final int HASH_FACTOR = 37;

	/**
	 * Determines if a deserialized file is compatible with this class.
	 *
	 * Maintainers must change this value if and only if the new version of this
	 * class is not compatible with old versions. See Sun docs for <a
	 * href=http://java.sun.com/products/jdk/1.1/docs/guide
	 * /serialization/spec/version.doc.html> details. </a>
	 *
	 * Not necessary to include in first version of the class, but included here as
	 * a reminder of its importance.
	 */
	private static final long serialVersionUID = 7526471155622776147L;

	/**
	 * Always treat de-serialization as a full-blown constructor, by validating the
	 * final state of the de-serialized object.
	 */
	private void readObject(final ObjectInputStream inputStream) throws ClassNotFoundException, IOException {

		// always perform the default de-serialization first
		inputStream.defaultReadObject();
		// defensive copy for mutable date field
		// BigDecimal is not technically immutable, since its non-final
		this.mAmount = new BigDecimal(this.mAmount.toPlainString());
		// ensure that object state has not been corrupted or tampered with maliciously
		this.validateState();
	}

	private void writeObject(final ObjectOutputStream outputStream) throws IOException {

		// perform the default serialization for all non-transient, non-static fields
		outputStream.defaultWriteObject();
	}

	private void validateState() {

		if (Objects.isNull(this.mAmount))
			throw new IllegalArgumentException("Amount cannot be null");

		if (Objects.isNull(this.mCurrency))
			throw new IllegalArgumentException("Currency cannot be null");

		if (this.mAmount.scale() > this.getNumDecimalsForCurrency())
			throw new IllegalArgumentException("Number of decimals is " + this.mAmount.scale()
					+ ", but currency only takes "
					+ this.getNumDecimalsForCurrency()
					+ " decimals.");
	}

	private int getNumDecimalsForCurrency() {

		return this.mCurrency.getDefaultFractionDigits();
	}

	private void checkCurrenciesMatch(final Money money) {

		if (!this.mCurrency.equals(money.getCurrency()))
			throw new MismatchedCurrencyException(money.getCurrency() + " doesn't match the expected currency : "
					+ this.mCurrency);
	}

	/** Ignores scale: 0 same as 0.00 */
	private int compareAmount(final Money money) {

		return this.mAmount.compareTo(money.mAmount);
	}

	private BigDecimal asBigDecimal(final double decimal) {

		final String asString = Double.toString(decimal);
		return new BigDecimal(asString);
	}
}
