package com.codigo.smartstore.database.domain.concurrent;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public class ForLoopPrimes {

	private static Logger log = Logger.getLogger(ForLoopPrimes.class);

	public static Set<Integer> findPrimes(final int maxPrimeTry) {

		final Set<Integer> s = new HashSet<>();

		// The candidates to try (1 is not a prime number by definition!)
		outer: for (int i = 2; i <= maxPrimeTry; i++) {

			// Only need to try up to sqrt(i) - see notes
			final int maxJ = (int) Math.sqrt(i);

			// Our divisor candidates
			for (int j = 2; j <= maxJ; j++)
				// If we can divide exactly by j, i is not prime
				if (((i / j) * j) == i)
					continue outer;

			// If we got here, it's prime
			s.add(i);
		}

		return s;
	}

	public static void main(final String args[]) {

		final int maxPrimeTry = 9999999;

		final long startTime = System.currentTimeMillis();

		final Set<Integer> s = ForLoopPrimes.findPrimes(maxPrimeTry);

		final long timeTaken = System.currentTimeMillis() - startTime;

		s.stream()
				.sorted()
				.forEach(log::info);

		log.info("Time taken: " + timeTaken);
	}
}