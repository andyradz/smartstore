/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package com.codigo.smartstore.database.domain.domain;

/// **
// *
// * @author andrzej.radziszewski
// */
// @XmlRootElement(namespace = "")
//// XmLElementWrapper generates a wrapper element around XML representation
//// @XmlElementWrapper(name = "bookList")
//// XmlElement sets the name of the entities
// @XmlRootElement(name = "countries")
// @XmlAccessorType(XmlAccessType.FIELD)
// public class XmlCountries {
//
// @XmlElement(name = "country")
// private List<XmlCountry> countries;
//
// public XmlCountries() {
//
// this.countries = Lists.mutable.empty();
// }
//
// public List<XmlCountry> getCountries() {
//
// return this.countries;
// }
//
// public void setCountries(final List<XmlCountry> countries) {
//
// this.countries = countries;
// }
//
// }

class Book {

	protected void method(final float value) {

	}

	protected void method(final String value) {

	}

	public void setName(final double value) {

		System.out.println("Klasa Book");
	}

	public static void main(final String[] args) {

		new Book().method("12");
		new Book().method(10);
		new Book().method(.1F);
	}
}

class Magazine
		extends
		Book {

	protected void method(final int value) {

	}

	public void setName(final int value) {

		System.out.println("Klasa Magazine");
	}

	public void setName(final String value) {

		System.out.println("Klasa Magazine string");
	}
}

class A {

	@Override
	public String toString() {

		return "klasa b";
	}
}

class B
		extends
		A {

	@Override
	public String toString() {

		return "klasa a";
	}
}

// https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java

// kowariancja występuje w wyniku funkcji
// zwraca obiekt poczhodne od bazowego ->

// kontrwaraqncja występuje w parametrze funkcji
// pobiera obiekty bazowe do jegopodtypue <-

public class C {

	enum Days {

		MAONDAY,
		T,
		W
	}

	public static <T extends A> void m1(final T d) {

		System.out.println(d);
	}

	public A m2() {

		return new B();
	}

	public static void main(final String[] args) {

		m1(new B());
		m1(new A());

		final Magazine magazine = new Magazine();
		magazine.setName(1);
		magazine.setName(1.8);
		magazine.setName("Mama");

		magazine.method(1);
		magazine.method("1");
		magazine.method(1f);

		new Book();
		new Book();
		// final Magazine downcasting = (Magazine) b1; // downcasting
		final Book upcasting = magazine;
		// System.out.println(downcasting);
		System.out.println(upcasting);

	}
}
