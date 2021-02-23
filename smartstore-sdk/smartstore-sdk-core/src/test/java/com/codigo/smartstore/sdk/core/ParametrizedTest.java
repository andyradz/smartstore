package com.codigo.smartstore.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/// https://www.arhohuttunen.com/junit-5-parameterized-tests/
public @RunWith(value = Parameterized.class) class ParametrizedTest {

	private final double member1;
	private final double member2;
	private final double summary;
	private Airthmatic airthmetic;

	public ParametrizedTest(final double member1, final double member2, final double summary) {

		super();

		this.member1 = member1;
		this.member2 = member2;
		this.summary = summary;
	}

	@BeforeEach
	public void initalize() {

		this.airthmetic = new Airthmatic();
	}

	@Parameters(name = "Run {index}: member1={0}, member2={1}, summary={2}")
	public Iterable<Double[]> input() {

		return Arrays.asList(new Double[][] { { 1., 2., 3. }, { .0, .0, .0 }, { -1., 1., .0 } });
	}

	@Test
	void testAirtimetic() {

		System.out.println("Sum of numbers is = " + this.summary);
		assertEquals(this.summary, this.airthmetic.sum(this.member1, this.member2));
	}
}

class Airthmatic {

	double sum(final double member1, final double member2) {

		return member1 + member2;
	}
}